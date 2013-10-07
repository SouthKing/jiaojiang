package mitbbs.misc;

import jiaojiang.utils.Utils;

/**
 * @author: zhang
 * @since: Oct 6, 2013 12:11:37 AM
 */
/*
Given n items with weight w_i and value_i, find k from n such that all the weight is less than given weights with maximal
value
 */
public class Knapsack {
    public static int maxValue(int[] weights, int[] values, int maxWeight) {
        

        return 0;
    }

    public static void test() {
        Utils.println(maxValue(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 9, 13, 15}, 5), 16);
        Utils.println(maxValue(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 9, 13, 15}, 7), 22);
    }

    public static void main(String[] args) {
        test();
    }
}
