package jiaojiang.misc;

import jiaojiang.utils.Utils;


/**
 * @author: mizhang
 * @since: Sep 9, 2013 2:14:46 PM
 */
public class NextBST {

    //return the next node in BST given the current node, also the parent of the current node is available
    public static int nextNode(TreeNode node) {

        if (node.rightChild != null) {
            TreeNode tmpNode = node.rightChild;
            while (tmpNode.leftChild != null) {
                tmpNode = tmpNode.leftChild;
            }
            return tmpNode.val;
        }

        TreeNode n = node, p = node.parent;

        while (p != null && p.rightChild == n) {
            n = p;
            p = n.parent;
        }

        return p == null ? Integer.MIN_VALUE : p.val;

    }

    public static void test() {
        TreeNode root = TreeNode.getSampleBST();

        Utils.println(nextNode(root.leftChild), 7);
        Utils.println(nextNode(root.leftChild.leftChild), 5);
        Utils.println(nextNode(root.rightChild), 17);
        Utils.println(nextNode(root.rightChild.leftChild), 16);
        Utils.println(nextNode(root.rightChild.rightChild), 19);
    }

    public static void main(String[] args) {
        test();
    }
}
