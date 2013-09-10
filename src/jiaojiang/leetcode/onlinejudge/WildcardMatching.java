package jiaojiang.leetcode.onlinejudge;

/**
 * @author: zhang
 * @since: Aug 8, 2013 10:35:26 PM
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
        return isMatchHelper(s, 0, p, 0);
    }

    public static boolean isMatchHelper(String s, int sStart, String p, int pStart) {
        if (sStart == s.length() && pStart == p.length()) {
            return true;
        }

        if (pStart == p.length() || sStart > s.length()) {
            return false;
        }

        if (p.charAt(pStart) == '?') {
            return isMatchHelper(s, sStart + 1, p, pStart + 1);
        }

        if (p.charAt(pStart) == '*') {
//            return isMatchHelper(s, sStart, p, pStart + 1) || isMatchHelper(s, sStart + 1, p, pStart);
            return isMatchHelper(s, sStart, p, pStart + 1) || isMatchHelper(s, sStart + 1, p, pStart) || isMatchHelper(s, sStart + 1, p, pStart + 1);
        }

        if (sStart == s.length() || s.charAt(sStart) != p.charAt(pStart)) {
            return false;
        }

        return isMatchHelper(s, sStart + 1, p, pStart + 1);
    }

    public static boolean isMatchDP(String s, String p) {

        s = "a" + s;
        p = "a" + p;

        int m = s.length(), n = p.length();
        boolean[][] flags = new boolean[m][n];

        //right boundary
        if (p.charAt(n - 1) == '*') {
            for (int i = m - 1; i >= 0; i--) {
                flags[i][n - 1] = true;
            }
        } else {
            for (int i = m - 2; i >= 0; i--) {
                flags[i][n - 1] = false;
            }
            flags[m - 1][n - 1] = p.charAt(n - 1) == '?' || p.charAt(n - 1) == s.charAt(m - 1);
        }

        //bottom boundary
        int count = p.charAt(n - 1) == '*' ? 0 : 1;                          // count of non-star chars
        for (int i = n - 2; i >= 0; i--) {
            if (p.charAt(i) == '*') {
                flags[m - 1][i] = flags[m - 1][i + 1];
            } else {
                flags[m - 1][i] = count == 0 && (p.charAt(i) == '?' || p.charAt(i) == s.charAt(m - 1));
                count++;
            }
        }

        //rest
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (p.charAt(j) == '*') {
                    flags[i][j] = flags[i + 1][j + 1] || flags[i][j + 1] || flags[i + 1][j];
                } else if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)) {
                    flags[i][j] = flags[i + 1][j + 1];
                } else {
                    flags[i][j] = false;
                }
            }
        }
        
        return flags[0][0];
    }

    public static void test() {
        System.out.println(isMatch("","*"));  //true
        System.out.println(isMatch("","***"));  //true
        System.out.println(isMatch("a","a*"));  //true
        System.out.println(isMatch("b", "?*?"));  //false
        System.out.println(isMatch("aa","a"));  //false
        System.out.println(isMatch("aa","aa")); //true
        System.out.println(isMatch("aaa","aa")); //false
        System.out.println(isMatch("aa", "*")); //true
        System.out.println(isMatch("aa", "a*")); //true
        System.out.println(isMatch("ab", "?*")); //true
        System.out.println(isMatch("aab", "c*a*b")); //false
        System.out.println(isMatch("a", "aa")); //false
        System.out.println(isMatch("babaaababaabababbbbbbaabaabbabababbaababbaaabbbaaab", "***bba**a*bbba**aab**b")); //false
        System.out.println(isMatch("c","*?*"));  //true

        System.out.println("\n=================\n");

        System.out.println(isMatchDP("","*"));  //true
        System.out.println(isMatchDP("","***"));  //true
        System.out.println(isMatchDP("a","a*"));  //true
        System.out.println(isMatchDP("b", "?*?"));  //false
        System.out.println(isMatchDP("aa","a"));  //false
        System.out.println(isMatchDP("aa","aa")); //true
        System.out.println(isMatchDP("aaa","aa")); //false
        System.out.println(isMatchDP("aa", "*")); //true
        System.out.println(isMatchDP("aa", "a*")); //true
        System.out.println(isMatchDP("ab", "?*")); //true
        System.out.println(isMatchDP("aab", "c*a*b")); //false
        System.out.println(isMatchDP("a", "aa")); //false
        System.out.println(isMatchDP("babaaababaabababbbbbbaabaabbabababbaababbaaabbbaaab", "***bba**a*bbba**aab**b")); //false
        System.out.println(isMatchDP("c","*?*"));  //true
    }

    public static void main(String[] args) {
        test();
    }
}
