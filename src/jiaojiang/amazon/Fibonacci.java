package jiaojiang.amazon;

/**
 * Created by IntelliJ IDEA.
 * User: zhang
 * Date: Jul 26, 2010
 * Time: 9:51:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class Fibonacci {
    public static int getFibonacci(int n) {
        if (n < 1) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return getFibonacci(n - 1) + getFibonacci(n - 2);
    }

    public static int getFibonacciIterative(int n) {
        if (n < 0) {
            return 0;
        }

        if (n < 2) {
            return n;
        }

        int fn = 1, fm = 0;
        for (int i = 2; i <= n; i++) {
            fn += fm;
            fm = fn - fm;
        }

        return fn;
    }

    public static void main(String[] argv) {
//        System.out.println(getFibonacci(10));
        System.out.println(getFibonacciIterative(10));
    }
}
