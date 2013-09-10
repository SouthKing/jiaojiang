package jiaojiang.misc;

/**
 * @author: mizhang
 * @since: Sep 9, 2013 2:16:05 PM
 */
public class TreeNode {
    
    public TreeNode leftChild;

    public TreeNode rightChild;

    public TreeNode parent;

    public int val;

    public TreeNode(int val) {
        this.val = val;
    }

    public static TreeNode getSampleBST() {
        TreeNode root = new TreeNode(10);

        root.leftChild = new TreeNode(5);
        root.rightChild = new TreeNode(16);

        root.leftChild.leftChild = new TreeNode(4);
        root.leftChild.rightChild = new TreeNode(8);
        root.rightChild.leftChild = new TreeNode(13);
        root.rightChild.rightChild = new TreeNode(18);

        root.leftChild.leftChild.leftChild = new TreeNode(3);
        root.leftChild.rightChild.leftChild = new TreeNode(7);

        root.rightChild.rightChild.leftChild = new TreeNode(17);
        root.rightChild.rightChild.rightChild = new TreeNode(19);

        populateParent(root, null);


        return root;
    }

    public void inOrder() {
        inOrder(this);
    }

    public static void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.leftChild);
        System.out.println(node.val);
        inOrder(node.rightChild);
    }

    private static void populateParent(TreeNode node, TreeNode parent) {
        if (node == null) {
            return;
        }
        node.parent = parent;
        populateParent(node.leftChild, node);
        populateParent(node.rightChild, node);
    }

    public static void main(String[] args) {
        getSampleBST().inOrder();
    }

}
