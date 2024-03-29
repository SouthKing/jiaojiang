package jiaojiang.leetcode2.onlinejudge;

import utils.Utils;

/**
 * @author: zhang
 * @since: Jan 15, 2014 9:10:47 PM
 */
public class RemoveDuplicatesFromSortedArray {
    /*Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

    Do not allocate extra space for another array, you must do this in place with constant memory.

    For example,
    Given input array A = [1,1,2],

    Your function should return length = 2, and A is now [1,2].
    */
    public static int removeDuplicates(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int start, index, pre;
        for (start = 1, index = 1, pre = A[0]; index < A.length; index++) {
            if (A[index] != pre) {
                A[start] = A[index];
                pre = A[start];
                start++;
            }
        }
        return start;
    }

    private static void test() {
        int[] A = new int[]{1, 1, 2};
        int length = removeDuplicates(A);
        for (int i = 0; i < length; i++) {
            System.out.print(A[i] + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        test();
    }
}
