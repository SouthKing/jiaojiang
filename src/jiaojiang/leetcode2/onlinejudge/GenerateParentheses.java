package jiaojiang.leetcode2.onlinejudge;

import utils.Utils;

import java.util.ArrayList;

/**
 * @author: mizhang
 * @since: Jan 2, 2014 11:21:18 AM
 */
public class GenerateParentheses {
    /*
    Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

    For example, given n = 3, a solution set is:

    "((()))", "(()())", "(())()", "()(())", "()()()"
     */
    public static ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> ret = new ArrayList<String>();
        generateParenthesis(n, 1, 0, "(", ret);
        return ret;
    }

    public static void generateParenthesis(int n, int i, int j, String prefix, ArrayList<String> ret) {
        if (j == n) {
            ret.add(prefix);
            return;
        }

        if (i > j) {
            generateParenthesis(n, i, j + 1, prefix + ")", ret);
        }

        if (i < n) {
            generateParenthesis(n, i + 1, j, prefix + "(", ret);
        }
    }

    private static void test() {
        Utils.printListln(generateParenthesis(3));
    }

    public static void main(String[] args) {
        test();
    }
}
