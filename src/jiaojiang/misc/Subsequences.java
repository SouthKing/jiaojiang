package jiaojiang.misc;

import jiaojiang.utils.Utils;

/**
 * @author: mizhang
 * @since: Sep 12, 2013 4:52:53 PM
 */
public class Subsequences {
    /*
    You're given a large string T. And a stream of smaller string S1, S2, S3 ...

    Determine whether Si is a subsequence of T.

    |T| < 10 000 000
    |Si| < 100
    alphabet is 'a' - 'z'

    T = abcdefg
    S1 = abc        yes
    S2 = ag          yes
    S3 = ga          no
    S4 = aa          no
    */

    public static boolean[] isSubsequence(String t, String... s) {
        boolean[] ret = new boolean[s.length];

        //pre-process t


        //process array s
        for (String str : s) {

        }

        return null;
    }

    private static int[][] getIndex(String t) {
        int[][] ret = new int[256][t.length()];
        for (int i = 0; i < 256; i++) {
            for (int j = 0; j < t.length(); j++) {
                ret[i][j] = -1;
            }
        }

//        for (char )

        return ret;
    }

    private static boolean process(int[][] index, int s) {


        return false;
    }

    public static void test() {
        Utils.println(isSubsequence("abcdefg", "abc", "ag", "ga", "aa"), new boolean[] {true, true, false, false});
    }
}
