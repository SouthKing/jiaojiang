package jiaojiang.amazon;

/**
 * Created by IntelliJ IDEA.
 * User: zhang
 * Date: Jul 21, 2010
 * Time: 10:09:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class InPlaceMergeSort {
    //from array[0], ..., array[barrier] and array[barrier + 1], ... array[n] are sorted respectively, need to merge them
    public static void inPlaceMergeSort(int[] array, int barrier) {
        boolean isFrontLess = false;
        int i = barrier, j = array.length - 1;

        while (i > 0 && j > barrier) {

        }


    }

    public static void main(String[] argv) {
        int[] array = {1, 3, 5, 8, 10, 2, 4, 6, 7, 9, 12};
        inPlaceMergeSort(array, 4);
        for(int i : array) {
            System.out.println(i);
        }
    }
}
