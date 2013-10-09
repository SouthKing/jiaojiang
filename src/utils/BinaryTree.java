package utils;

import companies.twitter.mitbbs.QueueStackUtil;

import java.util.*;

/**
 * @author: zhang
 * @since: Jan 13, 2013 2:12:33 AM
 */
public class BinaryTree<T> {

    public Node<T> root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(Node<T> root) {
        this.root = root;
    }

    public BinaryTree(T value) {
        root = new Node<T>(value);
    }

    public Node<T> getRoot() {
        return root;
    }

    public void inOrder() {
        inOrder(root);
    }

    public List<Node<T>> inOrderList() {
        List<Node<T>> nodes = new ArrayList<Node<T>>();
        inOrderList(root, nodes);
        return nodes;
    }

    public void inOrderIterative() {
        inOrderIterative(root);
    }

    public void preOrder() {
        preOrder(root);
    }

    public List<Node<T>> preOrderList() {
        List<Node<T>> nodes = new ArrayList<Node<T>>();
        preOrderList(root, nodes);
        return nodes;
    }

    public void preOrdreIterative() {
        preOrderIterative(root);
    }

    public void postOrder() {
        postOrder(root);
    }

    public void postOrderIterative() {
        postOrderIterative(root);
    }

    public void path() {
        path(root, new ArrayList<Node<T>>());
    }

    public void bsf() {
        BFS(root);
    }

    public void mirror() {
        mirror(root);
    }

    public void reconstruct(List<Node<T>> preOrder, List<Node<T>> inOrder) {
        root = reconstruct(preOrder, inOrder, 0, inOrder.size());
    }

    public static<T> Node<T> reconstruct(List<Node<T>> preOrder, List<Node<T>> inOrder, int inOrderStart, int inOrderEnd) {

        if (preOrder.isEmpty()) {
            return null;
        }

        Node<T> root = preOrder.get(0);

        int mid = 0;

        for (int i = inOrderStart; i < inOrderEnd; i++) {
            if (root == inOrder.get(i)) {
                mid = i;
            }
        }

        Set<Node<T>> leftSubtree = new HashSet<Node<T>>(inOrder.subList(inOrderStart, mid));

        List<Node<T>> leftNodes = new ArrayList<Node<T>>();
        List<Node<T>> rightNodes = new ArrayList<Node<T>>();

        for (int i = 1; i < preOrder.size(); i++) {
            Node<T> node = preOrder.get(i);
            if (leftSubtree.contains(node)) {
                leftNodes.add(node);
            } else {
                rightNodes.add(node);
            }
        }

        root.leftChild = reconstruct(leftNodes, inOrder, inOrderStart, mid);
        root.rightChild = reconstruct(rightNodes, inOrder, mid + 1, inOrderEnd);

        return root;
    }

    public static<T> void mirror(Node<T> root) {
        if (root == null) {
            return;
        }

        Node<T> tmp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = tmp;

        mirror(root.rightChild);
        mirror(root.leftChild);
    }

    private static<T> void inOrderList(Node<T> root, List<Node<T>> nodes) {
        if (root == null) {
            return;
        }

        inOrderList(root.leftChild, nodes);
        nodes.add(root);
        inOrderList(root.rightChild, nodes);
    }

    private static<T> void preOrderList(Node<T> root, List<Node<T>> nodes) {
        if (root == null) {
            return;
        }

        nodes.add(root);
        preOrderList(root.leftChild, nodes);
        preOrderList(root.rightChild, nodes);
    }

    private static<T> void inOrder(Node<T> root) {
        if (root == null) {
            return;
        }
        inOrder(root.leftChild);
        System.out.println(root.getValue());
        inOrder(root.rightChild);
    }

