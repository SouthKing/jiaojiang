package utils;

import java.util.List;

/**
 * @author: mizhang
 * @since: Sep 10, 2013 10:52:40 AM
 */
public class Utils {
    public static void printTestln(Object get, Object expected) {
        if (get.equals(expected)) {
            System.out.println("get: " + get.toString() + ", expected: " + expected.toString());
        } else {
            System.out.println("[ERROR] get: " + get.toString() + ", expected: " + expected.toString());
        }
    }

    public static void printTestBooleanArrayln(boolean[] get, boolean[] expected) {
        for (int i = 0; i < get.length; i++) {
            if (get == expected) {
                System.out.println("get: " + get[i] + ", expected: " + expected[i]);
            } else {
                System.out.println("[ERROR] get: " + get[i] + ", expected: " + expected[i]);
            }
        }
        System.out.println();
    }

    public static void printIntArray(int[] data) {
        for (int i : data) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    public static void printList(List data) {
        for (Object o : data) {
            System.out.print(o.toString() + "\t");
        }
        System.out.println("");
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
            System.out.println("[ERROR] Integer Array Lengths do not match: " + getLength + " vs " + expected);
        }
        length = Math.min(getLength, expectedLength);
        for (int i = 0; i < length; i++) {
            if (get[i] == expected[i]) {
                System.out.println("get: " + get[i] + ", expected: " + expected[i]);
            } else {
                System.out.println("[ERROR] get: " + get[i] + ", expected: " + expected[i]);
            }
        }
        System.out.println();
    }

    public static void printTestIntListln(List<Integer> get, List<Integer> expected) {
        int getSize = get.size(), expectedSize = expected.size(), size;
        if (getSize != expectedSize) {
            System.out.println("[ERROR] Integer List Sizes do not match: " + getSize + " vs " + expected.size());
        }
        size = Math.min(getSize, expectedSize);
        for (int i = 0; i < size; i++) {
            if (get.get(i) == expected.get(i)) {
                System.out.println("get: " + get.get(i) + ", expected: " + expected.get(i));
            } else {
                System.out.println("[ERROR] get: " + get.get(i) + ", expected: " + expected.get(i));
            }
        }
        System.out.println();
    }
}
