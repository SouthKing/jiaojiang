package jiaojiang.misc;

import jiaojiang.utils.Utils;

/**
 * @author: mizhang
 * @since: Sep 10, 2013 10:34:02 AM
 */
public class MaxRepeatingNumber {

    /*
    Find the number with max repeating times. The data array's length is n and the element of the data is in the interval [0, n)
    Need O(1) in space and O(n) in time
     */

    public static int maxRepeatingNumber(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int index = i, tmp = data[index];
            while (tmp >= 0) {
                index = tmp;
                tmp = data[index];
                if (tmp >= 0) {
                    data[index] = -1;
                } else {
                    data[index]--;
                }
            }
        }

        int max = 0, maxIdx = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] < max) {
                max = data[i];
                maxIdx = i;
            }
        }

        return maxIdx;
    }

    public static void test() {
        Utils.println(maxRepeatingNumber(new int[]{1, 2, 4, 0, 2, 3, 4, 2, 3, 3, 3}), 3);
        Utils.println(maxRepeatingNumber(new int[]{1, 2, 3, 4, 5, 6, 0}), 1);
        Utils.println(maxRepeatingNumber(new int[]{0, 0, 0, 0, 0, 0, 1}), 0);
        Utils.println(maxRepeatingNumber(new int[]{0, 4, 4, 4, 4, 4, 4}), 4);
        Utils.println(maxRepeatingNumber(new int[]{4, 4, 4, 4, 4, 4, 4}), 4);
        Utils.println(maxRepeatingNumber(new int[]{4, 4, 4, 1, 1, 1, 1}), 1);
    }

    public static void main(String[] args) {
        test();
    }
}
