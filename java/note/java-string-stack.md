# πΎ Javaλ‘ Stack κ΅¬ννκΈ°(λ¬Έμμ΄)

λ¬Έμμ΄ λ°°μ΄κ³Ό μ μν λ³μ topμ μ¬μ©νμ¬ μ€νμ κ΅¬ννλ€.

- `public boolean empty()` : μ€νμ΄ κ³΅λ°±μΈμ§ μλμ§ νμΈνλ λ©μλ
    - true: κ³΅λ°±(topμ κ°μ΄ -1)
    - false: κ³΅λ°± μλ
- `public int size()` : νμ¬ μ€νμ ν¬κΈ°λ₯Ό λ°ννλ λ©μλ
- `public String peek()` : νμ¬ μ€νμ κ°μ₯ μμ μμΉνλ μμμ κ°μ λ°ννλ λ©μλ, μ€νμ΄ κ³΅λ°±μΌ λ null λ°ν
- `public void push(String data)` : νλΌλ―Έν°λ‘ λμ΄μ¨ λ¬Έμμ΄ λ°μ΄ν°λ₯Ό νμ¬ μ€νμ κ°μ₯ μμ μ½μνλ λ©μλ(top μ¦κ°)
- `public String pop()` : νμ¬ μ€νμ κ°μ₯ μμ μμΉνλ μμλ₯Ό μ κ±° ν ν΄λΉ μμλ₯Ό λ°ννλ λ©μλ(top κ°μ)
- `public int search(String data)` : νλΌλ―Έν°λ‘ λμ΄μ¨ λ¬Έμμ΄ λ°μ΄ν°μ κ°μ΄ μ΄λ μμΉμ μλμ§ λ°ννλ λ©μλ, νμ¬ μ€νμ κ°μ₯ μλΆν° 1μ΄λ©° μ‘΄μ¬νμ§ μλ κ²½μ° -1 λ°ν

β μ°Έκ³  [[https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html#search(java.lang.Object)](https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html#search(java.lang.Object))]

π code

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
