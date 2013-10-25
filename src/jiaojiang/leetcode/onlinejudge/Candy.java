package jiaojiang.leetcode.onlinejudge;

import utils.Utils;

import java.util.TreeMap;

/**
 * @author: mizhang
 * @since: Oct 25, 2013 2:34:26 PM
 */
public class Candy {
    /*
     There are N children standing in a line. Each child is assigned a rating value.

    You are giving candies to these children subjected to the following requirements:

        1. Each child must have at least one candy.
        2. Children with a higher rating get more candies than their neighbors.

    What is the minimum candies you must give?
     */
    public static int candy(int[] ratings) {

        int ret = 0;
        int[] count = new int[ratings.length];
        count[0] = 1;

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                count[i] = count[i - 1] + 1;
            } else {
                count[i] = 1;
            }
        }

        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                count[i - 1] = count[i] + 1;
            }
        }

        for (int i : count) {
            ret += i;
        }
        
        return ret;
    }

    public static void test() {
        Utils.printTestln(candy(new int[]{1, 1, 2, 4, 5, 6, 4}), 19);
        Utils.printTestln(candy(new int[]{1, 5, 2, 4, 2, 6, 4}), 10);
        Utils.printTestln(candy(new int[]{2, 2, 1}), 4);
        Utils.printTestln(candy(new int[]{1, 2, 2, 1}), 6);
        Utils.printTestln(candy(new int[]{1, 2, 2, 2, 1}), 7);
        Utils.printTestln(candy(new int[]{11, 13, 8, 9, 4, 3, 2, 5, 7}), 19);
        Utils.printTestln(candy(new int[]{1, 2, 3, 4}), 10);
        Utils.printTestln(candy(new int[]{4, 3, 2, 1}), 10);
    }

    public static void main(String[] args) {
        test();
    }
}
