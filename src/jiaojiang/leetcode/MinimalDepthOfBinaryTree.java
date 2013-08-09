package jiaojiang.leetcode;

import java.util.Queue;
import java.util.LinkedList;

/**
 * @author: zhang
 * @since: Apr 23, 2013 9:47:46 PM
 */
public class MinimalDepthOfBinaryTree {
    /*
    Given a binary tree, find its minimum depth.
    The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
     */
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(null);

        int depth = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node == null) {
                depth++;
                queue.add(null);
            } else if (node.left == null && node.right == null) {
                return depth;
            } else {
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return depth;
    }

    public static void test() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(5);

        System.out.println(minDepth(root));
    }

    public static void main(String[] args) {
        test();
    }
}
