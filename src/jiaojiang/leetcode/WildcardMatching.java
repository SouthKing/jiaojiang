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
        

        return false;
    }

    public static boolean isMatchDP(String s, String p) {
        
        return false;
    }

    public static void test() {
        System.out.println(isMatch("aa","a"));  //false
        System.out.println(isMatch("aa","aa")); //true
        System.out.println(isMatch("aaa","aa")); //false
        System.out.println(isMatch("aa", "*")); //true
        System.out.println(isMatch("aa", "a*")); //true
        System.out.println(isMatch("ab", "?*")); //true
        System.out.println(isMatch("aab", "c*a*b")); //false
    }

    public static void main(String[] args) {
        test();
    }
}
