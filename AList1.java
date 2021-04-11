package com.javacourse.lists;

import java.util.Arrays;

public class AList1 implements IList {
    private int[] newArray;
    private int[] newArrayCopy;
    private int newCapacity;


    public AList1() {
        final int CAPACITY = 10;
        newArray = new int[CAPACITY];
    }


    public AList1(int capacity) {
        newCapacity = capacity;
        newArray = new int[newCapacity];
    }


    public AList1(int[] array) {
        newCapacity = array.length;
        newArray = new int[newCapacity];
        System.arraycopy(array, 0, newArray, 0, newCapacity);
    }

    ;


    @Override
    public void clear() {
        Arrays.fill(newArray, 0);
    }

    @Override
    public int size() {
        return newArray.length;
    }

    @Override
    public int get(int index) {
        int result = newArray[index];
        return result;
    }

    @Override
    public boolean add(int value) {
        if (newArray[newArray.length - 1] == 0) {
            for (int i = 0; i < newArray.length; i++) {
                if (newArray[i] == 0) {
                    newArray[i] = value;
                    break;
                }
            }
        } else {
            newArrayCopy = newArray;
            newArray = new int[newArrayCopy.length];
            System.arraycopy(newArrayCopy, 0, newArray, 0, newArrayCopy.length);
        }
        return true;
    }


    @Override
    public boolean add(int index, int value) {
        if (newArray[index] == 0) {
            newArray[index] = value;
        } else {
            newArrayCopy = newArray;
            newArrayCopy = new int[newArray.length + 1];
            System.arraycopy(newArray, 0, newArrayCopy, 0, index);
            newArrayCopy[index] = value;
            int afterIndex = newArray.length - index;
            System.arraycopy(newArray, index, newArrayCopy, index + 1, afterIndex);
            System.out.println(newArrayCopy);
        }
        return true;
    }


    @Override
    public int[] remove(int number) {
        int index;
        newArrayCopy = newArray;
        for (int i = 0; i < newArray.length; i++) {
            if (newArray[i] == number) {
                index = i;
                System.arraycopy(newArray, index + 1, newArrayCopy, index, newArrayCopy.length - index - 1);
            }
        }
        return newArrayCopy;
    }

    @Override
    public int removeByIndex(int index) {
        newArrayCopy = newArray;
        newArray[newArray.length - 1] = 0;
        System.arraycopy(newArray, index + 1, newArray, index, newArray.length - index - 1);
        return 0;
    }

    @Override
    public boolean contains(int value) {
        for (int i = 0; i < newArray.length; i++) {
            if (newArray[i] == value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean set(int index, int value) {
       newArray[index] = value;
        return true;
    }

    @Override
    public void print() {
        System.out.println(Arrays.toString(newArray));
    }

    @Override
    public int[] toArray() {
        return newArray;
    }

    @Override
    public boolean removeAll(int[] ar) {
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < newArray.length; j++) {
                if (ar[i] == newArray[j]) {
                    newArray[j] = 0;
                }
            }
        }
        return true;
    }
}
