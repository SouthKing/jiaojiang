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
        return -1;
    }

    public static void test() {
        System.out.println("get: " +  minCut("aab") + ", expected: " + "1"); // 1
    }

    public static void main(String[] args) {
        test();
    }
}
