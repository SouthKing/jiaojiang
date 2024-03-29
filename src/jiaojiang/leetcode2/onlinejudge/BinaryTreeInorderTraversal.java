package jiaojiang.leetcode2.onlinejudge;

import utils.Utils;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author: zhang
 * @since: Jan 26, 2014 3:57:13 PM
 */
public class BinaryTreeInorderTraversal {
    /*
    Given a binary tree, return the inorder traversal of its nodes' values.

    For example:
    Given binary tree {1,#,2,3},
       1
        \
         2
        /
       3
    return [1,3,2].

    Note: Recursive solution is trivial, could you do it iteratively?
     */
    public static ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.add(node);
                node = node.left;
            } else {
                node = stack.pop();
                ret.add(node.val);
                node = node.right;
            }
        }

        return ret;
    }

    public static ArrayList<Integer> inorderTraversalRec(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        inorderTraversal(root, ret);
        return ret;
    }

    private static void inorderTraversal(TreeNode root, ArrayList<Integer> ret) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left, ret);
        ret.add(root.val);
        inorderTraversal(root.right, ret);
    }

    /*
         1
        / \
       2   5
      / \   \
     3   4   6
     */
    private static void test() {
        TreeNode root = TreeNode.getSampleTree();
        Utils.printListln(inorderTraversal(root));
        Utils.printListln(inorderTraversalRec(root));
    }

    public static void main(String[] args) {
        test();
    }
}
