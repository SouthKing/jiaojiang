package jiaojiang.leetcode.onlinejudge;

/**
 * @author zhang
 * @since: Sep 24, 2013 2:18:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class PalindromePartitionII {
    /*Given a string s, partition s such that every substring of the partition is a palindrome.

     Return the minimum cuts needed for a palindrome partitioning of s.

     For example, given s = "aab",
     Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
    */
    public static int minCut(String s) {
        return minCut(s, 0);
    }

    public static int minCut(String s, int start) {
        int minCut = Integer.MAX_VALUE;
        if (start == s.length()) {
            return -1;
        }

        for (int i = start; i < s.length(); i++) {
            int cut;
            if (isPalindrome(s, start, i) && (cut = minCut(s, i + 1)) != Integer.MAX_VALUE) {
                minCut = Math.min(cut + 1, minCut);
            }
        }

        return minCut;
    }

    public static int minCutDP(String s) {
        return 0;
    }

    private static boolean isPalindrome(String s, int start, int end) {
        for (; start < end && s.charAt(start) == s.charAt(end); start++, end--);
        return start >= end;
    }

    public static void test() {
        System.out.println("get: " +  minCut("aab") + ", expected: " + "1"); // 1
        System.out.println("get: " +  minCut("ababababababababababababcbabababababababababababa") + ", expected: " + "0"); // 1

        System.out.println("get: " +  minCutDP("aab") + ", expected: " + "1"); // 1
        System.out.println("get: " +  minCutDP("ababababababababababababcbabababababababababababa") + ", expected: " + "0"); // 1
    }

    public static void main(String[] args) {
        test();
    }
}
