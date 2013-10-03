package cc150;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: mizhang
 * @since: Oct 3, 2013 5:24:59 PM
 */
public class MaxCircus {
    public static int maxCircus(int[][] weightsAndHeight) {
        Arrays.sort(weightsAndHeight, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int[] longest = new int[weightsAndHeight.length];

        longest[0] = 1;

        for (int i = 1; i < weightsAndHeight.length; i++) {
            longest[i] = 1;
            for (int j = 0; j < i ; j++) {
                if (longest[j] + 1 > longest[i] && weightsAndHeight[j][1] < weightsAndHeight[i][1]) {
                    longest[i] = longest[j] + 1;
                }
            }
        }

        return longest[weightsAndHeight.length - 1];
    }

    public static void test() {
        System.out.println(maxCircus(new int[][] {{4, 6}, {2, 4}, {3, 8}, {1, 2}, {6, 9}, {5, 10}, {11, 10}}));
    }

    public static void main(String[] args) {
        test();
    }
}
