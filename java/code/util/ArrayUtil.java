package util;

import day0111.Board;
import day0111.Student;

/*
배열을 사용할 때 도움이 될만한 메소드를 모아둔 ArrayUtil 클래스
 */
public class ArrayUtil {
    // 1. int[]
    // A. size() : 현재 배열의 길이를 반환
    public static int size(int[] array) {
        return array.length;
    }

    public static int size(Board[] array) {
        return array.length;
    }

    public static int size(Student[] array) {
        return array.length;
    }

    // B. isEmpty()
    public static boolean isEmpty(int[] array) {
        return size(array) == 0;
    }

    public static boolean isEmpty(Board[] array) {
        return size(array) == 0;
    }

    public static boolean isEmpty(Student[] array) {
        return size(array) == 0;
    }

    // C. get()
    public static int get(int[] array, int index) {
        return array[index];
    }

    public static Board get(Board[] array, int index) {
        return array[index];
    }

    public static Student get(Student[] array, int index) {
        return array[index];
    }

    // D. contains()
    public static boolean contains(int[] array, int element) {
        for(int i = 0; i < size(array); i++) {
            if(element == get(array, i)) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(Board[] array, Board board) {
        for(Board b : array) {
            if (board.equals(b)) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(Student[] array, Student student) {
        for(int i = 0; i < size(array); i++) {
            if (student.equals(get(array, i))) {
                return true;
            }
        }
        return false;
    }

    // E. indexOf() : 해당 배열에서 특정 값이 어디에 있는지 확인
    public static int indexOf(int[] array, int element) {
        for(int i = 0; i < size(array); i++) {
            if(element == get(array, i)) {
                return i;
            }
        }
        return -1;
    }

    public static int indexOf(Board[] array, int id) {
        for(int i = 0; i < size(array); i++) {
            if(id == get(array, i).getId()) return i;
        }
        return -1;
    }

    public static int indexOf(Board[] array, Board board) {
        for(int i = 0; i < size(array); i++) {
            if(board.equals(get(array, i))) {
                return i;
            }
        }
        return -1;
    }

    public static int indexOf(Student[] array, int id) {
        for(int i = 0; i < size(array); i++) {
            if(id == get(array, i).getId()) return i;
        }
        return -1;
    }

    // F. add()
    public static int[] add(int[] array, int element) {
        int[] temp = new int[size(array) + 1];
        for(int i = 0; i < size(array); i++) {
            temp[i] = get(array, i);
        }
        temp[size(array)] = element;

        return temp;
    }

    public static Board[] add(Board[] array, Board board) {
        Board[] temp = new Board[size(array) + 1];
        for (int i = 0; i < size(array); i++) {
            temp[i] = get(array, i);
        }
        temp[size(array)] = board;

        return temp;
    }

    public static Student[] add(Student[] array, Student student) {
        Student[] temp = new Student[size(array) + 1];
        for(int i = 0; i < size(array); i++) {
            temp[i] = get(array, i);
        }
        temp[size(array)] = student;

        return temp;
    }

    // G. add()
    public static int[] add(int[] array, int index, int element) {
        /* ver. hard
        int[] temp = new int[size(array) + 1];
        for(int i = 0; i < index; i++) {
            temp[i] = get(array, i);
        }
        temp[index] = element;
        for(int i = index; i < size(array); i++) {
            temp[i + 1] = get(array, i);
        }
        */

        int[] temp = new int[0];
        for(int i = 0; i < size(array);) {
            if(i != index) {
                temp = add(temp, get(array, i));
                i++;
            } else {
                temp = add(temp, element);
            }
        }

        return temp;
    }

    public static Board[] add(Board[] array, int index, Board board) {
        Board[] temp = new Board[0];
        for(int i = 0; i < size(array);) {
            if(i != index) {
                temp = add(temp, get(array, i));
                i++;
            } else {
                temp = add(temp, board);
            }
        }
        return temp;
    }

    public static Student[] add(Student[] array, int index, Student student) {
        Student[] temp = new Student[0];
        for(int i = 0; i < size(array);) {
            if (i != index) {
                temp = add(temp, get(array, i));
                i++;
            } else {
                temp = add(temp, student);
            }
        }
        return temp;
    }

    // H. set()
    public static int set(int[] array, int index, int element) {
        int original = get(array, index);
        array[index] = element;

        return original;
    }

    public static Board set(Board[] array, int index, Board board) {
        Board original = get(array, index);
        array[index] = board;

        return original;
    }

    public static Student set(Student[] array, int index, Student student) {
        Student original = get(array, index);
        array[index] = student;

        return original;
    }

    // I. removeByIndex()
    public static int[] removeByIndex(int[] array, int index) {
        int[] temp = new int[0];
        for(int i = 0; i < size(array); i++) {
            if(i != index) {
                temp = add(temp, get(array, i));
            }
        }
        return temp;
    }

    public static Board[] remove(Board[] array, int index) {
        Board[] temp = new Board[0];
        for(int i = 0; i < size(array); i++) {
            if(i != index) {
                temp = add(temp, get(array, i));
            }
        }
        return temp;
    }

    public static Student[] removeByIndex(Student[] array, int index) {
        Student[] temp = new Student[0];
        for(int i = 0; i < size(array); i++) {
            if (i != index) {
                temp = add(temp, get(array, i));
            }
        }
        return temp;
    }

    // J. removeByElement()
    public static int[] removeByElement(int[] array, int element) {
        return removeByIndex(array, indexOf(array, element));
    }

    public static Board[] remove(Board[] array, Board board) {
        return remove(array, indexOf(array, board));
    }

    public static Student[] removeByElement(Student[] array, Student student) {
        return removeByIndex(array, indexOf(array, student.getId()));
    }

    // K. sort()
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
