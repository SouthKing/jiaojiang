package companies.google.mitbbs;

/**
 * @author: mizhang
 * @since: Nov 22, 2013 1:10:02 PM
 */
public class CodeLock {
    /*
     A digital door lock with a 4-digit code and therefore there are totally 10000 combinations. Need to find a shorted
     string that all these 10000 combinations are exists in the string.

     For example. assume you have a 2-digit code and each digit ranges from 0 to 1, then you have 4 different combinations:
     00, 01, 10, 11 and 0011 contains all the combinations (from last to first is 10)

     It is also called De Bruijn sequence.
     */
    public static String getSequence() {
        return null;
    }

    public static void getHamiltonianCycle() {
        
    }

    // assume i and j are in the range of [0, 10000]
    private static boolean isNeighbor(int i, int j) {
        return i % 1000 == j / 10;
    }

    private int[] getNeighbors(int i) {
        int[] ret = new int[10];
        for (int ii = 0; ii < ret.length; ii++) {
            ret[ii] = (i % 1000) * 10 + i;
        }

        return ret;
    }

    public static void main(String[] args) {
        System.out.println(getSequence());
    }
}
