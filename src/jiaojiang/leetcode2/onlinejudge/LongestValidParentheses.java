package jiaojiang.leetcode2.onlinejudge;

import utils.Utils;

/**
 * @author: zhang
 * @since: Jan 2, 2014 9:25:04 PM
 */
public class LongestValidParentheses {
    /*
    Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

    For "(()", the longest valid parentheses substring is "()", which has length = 2.

    Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
     */
    public static int longestValidParentheses(String s) {
        return 0;
    }

    private static void test() {
        Utils.printTestln(longestValidParentheses(")()())"), 4);
        Utils.printTestln(longestValidParentheses("(()"), 2);
    }

    public static void main(String[] args) {
        test();
    }
}
