package jiaojiang.leetcode2.onlinejudge;

import utils.Utils;

/**
 * @author: zhang
 * @since: Jan 24, 2014 10:35:49 PM
 */
public class Strstr {
    /*
    Implement strStr().

    Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
     */
    public static String strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length(), i, j;
        for (i = 0; i < m - n + 1; i++) {
            for (j = 0; j < n && haystack.charAt(i + j) == needle.charAt(j); j++);
            if (j == n) {
                return haystack.substring(i);
            }
        }
        return null;
    }

    private static void test() {
        Utils.printTestln(strStr("hello, world", "world"), "world");
        Utils.printTestln(strStr("hello, world", "word"), null);
        Utils.printTestln(strStr("a", ""), "a");
    }

    public static void main(String[] args) {
        test();
    }
}
