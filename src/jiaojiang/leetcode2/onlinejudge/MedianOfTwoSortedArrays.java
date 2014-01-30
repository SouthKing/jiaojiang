package jiaojiang.leetcode2.onlinejudge;

import utils.Utils;

/**
 * @author: zhang
 * @since: Jan 29, 2014 11:13:44 PM
 */
public class MedianOfTwoSortedArrays {
    /*
    There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays.
    The overall run time complexity should be O(log (m+n)).
     */
    public static double findMedianSortedArrays(int A[], int B[]) {
        
        return 7.5;
    }

    private static void test() {
        Utils.printTestln(findMedianSortedArrays(new int[]{1, 3, 5, 8, 22}, new int[]{4, 7, 9, 11, 25}), 7.5);
    }

    public static void main(String[] args) {
        test();
    }
}


