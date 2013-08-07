package jiaojiang.leetcode;

/**
 * @author: zhang
 * @since: Apr 14, 2013 1:32:55 AM
 */
public class RemoveDuplicatesInSortedArray {


    public static int removeDuplicates(int[] A) {
        if (A.length == 0) {
            return 0;
        }

        int length = 1, current = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] != current) {
                A[length] = A[i];
                current = A[i];
                length++;
            }
        }

        return length;
    }


//test cases:
//[]
//
//[1]
//
//[1,1]
//
//[1,2]
//
//[1,1,1]
//
//[1,2,2]
//
//[1,1,2]
//
//[1,2,3]
//
//[1,1,1,1]


}
