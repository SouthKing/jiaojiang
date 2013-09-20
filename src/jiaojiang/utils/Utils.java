package jiaojiang.utils;

/**
 * @author: mizhang
 * @since: Sep 10, 2013 10:52:40 AM
 */
public class Utils {
    public static void println(Object get, Object expected) {
        System.out.println("get: " + get.toString() + ", expected: " + expected.toString());
    }

    public static void printBooleanArrayln(boolean[] get, boolean[] expected) {
        for (int i = 0; i < get.length; i++) {
            System.out.println("get: " + get[i] + ", expected: " + expected[i]);
        }
        System.out.println();
    }

    public static void printArray(int[] data) {
        for (int i : data) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    public static void printIntArrayln(int[] get, int[] expected) {
        for (int i = 0; i < get.length; i++) {
            System.out.println("get: " + get[i] + ", expected: " + expected[i]);
        }
        System.out.println();
    }
}
