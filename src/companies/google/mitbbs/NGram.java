package companies.google.mitbbs;

import utils.Utils;

import java.util.List;

/**
 * @author: mizhang
 * @since: Oct 31, 2013 4:53:35 PM
 */
public class NGram {
    /*
    Given a string and a integer number N, output all the k-gram of the string with k <= N.
    For example, "hello world all" and 2, return "hell0", "world", "all", "hello world", "world all"
     */
    public static List<String> getNGram(String words, int n) {
        return null;
    }

    private static void test() {
        Utils.printListln(getNGram("hello world all", 2));
    }

    public static void main(String[] args) {
        test();
    }
}
