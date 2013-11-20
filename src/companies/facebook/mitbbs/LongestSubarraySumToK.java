package companies.facebook.mitbbs;

import utils.Utils;

/**
 * @author: zhang
 * @since: Nov 19, 2013 10:48:17 PM
 */
public class LongestSubarraySumToK {
    /*
    find the longest subarray whose sum is K
     */
    public static int longestSubarray(int[] data, int target) {
        int start = 0, length = 0, sum = 0;

        for (int i = 0; i < data.length; i++) {
            sum += data[i];
            if (sum > target) {
                while (start <= i && sum > target) {
                    sum -= data[start++];
                }
            }

            if (sum == target) {
                length = Math.max(length, i - start + 1);
            }
        }

        return length;
    }

    private static void test() {
        Utils.printTestln(longestSubarray(new int[]{1, 3, 2, 8, 5, 1, 1, 1, 1, 2}, 6), 5);
        Utils.printTestln(longestSubarray(new int[]{1, 3, 2, 8, 5, 1, 1, 1, 1, 2}, 16), 5);
        Utils.printTestln(longestSubarray(new int[]{1, 3, 2, 8, 5, 1, 1, 1, 1, 2}, 116), 0);
    }

    public static void main(String[] args) {
        test();
    }
}
