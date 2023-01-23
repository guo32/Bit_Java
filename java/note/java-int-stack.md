# Java: Stack 구현[int]
Java를 사용하여 자료구조 stack을 구현해보았다.

# 👾 Java로 Stack 구현하기(정수형)

- `public boolean empty()` : 스택이 공백인지 아닌지 확인하는 메소드
    - true: 공백
    - false: 공백 아님
- `public int size()` : 스택의 사이즈 반환
- `public int peek()` : 스택의 가장 위에 위치하는 원소의 값을 반환
- `public int pop()` : 스택의 가장 위에 위치하는 원소를 제거 후 해당 값을 반환
- `public void push(int e)` : 스택의 가장 위에 파라미터로 들어온 값을 삽입
- `public int search(int e)` : 스택의 가장 위부터 파라미터로 들어온 값을 검색, 가장 위에 위치하고 있는 값은 1

✔ 참고 [[https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html#search(java.lang.Object)](https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html#search(java.lang.Object))]

🔌 code

    package stack;

    import java.util.EmptyStackException;

    public class Stack {
        private int[] array = new int[0];

        public boolean empty() {
            if (array.length == 0) {
                return true;
            }
            return false;
        }

        public int size() {
            return array.length;
        }

        public int peek() {
            if(!empty()) {
                return array[size() - 1];
            }
            return -1;
        }

        public int pop() {
            if (!empty()) {
                int res = peek();
                int[] temp = new int[size() - 1];
                for (int i = 0; i < size() - 1; i++) {
                    temp[i] = array[i];
                }
                array = temp;
                return res;
            }
            return -1;
        }

        public void push(int e) {
            int[] temp = new int[size() + 1];
            for (int i = 0; i < size(); i++) {
                temp[i] = array[i];
            }
            temp[size()] = e;
            array = temp;
        }

        public int search(int e) {
            for (int i = size() - 1; i >= 0; i--) {
                if (array[i] == e) {
                    return size() - i;
                }
            }
            return -1;
        }
    }
