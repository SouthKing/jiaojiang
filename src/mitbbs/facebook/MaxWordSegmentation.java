package mitbbs.facebook;

import jiaojiang.utils.Utils;

import java.util.Set;
import java.util.HashSet;

/**
 * @author: mizhang
 * @since: Sep 24, 2013 5:20:42 PM
 */
public class MaxWordSegmentation {
    /*
    Word breaking
    // How many spaces can we add to a word such that:
    // All subwords can be found within a given dictionary

    // fireman

    // fire man -> 2 words
    // fir em an -> 3 words

    /* DICT
    a
    an
    em
    fir
    fire
    ire
    ma
    man
    */
    public static int maxWordSegment(String s, Set<String> dict) {
        return maxWordSegment(s, 0, dict);
    }

    private static int maxWordSegment(String s, int start, Set<String> dict) {
        int l = s.length(), nWords = -1;
        
        if (start == l) {
            return 0;
        }

        for (int i = start; i < l; i++) {
            int n;
            if (dict.contains(s.substring(start, i + 1)) && (n = maxWordSegment(s, i + 1, dict)) != -1) {
                nWords = Math.max(nWords, n + 1);
            }
        }

        return nWords;
    }

    public static void test(String s, Set<String> dict) {
        System.out.println(maxWordSegment(s, dict));
    }

    public static void test() {
        Set<String> dict = new HashSet<String>();
        dict.add("a");
        dict.add("an");
        dict.add("em");
        dict.add("fir");
        dict.add("fire");
        dict.add("ire");
        dict.add("ma");
        dict.add("man");
        
        test("fireman", dict);

        dict.clear();
        dict.add("hell");
        dict.add("hello");
        dict.add("ow");
        dict.add("oworld");
        dict.add("wor");
        dict.add("ld");

        test("helloworld", dict); //3
    }

    public static void main(String[] args) {
        test();
    }
}
