package jiaojiang.leetcode2.onlinejudge;

import utils.Utils;

/**
 * @author: zhang
 * @since: Jan 23, 2014 11:28:51 PM
 */
public class NQueensII {
    /*
    Follow up for N-Queens problem.

    Now, instead outputting board configurations, return the total number of distinct solutions.

    // see 8-queens.png
     */
    public static int totalNQueens(int n) {
        return 1;
    }

    private static void test() {
        int[] n = new int[]{1,2, 3, 4, 5};
        int[] q = new int[]{1, 1 ,1 , 1, 1};
        for (int i = 0; i < n.length; i++) {
            Utils.printTestln(totalNQueens(n[i]), q[i]);
        }
    }
    public static void main(String[] args) {
        test();
    }
}
