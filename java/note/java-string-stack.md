# 👾 Java로 Stack 구현하기(문자열)

문자열 배열과 정수형 변수 top을 사용하여 스택을 구현했다.

- `public boolean empty()` : 스택이 공백인지 아닌지 확인하는 메소드
    - true: 공백(top의 값이 -1)
    - false: 공백 아님
- `public int size()` : 현재 스택의 크기를 반환하는 메소드
- `public String peek()` : 현재 스택의 가장 위에 위치하는 원소의 값을 반환하는 메소드, 스택이 공백일 때 null 반환
- `public void push(String data)` : 파라미터로 넘어온 문자열 데이터를 현재 스택의 가장 위에 삽입하는 메소드(top 증가)
- `public String pop()` : 현재 스택의 가장 위에 위치하는 원소를 제거 후 해당 원소를 반환하는 메소드(top 감소)
- `public int search(String data)` : 파라미터로 넘어온 문자열 데이터의 값이 어느 위치에 있는지 반환하는 메소드, 현재 스택의 가장 위부터 1이며 존재하지 않는 경우 -1 반환

✔ 참고 [[https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html#search(java.lang.Object)](https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html#search(java.lang.Object))]

🔌 code

    package stack;

    public class Stack2 {
        private String[] array = new String[0];
        private int top = -1;

        public boolean empty() {
            if (top == -1) {
                return true;
            }
            return false;
        }

        public int size() {
            return array.length;
        }

        public String peek() {
            if (!empty()) {
                return array[top];
            }
            return null;
        }

        public void push(String data) {
            String[] temp = new String[size() + 1];
            for (int i = 0; i < size(); i++) {
                temp[i] = array[i];
            }
            temp[++top] = data;
            array = temp;
        }

        public String pop() {
            if (!empty()) {
                String data = array[top];
                String[] temp = new String[top];
                for (int i = 0; i < top; i++) {
                    temp[i] = array[i];
                }
                array = temp;
                top--;
                return data;
            }
            return null;
        }

        public int search(String data) {
            for (int i = top; i >= 0; i--) {
                if (array[i] == data) {
                    return top - i + 1;
                }
            }
            return -1;
        }
    }
