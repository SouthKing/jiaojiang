package jiaojiang.leetcode.onlinejudge;

import java.util.ArrayList;
import java.util.Arrays;

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
        Arrays.sort(num);
        
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < num.length - 3; ) {
            for (int j = i + 1; j < num.length - 2; ) {
                int start = j + 1, end = num.length - 1;
                while (start < end) {
                    if (num[start] + num[end] == target - num[i] - num[j]) {
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(num[i]);
                        list.add(num[j]);
                        list.add(num[start]);
                        list.add(num[end]);
                        ret.add(list);
                        while (++start < end && num[start - 1] == num[start]);
                        while (start < --end && num[end] == num[end + 1]);
                    } else if (num[start] + num[end] < target - num[i] - num[j]) {
                        start++;
                    } else {
                        end--;
                    }
                }
                while (++j < num.length - 2 && num[j - 1] == num[j]);
            }
            while(++i < num.length - 3 && num[i - 1] == num[i]);
        }

        return ret;
    }

    private static ArrayList<ArrayList<Integer>> twoSum(int[] num, int target, int start, int end) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();

        int i = start, j = end;
        while (i < j) {
            if (num[i] + num[j] == target) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(num[i]);
                list.add(num[j]);
                ret.add(list);
                i++;
                j--;
            } else if (num[i] + num[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        
        return ret;
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
        System.out.println("=========================");
        test(new int[] {-3, -2, -1, 0, 0, 1, 2, 3}, 0);//[[-3,-2,2,3],[-3,-1,1,3],[-3,0,0,3],[-3,0,1,2],[-2,-1,0,3],[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
    }

    public static void main(String[] args) {
        test();
    }
}
