package jiaojiang.leetcode.onlinejudge;

import java.util.ArrayList;

/**
 * @author: mizhang
 * @since: Sep 24, 2013 2:29:22 PM
 */
public class FourSum {
    /*
    Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

    Note:

        Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ? b ? c ? d)
        The solution set must not contain duplicate quadruplets.

        For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

        A solution set is:
        (-1,  0, 0, 1)
        (-2, -1, 1, 2)
        (-2,  0, 0, 2)
     */
    public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {

        return null;
    }

    public static void test(int[] num, int target) {
        for (ArrayList<Integer> l : fourSum(num, target)) {
            for (int i : l) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }

    public static void test() {
        test(new int[] {1, 0, -1, 0, -2, 2}, 0);
    }

    public static void main(String[] args) {
        test();
    }
}
