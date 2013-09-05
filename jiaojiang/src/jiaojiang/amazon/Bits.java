package jiaojiang.amazon;

/**
 * Created by IntelliJ IDEA.
 * User: zhang
 * Date: Aug 1, 2010
 * Time: 3:56:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class Bits {

    public static boolean isPowerOf2(int integer) {
        if (integer <= 0) {
            return false;
        }
        
        return (integer & (integer - 1)) == 0;
    }

    public static void printAllBits(int integer) {
        System.out.print((integer & 0x80000000)>>>31);
        int mask = 0x40000000;
        int count = 30;
        while (mask > 0) {
            System.out.print((integer & mask) >> count--);
            mask >>= 1;
        }
    }

    public static void main(String[] argv) {
//        printAllBits(-1);
        System.out.println(0x80000000);
        System.out.println(-Math.pow(2, 31));
    }
}
