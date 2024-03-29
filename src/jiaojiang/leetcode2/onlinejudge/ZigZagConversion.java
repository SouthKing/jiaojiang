package jiaojiang.leetcode2.onlinejudge;

import utils.Utils;

/**
 * @author: zhang
 * @since: Jan 6, 2014 7:24:03 PM
 */
public class ZigZagConversion {
    /*
    The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
    (you may want to display this pattern in a fixed font for better legibility)

    P   A   H   N
    A P L S I I G
    Y   I   R
    And then read line by line: "PAHNAPLSIIGYIR"
    Write the code that will take a string and make this conversion given a number of rows:

    string convert(string text, int nRows);
    convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
     */

    public static String convert(String s, int nRows) {
        if (nRows == 1) {
            return s;
        }

        StringBuffer ret = new StringBuffer();
        int l = s.length(), nCol = l / (2 * nRows - 2), index;
        for (int j = 0; j < nCol + 1 && (index = j * (2 * nRows - 2)) < l; j++) {
            ret.append(s.charAt(index));
        }

        for (int i = 1; i < nRows - 1; i++) {
            for (int j = 0; j < nCol + 1; j++) {
                if ((index = (2 * nRows - 2) * j + i) < l) {
                    ret.append(s.charAt(index));
                }

                if ( (index = (2 * nRows - 2) * j + 2 * nRows - 2 - i) < l) {
                    ret.append(s.charAt(index));
                }
            }
        }

        for (int j = 0; j < nCol + 1 && (index = nRows + j * (2 * nRows - 2) - 1) < l; j++) {
            ret.append(s.charAt(index));
        }

        return ret.toString();
    }

    private static void test() {
        Utils.printTestln(convert("PAYPALISHIRING", 3), "PAHNAPLSIIGYIR");
        Utils.printTestln(convert("PAYPALISHIRING", 1), "PAYPALISHIRING");
    }

    public static void main(String[] args) {
        test();
    }

}
