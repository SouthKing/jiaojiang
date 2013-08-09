package jiaojiang.leetcode;

import java.util.ArrayList;

/**
 * @author: zhang
 * @since: May 14, 2013 9:33:21 PM
 */
public class SubstringWithConcatecationOfAllWords {
    /*
    You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices
    of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

     For example, given:
     S: "barfoothefoobarman"
     L: ["foo", "bar"]

     You should return the indices: [0,9].
    (order does not matter).
     */
    public static ArrayList<Integer> findSubstring(String S, String[] L) {
        return null;
    }

    public static void test() {
        for (int i : findSubstring("barfoothefoobarman", new String[]{"foo", "bar"})) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        test();
    }
}
