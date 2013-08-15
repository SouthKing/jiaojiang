package jiaojiang.leetcode;

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
        
        return false;
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
    }

    public static void main(String[] args) {
        test();
    }
}
