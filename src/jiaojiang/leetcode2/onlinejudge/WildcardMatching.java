package jiaojiang.leetcode2.onlinejudge;

import utils.Utils;

/**
 * @author: mizhang
 * @since: Jan 28, 2014 3:36:46 PM
 */
public class WildcardMatching {
    /*
    Implement wildcard pattern matching with support for '?' and '*'.

    '?' Matches any single character.
    '*' Matches any sequence of characters (including the empty sequence).

    The matching should cover the entire input string (not partial).

    The function prototype should be:
    bool isMatch(const char *s, const char *p)

    Some examples:
    isMatch("aa","a") ? false
    isMatch("aa","aa") ? true
    isMatch("aaa","aa") ? false
    isMatch("aa", "*") ? true
    isMatch("aa", "a*") ? true
    isMatch("ab", "?*") ? true
    isMatch("aab", "c*a*b") ? false
     */
    public static boolean isMatch(String s, String p) {
        return isMatch(s, 0, p, 0);
    }

    private static boolean isMatch(String s, int sS, String p, int pS) {
        if (pS == p.length())  {
            return sS == s.length();
        }


        if (p.charAt(pS) != '*') {
            return sS < s.length() && (p.charAt(pS) == '.' || p.charAt(pS) == s.charAt(sS)) && isMatch(s, sS + 1, p, pS + 1);
        }

        return isMatch(s, sS, p, pS + 1) || isMatch(s, sS + 1, p, pS);
    }

    public static boolean isMatchDP(String s, String p) {
        int m = s.length(), n = p.length();

        if (n == 0) {
            return m == n;
        }

        boolean[][] dp = new boolean[m + 1][n];

        if (p.charAt(n - 1) == '*') {
            for (int i = 0; i <= m; i++) {
                dp[i][n - 1] = true;
            }
        } else if (m > 0) {
            dp[m - 1][n - 1] = s.charAt(m - 1) == p.charAt(n - 1) || p.charAt(n - 1) == '.';
        }

        for (int i = n - 2; i >= 0; i--) {
            dp[m][i] = dp[m][i + 1] && p.charAt(i) == '*';
            for (int j = m - 1; j >= 0; j--) {
                if (p.charAt(i) != '*') {
                    dp[j][i] = dp[j + 1][i + 1] && (s.charAt(j) == p.charAt(i) || p.charAt(i) == '.');
                } else {
                    dp[j][i] = dp[j + 1][i] || dp[j][i + 1];
                }
                
            }
        }

        return dp[0][0];
    }



    private static void test() {
        Utils.printTestln(isMatch("",""), true);
        Utils.printTestln(isMatch("","*"), true);
        Utils.printTestln(isMatch("aa","a"), false);
        Utils.printTestln(isMatch("aa","aa"), true);
        Utils.printTestln(isMatch("aaa","aa"), false);
        Utils.printTestln(isMatch("aa", "a*"), true);
        Utils.printTestln(isMatch("aab", "a*"), true);
        Utils.printTestln(isMatch("aa", ".*"), true);
        Utils.printTestln(isMatch("ab", ".*"), true);
        Utils.printTestln(isMatch("a", ".*"), true);
        Utils.printTestln(isMatch("aab", "c*a*b"), false);

        System.out.println("\n>>>Below is the DP version:");

        Utils.printTestln(isMatchDP("",""), true);
        Utils.printTestln(isMatchDP("","*"), true);
        Utils.printTestln(isMatchDP("aa","a"), false);
        Utils.printTestln(isMatchDP("aa","aa"), true);
        Utils.printTestln(isMatchDP("aaa","aa"), false);
        Utils.printTestln(isMatchDP("aa", "a*"), true);
        Utils.printTestln(isMatchDP("aab", "a*"), true);
        Utils.printTestln(isMatchDP("aa", ".*"), true);
        Utils.printTestln(isMatchDP("ab", ".*"), true);
        Utils.printTestln(isMatchDP("a", ".*"), true);
        Utils.printTestln(isMatchDP("aab", "c*a*b"), false);
        Utils.printTestln(isMatchDP(padding('a', 32316), '*' + padding('a', 32317) + '*'), false);
    }

    private static String padding(char c, int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        test();
    }
}
