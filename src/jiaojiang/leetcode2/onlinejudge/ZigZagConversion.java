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
        return "";
    }

    private static void test() {
        Utils.printTestln(convert("PAYPALISHIRING", 3), "PAHNAPLSIIGYIR");
    }

    public static void main(String[] args) {
        test();
    }

}