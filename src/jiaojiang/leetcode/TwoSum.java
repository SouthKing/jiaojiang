package jiaojiang.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: mizhang@akamai.com
 */
public class TwoSum {

    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> hasNumber = new HashMap<Integer, Integer>();

        for (int i : numbers) {
            if (!hasNumber.containsKey(i)) {
                hasNumber.put(i, 1);
            } else {
                hasNumber.put(i, hasNumber.get(i) + 1);
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            int m = target - numbers[i];
            if (hasNumber.containsKey(m)) {
                if (m == numbers[i] && hasNumber.get(numbers[i]) > 1 || m != numbers[i]) {
                    int j = i + 1;
                    for (; j < numbers.length && numbers[j] != m; j++);
                    return new int[] {i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] numbers  = new int[]{2,1,9,4,4,56,90,3};
        int[] indices = twoSum(numbers, 8);
        System.out.println(indices[0] + " : " + indices[1]);
    }
}
