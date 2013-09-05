package jiaojiang.leetcode.onlinejudge;

/**
 * @author: mizhang@akamai.com
 */
public class Palindrome {

    public static boolean longestPalindrome(String s) {
        StringBuffer buffer = new StringBuffer();

        for (int i = 0, n = s.length(); i < n - 1; i++) {
            buffer.append(s.charAt(i)).append('#');
        }
        String ss = buffer.append(s.charAt(s.length() - 1)).toString();

        int[] p = new int[ss.length()];




        return false;
    }

    public static boolean isPalindrome(int x) {

        int length = 1;
        while (x /(int)Math.pow(10, length) != 0) {
            length++;
        }

        for (int i = 0; i < length / 2; i++) {
            if (x / (int)Math.pow(10, length - i  - 1) %10 != x /(int)Math.pow(10, i) % 10) {
                return false;
            }
        }

        return true;
    }



    public static void main(String[] args) {
        System.out.println(isPalindrome(123454321));
        System.out.println(isPalindrome(123456));


    }
}
