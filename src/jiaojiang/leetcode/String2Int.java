package jiaojiang.leetcode;

import jiaojiang.microsoft.MaxPair;

/**
 * @author: mizhang@akamai.com
 */
public class String2Int {

    public static int atoi(String str) {
        String number = str.trim();

        if (number.isEmpty()) {
            return 0;
        }

        long ret = 0;
        int i = 1, n = number.length();
        char c = number.charAt(0);

        if (c <= '9' && c >= '0') {
            ret = c - '0';
        } else if (c != '-' && c != '+') {
            return 0;
        }

        while ( i < n && (c = number.charAt(i++)) <= '9' && c >= '0' && -ret > Integer.MIN_VALUE) {
            ret = ret * 10 + (c - '0');
        }

        if (number.charAt(0) == '-') {
            return -ret < Integer.MIN_VALUE ? Integer.MIN_VALUE : (int) -ret;
        }

        return ret > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)ret;
    }

    public static void main(String[] args) {
        String s = "10557266014";
        System.out.println(atoi(s));
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
    }
}
