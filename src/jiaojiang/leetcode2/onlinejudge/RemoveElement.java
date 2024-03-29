package jiaojiang.leetcode2.onlinejudge;

import utils.Utils;

/**
 * @author: zhang
 * @since: Jan 26, 2014 12:57:31 PM
 */
public class RemoveElement {
    /*
    Given an array and a value, remove all instances of that value in place and return the new length.

    The order of elements can be changed. It doesn't matter what you leave beyond the new length.
     */
    public static int removeElement(int[] A, int elem) {
        int writeIdx = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != elem) {
                A[writeIdx] = A[i];
                writeIdx++;
            }
        }
        return writeIdx;
    }

    private static void test() {
        Utils.printTestln(removeElement(new int[]{1, 2, 6, 10, 9, 8, 10 , 11}, 10), 6);
    }

    public static void main(String[] args) {
        test();
    }

}
