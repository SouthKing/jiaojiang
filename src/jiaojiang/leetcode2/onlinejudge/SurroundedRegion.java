package jiaojiang.leetcode2.onlinejudge;

import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

/**
 * @author: zhang
 * @since: Dec 30, 2013 10:16:22 PM
 */
public class SurroundedRegion {
    /*
    Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

    A region is captured by flipping all 'O's into 'X's in that surrounded region .

    For example,
    X X X X
    X O O X
    X X O X
    X O X X
    After running your function, the board should be:

    X X X X
    X X X X
    X X X X
    X O X X
     */
    public static void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }

        List<Integer> queue = new ArrayList<Integer>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'V';
                    boolean isSurrounded = true;
                    int startIndex = 0;
                    queue.add(i);
                    queue.add(j);
                    while (startIndex < queue.size()) {
                        int iIndex = queue.get(startIndex), jIndex = queue.get(startIndex + 1);
                        if (isSurrounded && iIndex == 0 || iIndex == board.length - 1 || jIndex == 0 || jIndex == board[0].length - 1) {
                            isSurrounded = false;
                        }
                        startIndex += 2;
                        if (iIndex > 0 && board[iIndex - 1][jIndex] == 'O') {
                            queue.add(iIndex - 1);
                            queue.add(jIndex);
                            board[iIndex - 1][jIndex] = 'V';
                        }

                        if (iIndex < board.length - 1 && board[iIndex + 1][jIndex] == 'O') {
                            queue.add(iIndex + 1);
                            queue.add(jIndex);
                            board[iIndex + 1][jIndex] = 'V';
                        }

                        if (jIndex > 0 && board[iIndex][jIndex - 1] == 'O') {
                            queue.add(iIndex);
                            queue.add(jIndex - 1);
                            board[iIndex][jIndex - 1] = 'V';
                        }

                        if (jIndex < board[0].length - 1 && board[iIndex][jIndex + 1] == 'O') {
                            queue.add(iIndex);
                            queue.add(jIndex + 1);
                            board[iIndex][jIndex + 1] = 'V';
                        }
                    }
                    if (isSurrounded) {
                        for (int k = 0; k < queue.size(); k += 2) {
                            board[queue.get(k)][queue.get(k + 1)] = 'X';
                        }
                    }
                    queue.clear();
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'V') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private static void test() {
        char[][] board = new char[][]{
            "XXXX".toCharArray(),
            "XOOX".toCharArray(),
            "XXOX".toCharArray(),
            "XOXX".toCharArray()
        };

        solve(board);

        for (char[] line : board) {
            for (char c : line) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        test();
    }
}
