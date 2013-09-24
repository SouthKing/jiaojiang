package jiaojiang.leetcode.onlinejudge;

import java.util.ArrayList;

/**
 * @author: mizhang
 * @since: Sep 24, 2013 2:22:26 PM
 */
public class PalindromePartition {
    /*
    Given a string s, partition s such that every substring of the partition is a palindrome.

    Return all possible palindrome partitioning of s.

    For example, given s = "aab",
    Return

      [
        ["aa","b"],
        ["a","a","b"]
      ]
    */
    public static ArrayList<ArrayList<String>> partition(String s) {
        return null;
    }

    public static void test(String s) {
        for (ArrayList<String> l : partition(s)) {
            for (String str : l) {
                System.out.print(str + "\t");
            }
            System.out.println();
        }
    }

    public static void test() {
        test("aab");
    }

    public static void main(String[] args) {
        test();
    }
}
