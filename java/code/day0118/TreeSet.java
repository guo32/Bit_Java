package day0118;

import model.Board2DTO;

public class TreeSet implements Set {
    public int[] array = {};
    public Board2DTO[] boardArray = new Board2DTO[0];
    @Override
    public void add(int element) {
        if (!contains(element)) {
            int[] temp = new int[array.length + 1];
            for (int i = 0; i < array.length; i++) {
                temp[i] = array[i];
            }
            temp[array.length] = element;
            array = temp;
            sort();
        }
    }

    public void sort() {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public void printSet() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    @Override
    public boolean contains(int element) {
        return indexOf(element) != -1;
    }

    @Override
    public int indexOf(int element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void set(int index, int element) {
        array[index] = element;
    }

    @Override
    public void removeByIndex(int index) {
        int[] temp = new int[array.length - 1];
        for (int i = 0; i < index; i++) {
            temp[i] = array[i];
        }
        for (int i = index + 1; i < array.length; i++) {
            temp[i - 1] = array[i];
        }
        array = temp;
    }

    @Override
    public void removeByElement(int element) {
        if (contains(element)) {
            removeByIndex(indexOf(element));
        }
    }
}
