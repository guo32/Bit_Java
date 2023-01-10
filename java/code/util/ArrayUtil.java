package util;
/*
배열을 사용할 때 도움이 될만한 메소드를 모아둔 ArrayUtil 클래스
 */
public class ArrayUtil {
    // 1. contains()
    public static boolean contains(int[] array, int element) {
        for(int i = 0; i < array.length; i++) {
            if(element == array[i]) return true;
        }
        return false;
    }

    // 2. sort()
    public static void sort(int[] array) {
        for(int i = 0; i < array.length - 1; i++) {
            if(array[i] > array[i + 1]) {
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
                i = -1;
            }
        }
    }
}
