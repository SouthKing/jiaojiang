package jiaojiang.leetcode2.onlinejudge;

import utils.Utils;

/**
 * @author: mizhang
 * @since: Jan 28, 2014 11:54:33 AM
 */
public class RegularExpressionMatching {
    /*
    Implement regular expression matching with support for '.' and '*'.

    '.' Matches any single character.
    '*' Matches zero or more of the preceding element.

    The matching should cover the entire input string (not partial).

    The function prototype should be:
    bool isMatch(const char *s, const char *p)

    Some examples:
    isMatch("aa","a") ? false
    isMatch("aa","aa") ? true
    isMatch("aaa","aa") ? false
    isMatch("aa", "a*") ? true
    isMatch("aa", ".*") ? true
    isMatch("ab", ".*") ? true
    isMatch("aab", "c*a*b") ? true
     */
    public static boolean isMatch(String s, String p) {
        return isMatch(s, 0, p, 0);
        
    }

    private static boolean isMatch(String s, int sS, String p, int pS) {
        if (pS == p.length())  {
            return sS == s.length();
        }

        if (sS == s.length()) {
            for (int i = pS; i < p.length(); i++) {
                if (p.charAt(pS) != '*') {
                    return false;
                }
            }
            return true;
        }

        if (p.charAt(pS) != '*') {
            return (p.charAt(pS) == '.' || p.charAt(pS) == s.charAt(sS)) && isMatch(s, sS + 1, p, pS + 1);
        }

        return isMatch(s, sS + 1, p, pS) || isMatch(s, sS + 1, p, pS + 1);
    }

    private static void test() {
        Utils.printTestln(isMatch("aa","a"), false);
        Utils.printTestln(isMatch("aa","aa"), true);
        Utils.printTestln(isMatch("aaa","aa"), false);
        Utils.printTestln(isMatch("aa", "a*"), true);
        Utils.printTestln(isMatch("aa", ".*"), true);
        Utils.printTestln(isMatch("ab", ".*"), true);
        Utils.printTestln(isMatch("aab", "c*a*b"), false);
    }

    public static void main(String[] args) {
        test();
    }
}
