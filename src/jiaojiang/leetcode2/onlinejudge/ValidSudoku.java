package jiaojiang.leetcode2.onlinejudge;

import utils.Utils;

/**
 * @author: zhang
 * @since: Jan 20, 2014 2:00:57 PM
 */
public class ValidSudoku {
    /*
    Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

    The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


    A partially filled sudoku which is valid.
    */
    public static boolean isValidSudoku(char[][] board) {

    }

    private static void test() {
        char[][] board = new char[][]{
        ".1...1...".toCharArray(),
        ".........".toCharArray(),
        ".........".toCharArray(),
        ".........".toCharArray(),
        ".........".toCharArray(),
        ".........".toCharArray(),
        ".........".toCharArray(),
        ".........".toCharArray(),
        ".........".toCharArray()
        };

        Utils.printTestln(isValidSudoku(board), true);

    }

    public static void main(String[] args) {
        test();
    }
    
}
