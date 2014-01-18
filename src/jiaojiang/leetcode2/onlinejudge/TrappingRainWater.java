package jiaojiang.leetcode2.onlinejudge;

import utils.Utils;

/**
 * @author: zhang
 * @since: Jan 17, 2014 10:05:51 PM
 */
public class TrappingRainWater {
    /*
    Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much
    water it is able to trap after raining.

    For example,
    Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

    see graph 

    The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water
    (blue section) are being trapped. Thanks Marcos for contributing this image!
     */
    public static int trap(int[] A) {
        return 0;
    }

    private static void test() {
        Utils.printTestln(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}), 6);
    }

    public static void main(String[] args) {
        test();
    }
}
