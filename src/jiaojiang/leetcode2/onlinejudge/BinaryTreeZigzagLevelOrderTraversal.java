package jiaojiang.leetcode2.onlinejudge;

import utils.Utils;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author: zhang
 * @since: Jan 19, 2014 1:41:43 PM
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    /*
    Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

    For example:
    Given binary tree {3,9,20,#,#,15,7},
        3
       / \
      9  20
        /  \
       15   7
    return its zigzag level order traversal as:
    [
      [3],
      [20,9],
      [15,7]
    ]
    */
    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean isReverse = false;
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        Stack<TreeNode> l1 = new Stack<TreeNode>(), l2 = new Stack<TreeNode>(), tmp;

        l1.add(root);
        while (!l1.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            while (!l1.isEmpty()) {
                TreeNode node = l1.pop();
                if (isReverse) {
                    if (node.right != null) {
                        l2.add(node.right);
                    }
                    if (node.left != null) {
                        l2.add(node.left);
                    }
                } else {
                    if (node.left != null) {
                        l2.add(node.left);
                    }
                    if (node.right != null) {
                        l2.add(node.right);
                    }
                }
                level.add(node.val);
            }
            isReverse = !isReverse;
            ret.add(level);
            tmp = l2;
            l2 = l1;
            l1 = tmp;
        }

        return ret;
    }

    /*
         1
        / \
       2   5
      / \   \
     3   4   6
     */
    private static void test() {
        Utils.printListListln(zigzagLevelOrder(TreeNode.getSampleTree()));
    }

    public static void main(String[] args) {
        test();
    }
}
