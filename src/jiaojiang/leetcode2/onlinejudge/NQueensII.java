package jiaojiang.leetcode2.onlinejudge;

import utils.Utils;

import java.util.Set;
import java.util.HashSet;

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
        return totalNQueens(n, 0, new HashSet<Integer>(), new HashSet<Integer>(), new HashSet<Integer>());
    }

    private static int totalNQueens(int n, int row, Set<Integer> col, Set<Integer> diff, Set<Integer> sum) {
        if (row == n) {
            return 1;
        }

        int sol = 0;
        for (int i = 0; i < n; i++) {
            if (!diff.contains(row - i) && !sum.contains(row + i) && !col.contains(i)) {
                diff.add(row - i);
                sum.add(row + i);
                col.add(i);
                sol += totalNQueens(n, row + 1, col, diff, sum);
                diff.remove(row - i);
                sum.remove(row + i);
                col.remove(i);
            }
        }

        return sol;
    }

    private static void test() {
        int[] nq = new int[]{1, 0, 0 , 2, 10, 4, 40, 92};
        for (int i = 0; i < nq.length; i++) {
            Utils.printTestln(totalNQueens(i + 1), nq[i]);
        }
    }
    
    public static void main(String[] args) {
        test();
    }
}
