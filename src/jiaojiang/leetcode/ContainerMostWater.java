package jiaojiang.leetcode;

/**
 * @author: zhang
 * @since: Apr 12, 2013 11:37:14 PM
 */
public class ContainerMostWater {
    public static int maxArea(int[] height) {
        int i = 0, j = height.length - 1, max = 0;

        while (i < j) {
            int minHeight = Math.min(height[i], height[j]);
            int area = minHeight * (j - i);
            if (area > max) {
                max = area;
            }

            if (height[i] < height[j]) {
                i++;
                while (height[i] < minHeight && i < j) {
                    i++;
                }
            } else {
                j--;
                while (height[j] < minHeight && i < j) {
                    j--;
                }
            }
        }

        return max;
    }

    public static void testMaxArea() {
        int[] height1 = {14,0,12,3,8,3,13,5,14,8};
        int desired1 = 112;
        int[] height2 = {9,6,14,11,2,2,4,9,3,8};
        int desired2 = 72;
        int[] height3 = {76,155,15,188,180,154,84,34,187,142,22,5,27,183,111,128,50,58,2,112,179,2,100,111,115,76,134,120,118,103,31,146,58,198,134,38,104,170,25,92,112,199,49,140,135,160,20,185,171,23,98,150,177,198,61,92,26,147,164,144,51,196,42,109,194,177,100,99,99,125,143,12,76,192,152,11,152,124,197,123,147,95,73,124,45,86,168,24,34,133,120,85,81,163,146,75,92,198,126,191};
        int desired3 = 18048;

        System.out.println(maxArea(height1) + " : " + desired1);
        System.out.println(maxArea(height2) + " : " + desired2);
        System.out.println(maxArea(height3) + " : " + desired3);
    }

    public static void main(String[] args) {
        testMaxArea();
    }
}
