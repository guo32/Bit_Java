## Java 전문가 405기 수업 노트
<table>
  <tr>
    <th>과정</th>
    <td>Java</td>
  </tr>
  <tr>
    <th>일자</th>
    <td>2023-01-10</td>
  </tr>
</table>

**구조체(Struct)**
* 구조체란, 내가 필요한 데이터 타입들을 모아서 별개의 새로운 데이터 타입을 만들어내는 것이다.
 하지만 자바에서는 구조체를 지원하지 않으므로, 별개의 클래스를 만들고 그 클래스 안에 필요한 데이터 타입들을
 정의하는 형식으로 만들어주게 된다.
* 학생 클래스 예시

      public class Student {
          public int id;
          public String name;
          public int korean;
          public int english;
          public int math;
      }

<hr>

**값에 의한 호출 / 참조에 의한 호출**
<table>
  <tr>
    <th>값에 의한 호출<br>(call by value)</th>
    <td>파라미터의 값이 복사되어 함수로 넘어감 / 특정한 함수에서 값을 변경하더라도 서로 영향을 주지 않음</td>
  </tr>
  <tr>
    <th>참조에 의한 호출<br>(call by reference)</th>
    <td>파라미터의 주소의 값이 함수로 넘어감 / 특정한 함수에서 값을 변경할 경우 본래의 값에 영향을 끼침</td>
  </tr>
</table>

<hr>

**무한 루프**
* while(true) { ... }
* while(0보다 큰 숫자) { ... } / while(1) { ... }
* for( ; ; ) { ... }

**전역 변수(Global Variable)**
* 사용을 권장하지 않음
* 어떤 변수 영역에서나 접근할 수 있는 변수
* The variables that are declared outside the given function

**전역 상수(Global Constants)**
* 사용을 권장함
* 한 번만 값이 할당되고 그 이후로는 값이 변하지 않음
* a literal value to which you assign a name
* final keyword를 사용해 선언함

**null**
* 참조형 데이터 타입에서만 존재하는 일종의 상태
* 데이터의 값이 존재하지 않은 상태

<hr>

**배열(Array)**
* 배열이란, 똑같은 데이터 타입의 공간 여러 개를 하나로 묶어서
 저장할 수 있는 데이터 타입이다.
 배열 공간을 만들기 위해서는
 우리가 해당 공간이 어떤 데이터 타입이 모여 있는지 적고
 []를 통해서 배열이다라는 것을 등록하게 된다. 
 단, 배열을 초기화할 때에는 반드시
 해당 배열이 몇 개의 공간으로 이루어져있는지를 반드시 저장해야 한다.
* 배열 선언

      // 기본형 데이터 타입의 배열은 각 칸이 0으로 초기화가 된다.
      int[] intArray = new int[3];
      
      // 참조형 데이터 타입의 배열은 각 칸이 null로 초기화가 된다.
      String[] stringArray = new String[4];

**다차원 배열**
* 다차원 배열이란, 배열이라는 데이터 타입의 공간 여러 개를 묶어서
 하나의 다른 데이터 타입으로 만든 데이터 타입이다.
 다차원 배열을 만들 때에는
 차원 수만큼 [][]를 붙여주면 된다.
 
**Random Class**
* 0 ~ 1 사이의 랜덤한 실수를 생성함(0 ~ 1 사이의 실수는 거의 무한하다.)
* 특정 범위의 랜덤한 정수를 반환받고자 할 때
   
      // 1부터 100까지의 랜덤한 정수
      random.nextInt(100) + 1
      
* [https://docs.oracle.com/javase/8/docs/api/java/util/Random.html]

**JSON(JavaScript Object Notation)**
* 배열은 대괄호로 묶음
* 객체는 중괄호로 묶음
