package utils;

/**
 * @author: zhang
 * @since: Jan 13, 2013 2:27:49 AM
 */
public class BST extends BinaryTree<Integer> {


    public BST(int value) {
        super(value);
    }

    public boolean isBST() {
        return isBST(this.root);
    }

    public static void insertNode(Node<Integer> root, int v) {
        Node<Integer> c = root, p = null, node = new Node<Integer>(v);

        while (c != null) {
            p = c;
            if ( v < c.getValue()) {
                c = c.leftChild;
            } else {
                c = c.rightChild;
            }
        }

        if (p == null) {
            root = node;
        } else if(v < p.getValue()) {
            p.leftChild = node;
        } else {
            p.rightChild = node;
        }
    }

    private static boolean isBST(Node<Integer> root) {
        if (root == null) {
            return true;
        }

        return isBST(root.leftChild) && isBST(root.rightChild) && (root.leftChild == null || root.getValue() > getMax(root.leftChild)) && (root.rightChild == null || root.getValue() < getMin(root.rightChild));
    }

    private static int getMin(Node<Integer> root) {
        Node<Integer> node = root;
        while (node.leftChild != null) {
            node = node.leftChild;
        }
        return node.getValue();
    }

    private static int getMax(Node<Integer> root) {
        Node<Integer> node = root;
        while (node.rightChild != null) {
            node = node.rightChild;
        }

        return node.getValue();
    }

    public int getMin() {
        return getMin(root);
    }

    public int getMax() {
        return getMax(root);
    }

    public static Node<Integer> getDoubleLinkedList(Node<Integer> root) {
        if (root == null) {
            return null;
        }

        Node<Integer> preNode = getDoubleLinkedList(root.leftChild);
        Node<Integer> postNode = getDoubleLinkedList(root.rightChild);
        Node<Integer> node = preNode;

        if (node == null) {
            preNode = root;
            preNode.leftChild = null;
        } else  {
            while (node.rightChild != null) {
                node = node.rightChild;
            }
            node.rightChild = root;
            root.leftChild = node;
        }


        root.rightChild = postNode;
        if (postNode != null) {
            postNode.leftChild = root;
        }

        return preNode;
    }

    public static BST constructSampleBST() {
        BST bst = new BST(10);

        bst.root.leftChild = new Node<Integer>(5);
        bst.root.rightChild = new Node<Integer>(16);

        bst.root.leftChild.leftChild = new Node<Integer>(3);
        bst.root.leftChild.rightChild = new Node<Integer>(7);
        bst.root.rightChild.leftChild = new Node<Integer>(13);
        bst.root.rightChild.rightChild = new Node<Integer>(19);

        bst.root.leftChild.leftChild.leftChild = new Node<Integer>(1);
        bst.root.leftChild.rightChild.leftChild = new Node<Integer>(6);
        bst.root.leftChild.rightChild.rightChild = new Node<Integer>(8);
        bst.root.rightChild.rightChild.rightChild = new Node<Integer>(31);

        return bst;
    }

    public static BST constructSampleNonBST() {
        BST nonBST = constructSampleBST();
        nonBST.root.leftChild.rightChild.value = 9;
        return nonBST;
    }

    public static void testGetDoubleLinkedList() {
        BST bst = constructSampleBST();

        Node<Integer> head = getDoubleLinkedList(bst.root);

        System.out.print(head.value + "\t");
        while (head.rightChild != null) {
            head = head.rightChild;
            System.out.print(head.value + "\t");
        }

        System.out.println();
        System.out.print(head.value + "\t");
        while (head.leftChild != null) {
            head = head.leftChild;
            System.out.print(head.value + "\t");
        }
    }

    public static void main(String[] args) {
//        BST bst = constructSampleBST();
//        BST nonBst = constructSampleNonBST();
//        bst.inOrder();
//        System.out.printTestln(bst.isBST());
//        System.out.printTestln(nonBst.isBST());

//        BST bst = constructSampleBST();
//        bst.inOrder();
//        bst.path();
        testGetDoubleLinkedList();
    }


}
