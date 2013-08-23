package jiaojiang.leetcode.onlinejudge;

/**
 * @author: mizhang
 * @since: May 8, 2013 1:57:46 PM
 */
public class MaxRectangle {
    /*
    Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
     */
    public static int maximalRectangle(char[][] matrix) {
        return 0;
    }
    
    public static void test() {
        System.out.println(maximalRectangle(new char[][] {
                "0010".toCharArray(),
                "1111".toCharArray(),
                "1111".toCharArray(),
                "1110".toCharArray(),
                "1100".toCharArray(),
                "1111".toCharArray(),
                "1110".toCharArray()}
        )); //12

        System.out.println(maximalRectangle(new char[][] {
                "01101".toCharArray(),
                "11010".toCharArray(),
                "01110".toCharArray(),
                "11110".toCharArray(),
                "11111".toCharArray(),
                "00000".toCharArray()}
        )); //9
        
    }
    
    public static void main(String[] args) {
        test();
    }
}
