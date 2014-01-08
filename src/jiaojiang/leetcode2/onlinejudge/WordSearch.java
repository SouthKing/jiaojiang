package jiaojiang.leetcode2.onlinejudge;

import utils.Utils;

import java.util.List;
import java.util.ArrayList;

/**
 * @author: mizhang
 * @since: Jan 7, 2014 3:37:20 PM
 */
public class WordSearch {
    /*
    Given a 2D board and a word, find if the word exists in the grid.

    The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those
    horizontally or vertically neighboring. The same letter cell may not be used more than once.

    For example,
    Given board =

    [
      ["ABCE"],
      ["SFCS"],
      ["ADEE"]
    ]
    word = "ABCCED", -> returns true,
    word = "SEE", -> returns true,
    word = "ABCB", -> returns false.
    */
    public static boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (exist(board, word, new boolean[m][n], i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean exist(char[][] board, String word, boolean[][] hasVisited, int i, int j, int wStart) {
        if (wStart == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(wStart) || hasVisited[i][j]) {
            return false;
        }
        hasVisited[i][j] = true;
        if (exist(board, word, hasVisited, i - 1, j, wStart + 1)
                || exist(board, word, hasVisited, i, j + 1, wStart + 1)
                || exist(board, word, hasVisited, i + 1, j, wStart + 1)
                || exist(board, word, hasVisited, i, j - 1, wStart + 1)) {
            return true;
        }
        hasVisited[i][j] = false;
        return false;
    }

    private static void test() {
        char[][] board = new char[][] {
                "abce".toCharArray(),
                "sfcs".toCharArray(),
                "adee".toCharArray()
        };

        Utils.printTestln(exist(board, "abcced"), true);
        Utils.printTestln(exist(board, "see"), true);
        Utils.printTestln(exist(board, "abcb"), false);
    }

    public static void main(String[] args) {
        test();
    }
}
