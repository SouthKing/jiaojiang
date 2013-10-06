package mitbbs.misc;

import jiaojiang.utils.Utils;

/**
 * @author: zhang
 * @since: Oct 5, 2013 10:30:08 PM
 */
/*
An int array with length N, which contains M distinct numbers, where N >> M

For example, 0011111222222333333333333

Find the longest subarray with repeating numbers, i.e., 333333333333
 */
public class LongestSubarray {

    public static int[] longestRepeatingSubarray(int[] sortedData) {
        int[] ret = new int[2];
        

        return ret;
    }

    public static void test() {
        Utils.printIntArrayln(longestRepeatingSubarray(new int[]{0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}), new int[]{13, 12});
    }

    public static void main(String[] args) {
        test();
    }
}
