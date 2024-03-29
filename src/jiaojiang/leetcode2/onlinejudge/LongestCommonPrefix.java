package jiaojiang.leetcode2.onlinejudge;

import utils.Utils;

/**
 * @author: zhang
 * @since: Jan 20, 2014 12:22:13 AM
 */
public class LongestCommonPrefix {
    /*
    Write a function to find the longest common prefix string amongst an array of strings.
    */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuffer ret = new StringBuffer();
        for (int i = 0; ;i++) {
            if (i >= strs[0].length()) {
                return ret.toString();
            }
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != strs[j - 1].charAt(i)) {
                    return ret.toString();
                }
            }
            ret.append(strs[0].charAt(i));
        }
    }

    private static void test() {
        Utils.printTestln(longestCommonPrefix(new String[0]), "");
        Utils.printTestln(longestCommonPrefix(new String[]{""}), "");
    }

    public static void main(String[] args) {
        test();
    }
}
