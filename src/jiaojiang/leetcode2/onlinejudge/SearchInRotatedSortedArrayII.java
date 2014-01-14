package jiaojiang.leetcode2.onlinejudge;

import utils.Utils;

/**
 * @author: mizhang
 * @since: Jan 14, 2014 3:05:20 PM
 */
public class SearchInRotatedSortedArrayII {
    /*
    Follow up for "Search in Rotated Sorted Array":
    What if duplicates are allowed?

    Would this affect the run-time complexity? How and why?

    Write a function to determine if a given target is in the array.
    */
    public static boolean search(int[] A, int target) {
        int start = 0, end = A.length - 1, mid;

        while (start <= end) {
            mid = (start + end) >>> 1;

            if (A[mid] == target) {
                return true;
            }

            if (A[mid] < target) {
                if (A[mid] > A[start]) {
                    start = mid + 1;
                } else {
                    if (target == A[end]) {
                        return true;
                    }
                    if (target < A[end]) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
            } else {
                if (A[mid] < A[start]) {
                    end = mid - 1;
                } else {
                    if (target == A[start])  {
                        return true;
                    }
                    if (target > A[start]) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
            }
        }

        return false;
    }

    private static void test() {
        Utils.printTestln(search(new int[]{1,1,3,1}, 2), false);
        Utils.printTestln(search(new int[]{1,1,3,1}, 3), true);
        Utils.printTestln(search(new int[]{4,5,6,7,0,1,2}, 0), true);
        Utils.printTestln(search(new int[]{3,4,5,1, 2}, 3), true);
        Utils.printTestln(search(new int[]{3,4,5,1, 2}, 2), true);
        Utils.printTestln(search(new int[]{3,4,5,1, 2}, 11), false);
    }

    public static void main(String[] args) {
        test();
    }
}