    private static<T> void inOrderIterative(Node<T> root) {
        Node<T> node = root;
        Stack<Node<T>> stack = new Stack<Node<T>>();

        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.leftChild;
            } else {
                node = stack.pop();
                System.out.println(node.value);
                node = node.rightChild;
            }
        }
    }

    public static<T> void preOrder(Node<T> root) {
        if (root == null) {
            return;
        }

        System.out.println(root.value);

        preOrder(root.leftChild);
        preOrder(root.rightChild);
    }

    public static<T> void preOrderIterative(Node<T> root) {
        Node<T> node = root;
        Stack<Node<T>> stack = new Stack<Node<T>>();

        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                System.out.println(node.value);
                stack.push(node);
                node = node.leftChild;
            } else {
                node = stack.pop();
                node = node.rightChild;
            }
        }
    }

    public static<T> void postOrder(Node<T> root) {
        if (root == null) {
            return;
        }

        postOrder(root.leftChild);
        postOrder(root.rightChild);
        System.out.println(root.value);
    }

    public static<T> void postOrderIterative(Node<T> root) {
        if (root == null) {
            return;
        }
        Stack<Node<T>> stack = new Stack<Node<T>>();
        stack.push(root);
        Node<T> node;

        while (!stack.isEmpty()) {
            node =  stack.peek();
            
        }



    }

    private static<T> void DFS(Node<T> root) {
        

    }

    public Node<T> LCA(Node<T> target1, Node<T> target2) {
        return LCA(root, target1, target2);
    }

    private static<T> Node<T> LCA(Node<T> root, Node<T> target1, Node<T> target2) {
        if (root== null) {
            return null;
        }

        if (root == target1 || root == target2) {
            return null;
        }

        boolean leftExist = doesExist(root.getLeftChild(), target1, target2);
        boolean rightExist = doesExist(root.getRightChild(), target1, target2);

        if (leftExist && rightExist) {
            return root;
        }

        if (leftExist) {
            return LCA(root.getLeftChild(), target1, target2);
        }

        if (rightExist) {
            return LCA(root.getRightChild(), target1, target2);
        }

        return null;
    }

    private static<T> boolean doesExist(Node<T> root, Node<T> target1, Node<T> target2) {
        if (root == null) {
            return false;
        }

        if (root == target1 || root == target2) {
            return true;
        }

        if (doesExist(root.getLeftChild(), target1, target2)) {
            return true;
        }

        if (doesExist(root.getRightChild(), target1, target2)) {
            return true;
        }

        return false;
    }

    private static<T> void path(Node<T> root, List<Node<T>> path) {
        if (root.leftChild == null && root.rightChild == null) {
            for (Node<T> n : path) {
                System.out.print(n.value + "->");
            }
            System.out.println(root.value);
            return;
        }

        if (root.leftChild != null) {
            path.add(root);
            path(root.leftChild, path);
            path.remove(path.size() - 1);
        }

        if (root.rightChild != null) {
            path.add(root);
            path(root.rightChild, path);
            path.remove(path.size() - 1);
        }
    }

    public static class Node<T> {

        public T value;
        public Node<T> leftChild;
        public Node<T> rightChild;

        public Node(T value) {
            this.value = value;
            leftChild = null;
            rightChild = null;
        }

        public Node<T> getLeftChild() {
            return leftChild;
        }

        public Node<T> getRightChild() {
            return rightChild;
        }

        public T getValue() {
            return value;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }

        public void setValue(T value) {
            this.value = value;
        }

    }

    public static BinaryTree<Integer> getSampleBinaryTree() {
        Node<Integer> root = new Node<Integer>(10);

        root.leftChild = new Node<Integer>(8);
        root.rightChild = new Node<Integer>(7);

        root.leftChild.leftChild =  new Node<Integer>(18);
        root.leftChild.rightChild = new Node<Integer>(4);

        root.rightChild.rightChild = new Node<Integer>(21);

        root.leftChild.leftChild.rightChild = new Node<Integer>(6);
        root.rightChild.rightChild.leftChild = new Node<Integer>(16);

        return new BinaryTree<Integer>(root);
    }

    private static<T> void BFS(Node<T> node) {
        QueueStackUtil<Node<T>> tmp, current = new QueueStackUtil<Node<T>>(), next = new QueueStackUtil<Node<T>>();

        current.enqueue(node);

        while (!current.isEmpty()) {
            while (!current.isEmpty()) {
                Node<T> n = current.deQueue();
                System.out.print(n.getValue() + "\t");
                if (n.leftChild != null) {
                    next.enqueue(n.leftChild);
                }
                if (n.rightChild != null) {
                    next.enqueue(n.rightChild);
                }
            }
            System.out.println();
            tmp = current;
            current = next;
            next = tmp;
        }
    }



    public static void testTraversal() {
        BinaryTree<Integer> binaryTree = getSampleBinaryTree();
//        binaryTree.inOrder();
//        System.out.println("======");
//        binaryTree.inOrderIterative();
//
//        binaryTree.preOrder();
//        System.out.println("======");
//        binaryTree.preOrdreIterative();

        binaryTree.postOrder();
        System.out.println("======");
        binaryTree.postOrderIterative();
    }

    public static void testMirror() {
        BinaryTree<Integer> binaryTree = getSampleBinaryTree();
        binaryTree.mirror();
        binaryTree.bsf();
    }

    public static void testReconstruct() {
        BinaryTree<Integer> binaryTree = getSampleBinaryTree();
        binaryTree.inOrder();
        System.out.println("======");
        binaryTree.preOrder();
        System.out.println("--------");
        BinaryTree<Integer> binaryTree2 = new BinaryTree<Integer>();
        binaryTree2.reconstruct(binaryTree.preOrderList(), binaryTree.inOrderList());
        binaryTree2.inOrder();
        System.out.println("======");
        binaryTree2.preOrder();
    }

    public static void main(String[] args) {
//        testTraversal();
//        testMirror();
        testReconstruct();
//        System.out.println(binaryTree.LCA(binaryTree.getRoot().leftChild.rightChild, binaryTree.getRoot().rightChild.rightChild).getValue());
//        binaryTree.bsf();
    }

}
