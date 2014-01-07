package jiaojiang.leetcode2.onlinejudge;

/**
 * @author: mizhang
 * @since: Dec 31, 2013 3:15:13 PM
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + "\t");
        inOrder(root.right);
    }

    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + "\t");
        preOrder(root.left);
        preOrder(root.right);
    }

    /*
         1
        / \
       2   5
      / \   \
     3   4   6
     */
    public static TreeNode getSampleTree() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = getSampleTree();
        inOrder(root);
        System.out.println();
        preOrder(root);
    }
}
