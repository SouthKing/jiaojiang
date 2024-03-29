package jiaojiang.leetcode2.onlinejudge;

import java.util.*;

/**
 * @author: zhang
 * @since: Jan 14, 2014 10:50:06 PM
 */
public class Anagrams {
    /*
    Given an array of strings, return all groups of strings that are anagrams.

    Note: All inputs will be in lower-case.
    */
    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> ret = new ArrayList<String>();
        Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();

        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String rep = new String(chars);
            if (!map.containsKey(rep)) {
                map.put(rep, new ArrayList<Integer>());
            }
            map.get(rep).add(i);
        }

        for (String s : map.keySet()) {
            List<Integer> anagrams = map.get(s);
            if (anagrams.size() > 1) {
                for (int i : anagrams) {
                    ret.add(strs[i]);
                }
            }
        }

        return ret;
    }
}
