package jiaojiang.leetcode2.onlinejudge;

import utils.Utils;

/**
 * @author: zhang
 * @since: Jan 2, 2014 11:07:02 PM
 */
public class LargestRectangelInHistogram {
    /*
    Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

    // See file histogram.png
    Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

    // see file histogram_area.png
    The largest rectangle is shown in the shaded area, which has area = 10 unit.

    For example,
    Given height = [2,1,5,6,2,3],
    return 10.

    Discuss
     */
    public static int largestRectangleArea(int[] height) {
        return largestRectangleAreaHelper(height, 0, height.length);
    }

    private static int largestRectangleAreaHelper(int[] height, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int minIdx = start, min = height[start], leftEnd, rightStart;
        for (int i = start; i < end; i++) {
            if (height[i] < min) {
                minIdx = i;
                min = height[i];
            }
        }

        for (leftEnd = minIdx; leftEnd >= start && height[leftEnd] == min; leftEnd--);
        for (rightStart = minIdx; rightStart < end && height[rightStart] == min; rightStart++);

        return Math.max(min * (end - start), Math.max(largestRectangleAreaHelper(height, start, leftEnd + 1),
                largestRectangleAreaHelper(height, rightStart, end)));
    }

    private static void test() {
//        Utils.printTestln(largestRectangleArea(new int[]{2,1}), 2);
        Utils.printTestln(largestRectangleArea(new int[]{2,1,5,6,2,3}), 10);
    }

    public static void main(String[] args) {
        test();
    }
}
