package jiaojiang.leetcode.onlinejudge;

/**
 * @author: zhang
 * @since: Apr 22, 2013 10:19:36 PM
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
}

