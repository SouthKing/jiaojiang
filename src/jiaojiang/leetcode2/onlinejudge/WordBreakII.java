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
        wordBreak(s, 0, dict, new StringBuffer(), ret);
        return ret;
    }

    // it is depth first search
    private static void wordBreak(String s, int start, Set<String> dict, StringBuffer sb, List<String> ret) {
        if (start == s.length()) {
            ret.add(sb.toString().trim());
            return;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            if ( dict.contains(s.substring(start, i))) {
                sb.append(s.substring(start, i)).append(' ');
                wordBreak(s, i, dict, sb, ret);
                sb.setLength(sb.length() - i + start - 1);
            }
        }
    }

    public static ArrayList<String> wordBreakBFS(String s, Set<String> dict) {
        ArrayList<String> ret = new ArrayList<String>();

        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(0);

        while (!q.isEmpty()) {
            int start = q.remove();
            for (int end = start + 1; end <= s.length(); end++) {
                if (dict.contains(s.substring(start, end))) {
                    q.add(end);
                    if (!map.containsKey(end)) {
                        map.put(end, new ArrayList<Integer>());
                    }
                    map.get(end).add(start);
                }
            }
        }

        Utils.printListln(map.get(s.length()));

//        getSentence(s, map, s.length(), new StringBuffer(), ret);

        return new ArrayList<String>();
    }

    private static void getSentence(String s, Map<Integer, List<Integer>> tree, int end, StringBuffer sb, List<String> ret) {
        if (end == 0) {
            ret.add(sb.toString().trim());
        }

        for (int i : tree.get(end)) {
            sb.append(s.substring(i, end)).append(' ');
            getSentence(s, tree, i, sb, ret);
            sb.setLength(sb.length() - i + end - 1);
        }
    }

    private static void test() {
        Utils.printListln(wordBreak("catsanddog", new HashSet<String>(Arrays.asList("cat", "cats", "and", "sand", "dog"))));

        System.out.println("------------------");

        Utils.printListln(wordBreakBFS("catsanddog", new HashSet<String>(Arrays.asList("cat", "cats", "and", "sand", "dog"))));
        Utils.printListln(wordBreakBFS("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                new HashSet<String>(Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"))));
    }

    public static void main(String[] args) {
        test();
    }

}
