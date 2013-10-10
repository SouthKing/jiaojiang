package companies.amazon.mitbbs.tree;

/**
 * @author: zhang
 * @since: Jul 26, 2010 8:26:34 PM
 */
public class BinarySearchTree extends BinaryTree{

    public BinarySearchTree() {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        super.root = createBST(data, 0, data.length);
    }

    private static Node createBST(int[] data, int from, int to) {
        if (from + 1 > to) {
            return null;
        }

        if (from + 1 == to ) {
            Node node = new Node(data[from]);
            return node;
        }
        
        int mid = from + to >> 1;
        Node node = new Node(data[mid]);
        node.leftChild = createBST(data, from, mid);
        node.rigthChild = createBST(data, mid + 1, to);

        return node;       
    }

    


    public static boolean isBST(Node root) {
        if (root == null) {
            return true;
        }
        int intMost;
        Node nodeMost = leftMost(root);
        if (nodeMost != null) {
            intMost = nodeMost.value;
            if (root.value < intMost) {
                return false;
            }
        }
        nodeMost = rightMost(root);
        if (nodeMost != null) {
            intMost = nodeMost.value;
            if (root.value > nodeMost.value) {
                return false;
            }
        }

        return isBST(root.leftChild) && isBST(root.rigthChild);
    }

    public static int getNthMax(Node root, int n, Node target) {
        if (root == null) {
            return 0;
        }

        int i = getNthMax(root.rigthChild, n, target);
        if (i == n) {
            return n;
        }

        if (i + 1 == n) {
            target.copy(root);
            return n;
        }

        int j = getNthMax(root.leftChild, n - i - 1, target);
        if (j == n - i - 1) {
            return n;
        }
        return j + i + 1;
    }

    

    public static void main(String[] argv) {
        BinarySearchTree bst = new BinarySearchTree();
//        BinaryTree bt = new BinaryTree();
//        bst.inOrderTraverse();
//        bst.levelTraverse();
//        System.out.printTestln(isBST(bst.root));
//        System.out.printTestln(isBST(bt.root));
//        Node target = new Node(Integer.MAX_VALUE);
//        System.out.printTestln(getNthMax(bst.root, 8, target));
//        System.out.printTestln(target.value);

//        bst.iterativeInOrderTraverse();
//        bst.iterativePostOrderTraverse();
        bst.iterativePreorderTraverse();
    }
}
