package jiaojiang.leetcode2.onlinejudge;

import utils.Utils;

/**
 * @author: zhang
 * @since: Jan 6, 2014 8:46:21 PM
 */
public class BinaryTreeMaximumPathSum {
    /*
    Given a binary tree, find the maximum path sum.

    The path may start and end at any node in the tree.

    For example:
    Given the below binary tree,

           1
          / \
         2   3
    Return 6.
     */
    public static int maxPathSum(TreeNode root) {
        return 0;
    }

        /*
         1
        / \
       2   5
      / \   \
     3   4   6
     */
    private static void test() {
        Utils.printTestln(maxPathSum(TreeNode.getSampleTree()), 18);
    }

    public static void main(String[] args) {
        test();
    }
}
