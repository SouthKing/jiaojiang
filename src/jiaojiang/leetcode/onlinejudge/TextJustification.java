package jiaojiang.leetcode.onlinejudge;

import java.util.ArrayList;

/**
 * @author: mizhang@akamai.com
 */
public class TextJustification {
    /*
    Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

    You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so
    that each line has exactly L characters.

    Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words,
    the empty slots on the left will be assigned more spaces than the slots on the right.

    For the last line of text, it should be left justified and no extra space is inserted between words.

    For example,
    words: ["This", "is", "an", "example", "of", "text", "justification."]
    L: 16.

    Return the formatted lines as:

    [
       "This    is    an",
       "example  of text",
       "justification.  "
    ]
    Note: Each word is guaranteed not to exceed L in length.

    Corner Cases:
    A line other than the last line might contain only one word. What should you do in this case?
    In this case, that line should be left-justified.
     */
    public static ArrayList<String> fullJustify(String[] words, int L) {
        StringBuffer sb = new StringBuffer();

        int l = 0;
        for (String s : words) {
//            l = s.length() +
        }

        return null;
    }

    public static void test() {
        for (String s : fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16)) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        test();
    }

}
