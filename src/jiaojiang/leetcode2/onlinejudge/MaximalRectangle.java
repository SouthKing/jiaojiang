package jiaojiang.leetcode2.onlinejudge;

import utils.Utils;

/**
 * @author: zhang
 * @since: Jan 2, 2014 9:59:53 PM
 */
public class MaximalRectangle {
    /*
    Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
     */
    public static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length, maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
            }
        }

        return 0;
    }

    private static void test() {
        Utils.printTestln(maximalRectangle(new char[][]{"101".toCharArray(),
                "100".toCharArray(),
                "100".toCharArray()}), 4);

    }

    public static void main(String[] args) {
        test();
    }
}
