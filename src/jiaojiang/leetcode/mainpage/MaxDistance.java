package jiaojiang.leetcode.mainpage;

/**
 * @author: zhang
 */
public class MaxDistance {

    /*
    Given an array A of integers, find the maximum of j-i subjected to the constraint of A[i] < A[j].
     */
    public static int maxDistance(int[] data) {
        int[] leftMin = new int[data.length - 1];
        int[] rightMax = new int[data.length - 1];


        return 0;
    }

    public static void test() {
        System.out.println(maxDistance(new int[]{4, 3, 5, 2, 1, 3, 2, 3}));    //4
//        System.out.println(maxDistance(new int[]{4, 3, 5, 2, 1, 3, 2, 3}));
    }

    public static void main(String[] args) {
        test();
    }
}
