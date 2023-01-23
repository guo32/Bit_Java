# Java: Stack 구현[int]

# 👾 Java로 Stack 구현하기(정수형)

- `public boolean empty()` : 스택이 공백인지 아닌지 확인하는 메소드
    - true: 공백
    - false: 공백 아님
- `public int size()` : 스택의 사이즈 반환
- `public int peek()` : 스택의 가장 위에 위치하는 원소의 값을 반환
- `public int pop()` : 스택의 가장 위에 위치하는 원소를 제거 후 해당 값을 반환
- `public void push(int e)` : 스택의 가장 위에 파라미터로 들어온 값을 삽입
- `public int search(int e)` : 스택의 가장 위부터 파라미터로 들어온 값을 검색, 가장 위에 위치하고 있는 값은 1

참고 [[https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html#search(java.lang.Object)]