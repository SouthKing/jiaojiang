package jiaojiang.ebay;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: zhang
 * Date: Sep 17, 2010
 * Time: 12:22:10 AM
 * To change this template use File | Settings | File Templates.
 */
public class Array {
    public static int findMin(int[] arrayA, int[] arrayB) {
        int i = 0, j = 0, min = Integer.MAX_VALUE, currentMin = 0;
        while (i < arrayA.length && j < arrayB.length) {
            currentMin = Math.abs(arrayA[i] - arrayB[j]);
            if (currentMin == 0) {
                return 0;
            }
            if(currentMin < min) {
                min = currentMin;
            }
            if (arrayA[i] < arrayB[j]) {
                i++;
            } else {
                j++;
            }
        }
        return min;
    }

    public static void main(String[] argv) {
        int[] a = new int[10];
        int[] b = new int[20];
        Random r = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt(1000);
        }
        for (int i = 0; i < b.length; i++) {
            b[i] = r.nextInt(1000);
        }
        Arrays.sort(a);
        Arrays.sort(b);
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println("\n");

        for (int i : b) {
            System.out.print(i + " ");
        }
        System.out.println("\n");

        System.out.println(findMin(a, b));
    }
}
