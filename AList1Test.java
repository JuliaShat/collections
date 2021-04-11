package com.javacourse.lists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class AList1Test {
    private AList1 aList1;
    private AList1 aList2;
    private AList1 aList3;
    private int[] array;

    @BeforeEach
    public void start () {
    array = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
    aList1 = new AList1(array);
    aList2 = new AList1 (5);
    aList3 = new AList1 ();
    }

    @Test
    public void test_clear () {
        aList1.clear();
        int[] actual = aList1.toArray();
        int[] expected = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test_size (){
        int actual =  aList2.size();;
        int expected = 5;
        Assertions.assertEquals (expected, actual);
    }

    @Test
    public void test_get (){
        int actual = aList1.get(4);
        int expected = 4;
        Assertions.assertEquals (expected, actual);
    }

    @Test
    public void test_addValue () {
        aList2.add(1);
        int[] actual = aList2.toArray();
        int[] expected = {1, 0, 0, 0, 0};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test_addValueAtIndex() {
        aList1.add(0, 7);
        int[] actual = aList1.toArray();
        int[] expected = {7, 1, 2, 3, 4, 5, 6, 7, 8};
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void test_true_contains() {
      boolean actual = aList1.contains(1);
      Assertions.assertTrue(actual);
    }

    @Test
    public void test_false_contains() {
    boolean actual = aList1.contains(12);
    Assertions.assertFalse(actual);
    }

    @Test
    public void test_set() {
    aList3.set(3, 10);
    int[] actual = aList3.toArray();
    int[] expected = {0, 0, 0, 10, 0, 0, 0, 0, 0, 0};
     Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test_print() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        aList1.print();
        String expected = Arrays.toString(array) + "\r\n";
        String actual = outputStream.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_toArray() {
        int[] expected = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
       int[] actual = aList3.toArray();
      Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void test_removeAll() {
        int[] arr = new int[]{3, 5};
       aList1.removeAll(arr);
        int[] expected = {0, 1, 2, 0, 4, 0, 6, 7, 8};
      int[] actual = aList1.toArray();
      Assertions.assertArrayEquals(actual, expected);
    }
}
