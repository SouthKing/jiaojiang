package jiaojiang.leetcode2.onlinejudge;

import utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: mizhang
 * @since: Jan 9, 2014 3:14:31 PM
 */
public class Subset {
    /*
    Given a set of distinct integers, S, return all possible subsets.

    Note:
    Elements in a subset must be in non-descending order.
    The solution set must not contain duplicate subsets.
    For example,
    If S = [1,2,3], a solution is:

    [
      [3],
      [1],
      [2],
      [1,2,3],
      [1,3],
      [2,3],
      [1,2],
      []
    ]
    */
    public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ret.add(new ArrayList<Integer>());

        Arrays.sort(S);
        for (int i = 0; i < S.length; i++) {
            for (int j = 0, l = ret.size(); j < l; j++) {
                ArrayList<Integer> subset = new ArrayList<Integer>(ret.get(j));
                subset.add(S[i]);
                ret.add(subset);
            }
        }

        return ret;
    }

    private static void test() {
        Utils.printListListln(subsets(new int[]{1, 2, 3}));
    }

    public static void main(String[] args) {
        test();
    }
}
