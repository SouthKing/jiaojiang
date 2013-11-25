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
        StringBuffer s = new StringBuffer();
        if (getHamiltonianCycle(0, s, new boolean[12], 0) == 0) {
            return s.toString();
        }

        return "";
    }

    public static int getHamiltonianCycle(int i, StringBuffer s, boolean[] hasVisited, int count) {
        if (count == 3) {
            if (!hasVisited[Integer.parseInt(s.substring(3) + s.charAt(0))]) {
                return 0;
            }
            return 1;
        }

        if (hasVisited[i]) {
            return 2;
        }

        hasVisited[i] = true;
        if (count == 0) {
            s.append(String.format("%02d", i));
        } else {
            s.append(i);
        }

        for (int neighbor : getNeighbors(i)) {
            if (i == neighbor) {
                continue;
            }
            int retCode = getHamiltonianCycle(neighbor, s, hasVisited, count + 1);
            if (retCode == 0) {
                return 0;
            }
            if (retCode == 3) {

            }

            if (retCode == 1) {

            }
        }



        return 3;
    }

    // assume i and j are in the range of [0, 10000]
    private static boolean isNeighbor(int i, int j) {
        return i % 10 == j / 10;
    }

    private static int[] getNeighbors(int i) {
        int[] ret = new int[2];
        for (int ii = 0; ii < ret.length; ii++) {
            ret[ii] = (i % 10) * 10 + ii;
        }

        return ret;
    }

    public static void main(String[] args) {
        System.out.println(getSequence());
    }
}
