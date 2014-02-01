package jiaojiang.leetcode2.onlinejudge;

import utils.Utils;

import java.util.*;

/**
 * @author: zhang
 * @since: Jan 31, 2014 11:33:35 PM
 */
public class WordBreakII {
    /*
    Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

    Return all such possible sentences.

    For example, given
    s = "catsanddog",
    dict = ["cat", "cats", "and", "sand", "dog"].

    A solution is ["cats and dog", "cat sand dog"].
     */
    public static ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> ret = new ArrayList<String>();
        wordBreak(s, 0, dict, ret);
        return ret;
    }

    private static boolean wordBreak(String s, int start, Set<String> dict, List<String> ret) {
        if (start == s.length()) {
            return true;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            if ( dict.contains(s.substring(start, i)) && wordBreak(s, i, dict, ret)) {
                ret.add(s.substring(start, i));
                return true;
            }
        }

        return false;
    }

    public static ArrayList<String> wordBreakDP(String s, Set<String> dict) {
        ArrayList<String> ret = new ArrayList<String>();


        return ret;
    }

    private static void test() {
        Utils.printListln(wordBreak("catsanddog", new HashSet<String>(Arrays.asList("cat", "cats", "and", "sand", "dog"))));

        System.out.println("------------------");

        Utils.printListln(wordBreakDP("catsanddog", new HashSet<String>(Arrays.asList("cat", "cats", "and", "sand", "dog"))));
        Utils.printListln(wordBreakDP("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                new HashSet<String>(Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"))));
    }

    public static void main(String[] args) {
        test();
    }

}
