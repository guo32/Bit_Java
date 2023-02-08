1. **프로젝트의 목표 및 기능**
    - 외부 데이터 가공 및 삽입, mongoDB를 사용하여 원하는 데이터 추출
    - 구간 및 시간 별 서울 내 유동인구 데이터 검색

2. **데이터 소스 URL (web, api, file 등)**
    - 스마트서울 도시데이터 센서(S-DoT) 유동인구 측정 정보
    - [https://data.seoul.go.kr/dataList/OA-15964/S/1/datasetView.do](https://data.seoul.go.kr/dataList/OA-15964/S/1/datasetView.do)

3. **주요 조회 쿼리**

4. **몽고디비 데이터베이스에 관련된 객체 이름 및 생성 명령어들 목록**
    - 데이터베이스 : bitDB
    - Collection : population
    - 외부 데이터
        - JSON 파일
        - 등록일, 지역, 측정시간, 모델번호, 행정동, 자치구, 방문자 수, 시리얼 번호로 이루어진 약 44만 9천 개의 데이터
        - value 값이 모두 문자열로 저장되어 있어 가공 후 DB에 삽입함

5. **파이썬 연동 시 소스 코드**

```python
# -*- coding: utf-8 -*-
"""
Created on Tue Feb  7 09:18:59 2023

@author: USER
"""

import json
import datetime
import pymongo

conn = pymongo.MongoClient()
db = conn.bitDB
users = db.users

with open('D:/bit/floatingPopulation.json', 'r', encoding = 'UTF-8') as file:
    temp = json.load(file)
    
json_data = temp.get('DATA')

for data in json_data:
    data['reg_dttm'] = datetime.datetime.strptime(data['reg_dttm'], '%Y-%m-%d %H:%M:%S').isoformat()
    data['sensing_time'] = datetime.datetime.strptime(data['sensing_time'], '%Y-%m-%d_%H:%M:%S').isoformat()
    data['visitor_count'] = int(data['visitor_count'])
    db.population.insert_one(data)
```

- 2023년 1월 데이터 중 ‘Gangnam-gu(강남구)’ 내 가장 유동인구가 많은 데이터

```sql
db.population.find({sensing_time : {$gte : "2023-01-01T00:00:00", $lte : "2023-01-31T23:59:59"}, autonomous_district : "Gangnam-gu"}).sort({visitor_count : -1}).limit(1)
```

    - 인덱스 생성 (index 1 관련 jpg 파일)
    - bitDB> db.population.createIndex({visitor_count : -1})
    - visitor_count_-1

- ‘Jamsil6-dong(잠실 6동)’ 데이터 중 유동인구가 300명 이상인 데이터의 센서 시간

```sql
db.population.find({administrative_district : "Jamsil6-dong", visitor_count : {$gte : 300}}, {_id : 0, sensing_time : 1})
```

    - 인덱스 생성 (index 2 관련 jpg 파일)
    - bitDB> db.population.createIndex({administrative_district : 1, visitor_count : 1})
    - administrative_district_1_visitor_count_1

- ‘Guro’를 포함한 autonomous_district 데이터 중 유동인구가 245 이상 250 이하인 데이터

```sql
db.population.find({autonomous_district : {$regex : "Guro"}, visitor_count : {$gte : 245, $lte : 250}})
```

    - 인덱스 생성 (index 3 관련 jpg 파일) : 텍스트 인덱스
    - bitDB> db.population.createIndex({autonomous_district : "text", visitor_count : 1})
    - autonomous_district_text_visitor_count_1

- 유동인구가 가장 많은 5개의 데이터의 아이디를 제외한 측정 시간, 지역, 방문자 수 검색

```sql
db.population.find({}, {_id : 0, administrative_district : 1, sensing_time : 1, visitor_count : 1}).sort({visitor_count : -1}).limit(5)
```

- 마포구를 제외한 유동인구가 700 이상인 2023년 1월 데이터

```sql
db.population.find({autonomous_district : {$ne : "Mapo-gu"}, visitor_count : {$gte : 700}, sensing_time : {$gte : "2023-01-01T00:00:00", $lte : "2023-01-31T23:59:59"}})
```

- 2023년 1월 10일 오후 2시 사이의 강남구의 신사동 데이터를 측정 시간을 기준으로 오름차순 정렬

```sql
db.population.find({sensing_time : {$gte : "2023-01-10T14:00:00", $lt : "2023-01-10T15:00:00"}, autonomous_district : "Gangnam-gu", administrative_district : "Sinsa-dong"}).sort({sensing_time : 1})
```
