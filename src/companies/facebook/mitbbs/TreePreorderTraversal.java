package companies.facebook.mitbbs;

import utils.NTreeNode;
import jiaojiang.leetcode.onlinejudge.TreeNode;

/**
 * @author: mizhang
 * @since: Nov 27, 2013 1:50:49 PM
 */
public class TreePreorderTraversal {
    /*
    Given a regular tree, write the iterative preorder traversal algorithm
     */
    public static void preorder(NTreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + "\t");
        if (root.children == null) {
            return;
        }
        for (NTreeNode node : root.children) {
            preorder(node);
        }
    }

    public static void test() {
        NTreeNode root = NTreeNode.constructSampleTree();
        preorder(root);

        preorderBinaryTree(TreeNode.construct());
    }

    public static void preorderBinaryTree(TreeNode root) {
        
    }

    public static void main(String[] args) {
        test();
    }
}
