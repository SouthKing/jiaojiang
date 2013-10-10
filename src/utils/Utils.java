package utils;

import java.util.List;

/**
 * @author: mizhang
 * @since: Sep 10, 2013 10:52:40 AM
 */
public class Utils {
    public static void println(Object get, Object expected) {
        System.out.println("get: " + get.toString() + ", expected: " + expected.toString());
    }

    public static void printTestBooleanArrayln(boolean[] get, boolean[] expected) {
        for (int i = 0; i < get.length; i++) {
            System.out.println("get: " + get[i] + ", expected: " + expected[i]);
        }
        System.out.println();
    }

    public static void printIntArray(int[] data) {
        for (int i : data) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    public static void printIntList(List<Integer> data) {
        for (int i : data) {
            System.out.print(i + "\t");
        }
        System.out.println("");
    }

    public static void printTestIntArrayln(int[] get, int[] expected) {
        int getLength = get.length, expectedLength = expected.length, length;
        if (getLength != expectedLength) {
            System.out.println("Integer Array Lengths do not match: " + getLength + " vs " + expected);
        }
        length = Math.min(getLength, expectedLength);
        for (int i = 0; i < length; i++) {
            System.out.println("get: " + get[i] + ", expected: " + expected[i]);
        }
        System.out.println();
    }

    public static void printTestIntListln(List<Integer> get, List<Integer> expected) {
        int getSize = get.size(), expectedSize = expected.size(), size;
        if (getSize != expectedSize) {
            System.out.println("Integer List Sizes do not match: " + getSize + " vs " + expected);
        }
        size = Math.min(getSize, expectedSize);
        for (int i = 0; i < size; i++) {
            System.out.println("get: " + get.get(i) + ", expected: " + expected.get(i));
        }
        System.out.println();
    }
}
