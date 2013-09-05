package jiaojiang.amazon;

import jiaojiang.huayuan.Utils;

/**
 * Created by IntelliJ IDEA.
 * User: zhang
 * Date: Jul 26, 2010
 * Time: 11:38:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class Order {
    public static int getNth(int[] data, int n) {
        return getNth(data, 0, data.length, n);
    }

    public static int getNth(int[] data, int from, int to, int n) {
        if (n > to - from) {
            return Integer.MAX_VALUE;
        }
        int p = from;
        for (int i = from; i < to - 1; i++) {
            if (data[i] < data[to - 1]) {
                Utils.swap(data, p, i);
                p++;
            }
        }
        Utils.swap(data, p, to - 1);

        if (p - from == n - 1) {
            return data[p];
        }

        if (p - from < n - 1) {
            return getNth(data, p + 1, to, n - p + from - 1);
        }

        return getNth(data, from, p, n);
    }

    public static void main(String[] argv) {
        int[] data = {1, 6, 4, 7, 2, 8, 3};
        System.out.println(getNth(data, 2));
    }

    
}
