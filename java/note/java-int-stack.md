# πΎ Javaλ‘ Stack κ΅¬ννκΈ°(μ μν)
Javaλ₯Ό μ¬μ©νμ¬ μλ£κ΅¬μ‘° stackμ κ΅¬νν΄λ³΄μλ€.

- `public boolean empty()` : μ€νμ΄ κ³΅λ°±μΈμ§ μλμ§ νμΈνλ λ©μλ
    - true: κ³΅λ°±
    - false: κ³΅λ°± μλ
- `public int size()` : μ€νμ μ¬μ΄μ¦ λ°ν
- `public int peek()` : μ€νμ κ°μ₯ μμ μμΉνλ μμμ κ°μ λ°ν
- `public int pop()` : μ€νμ κ°μ₯ μμ μμΉνλ μμλ₯Ό μ κ±° ν ν΄λΉ κ°μ λ°ν
- `public void push(int e)` : μ€νμ κ°μ₯ μμ νλΌλ―Έν°λ‘ λ€μ΄μ¨ κ°μ μ½μ
- `public int search(int e)` : μ€νμ κ°μ₯ μλΆν° νλΌλ―Έν°λ‘ λ€μ΄μ¨ κ°μ κ²μ, κ°μ₯ μμ μμΉνκ³  μλ κ°μ 1

β μ°Έκ³  [[https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html#search(java.lang.Object)](https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html#search(java.lang.Object))]

π code

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

# πΎ Javaλ‘ Stack κ΅¬ννκΈ°(μ μν, κ³ μ λ λ°°μ΄)
ν¬κΈ°κ° κ³ μ λ μ μν λ°°μ΄κ³Ό μ μν λ³μ topμ μ¬μ©νμ¬ μ€νμ κ΅¬ννλ€.

π code

    package stack;

    public class Stack3 {
        private int[] array = new int[100];
        private int top;

        public Stack3() {
            top = -1;
        }

        public boolean empty() {
            if (top == -1) {
                return true;
            }
            return false;
        }

        public int size() {
            return top + 1;
        }

        public int peek() {
            if (top != -1) {
                return array[top];
            }
            return -1;
        }

        public void push(int data) {
            top++;
            array[top] = data;
        }

        public int pop() {
            if (top != -1) {
                return array[top--];
            }
            return -1;
        }

        public int search(int data) {
            for (int i = top; i >= 0; i--) {
                if (array[i] == data) {
                    return top - i + 1;
                }
            }
            return -1;
        }
    }
