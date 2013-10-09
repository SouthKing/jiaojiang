package companies.amazon.mitbbs.tree;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author: zhang
 * @since: Jul 25, 2010 11:22:47 PM
 */
public class BinaryTree {
    protected Node root;

    private static int nodeSerialNumber = 0;

    public BinaryTree() {
        this.root = createBinaryTree(2);
    }

    public BinaryTree(int level) {
        this.root = createBinaryTree(level);
    }

    public Node createBinaryTree(int level) {
        return createBinaryTree(0, level);
    }


    public Node createBinaryTree(int currentLevel, int level) {
        Node node = new Node(nodeSerialNumber++);

        if (currentLevel == level) {
            return node;
        }

        Node leftChild, rightChild;
        leftChild = createBinaryTree(currentLevel + 1, level);
        rightChild = createBinaryTree(currentLevel + 1, level);
        node.leftChild = leftChild;
        node.rigthChild = rightChild;

        return node;
    }

    public void iterativeInOrderTraverse() {
        if (this.root == null) {
            return;
        }
        
        Stack<Node> nodes = new Stack<Node>();
        Node node = this.root;
        nodes.push(node);

        while(!nodes.isEmpty()) {
            if(node.leftChild != null) {
                node = node.leftChild;
                nodes.push(node);
            } else {
                nodes.pop();
                System.out.println(node.value);
                while(node.rigthChild == null) {
                    if (nodes.isEmpty()) {
                        return;
                    }
                    node = nodes.pop();
                    System.out.println(node.value);
                }
                node = node.rigthChild;
                nodes.push(node);
            }
        }
    }

    public void iterativePostOrderTraverse() {
        if (this.root == null) {
            return;
        }

        Stack<Node> nodes = new Stack<Node>();
        Node preNode = this.root, curNode = this.root;
        nodes.push(curNode);

        while (!nodes.isEmpty()) {
            if (curNode.leftChild != null) {
                preNode = curNode;
                curNode = curNode.leftChild;
                nodes.push(curNode);
            } else {
                while (curNode.rigthChild == null || curNode.rigthChild == preNode) {
                    curNode = nodes.pop();
                    System.out.println(curNode.value);
                    if (nodes.isEmpty()) {
                        return;
                    }
                    preNode = curNode;
                    curNode = nodes.peek();
                }
                preNode = curNode;
                curNode = curNode.rigthChild;
                nodes.push(curNode);
            }
        }
    }

    public void iterativePreorderTraverse() {
        if (this.root == null) {
            return;
        }

        Stack<Node> nodes = new Stack<Node>();
        nodes.push(this.root);

        while (!nodes.isEmpty()) {
            Node node = nodes.pop();
            System.out.println(node.value);
            if (node.rigthChild != null)  {
                nodes.push(node.rigthChild);
            }
            if (node.leftChild != null) {
                nodes.push(node.leftChild);
            }
        }
    }


    public void inOrderTraverse() {
        inOrderTraverse(this.root);
    }

    public static void inOrderTraverse(Node node) {
        if (node == null) {
            return;
        }

        if (node.leftChild == null && node.rigthChild == null) {
            System.out.println(node.value);
            return;
        }

        if (node.leftChild != null) {
            inOrderTraverse(node.leftChild);
        }

        System.out.println(node.value);

        if (node.rigthChild != null) {
            inOrderTraverse(node.rigthChild);
        }
    }

    public void levelTraverse() {
        Queue<Node> nodes = new LinkedList<Node>();
        nodes.offer(this.root);
        Node node;

        while ((node = nodes.poll()) != null) {
            System.out.println(node.value);
            if (node.leftChild != null) {
                nodes.offer(node.leftChild);
            }

            if (node.rigthChild != null) {
                nodes.offer(node.rigthChild);
            }
        }
    }

    public void sumLevel() {
        Queue<Node> nodes = new LinkedList<Node>();
        Node node, delimiter;
        delimiter = new Node(Integer.MAX_VALUE);
        nodes.add(this.root);
        nodes.add(delimiter);
        int sum = 0;

        while ((node = nodes.poll()) != null ) {
            if (node.value == Integer.MAX_VALUE) {
                nodes.offer(delimiter);
                System.out.println(sum);
                sum = 0;
                node = nodes.poll();
            }

            if (node.value == Integer.MAX_VALUE) {
                return;
            }

            sum += node.value;
            if (node.leftChild != null) {
                nodes.offer(node.leftChild);
            }

            if (node.rigthChild != null) {
                nodes.offer(node.rigthChild);
            }
        }
    }

    public static Node leftMost(Node root) {
        Node node = root;
        if (node == null) {
            return null;
        }

        while (node.leftChild != null) {
            node = node.leftChild;
        }

        return node;
    }

    public static Node rightMost(Node root) {
        Node node = root;
        if (node == null) {
            return null;
        }

        while (node.rigthChild != null) {
            node = node.rigthChild;
        }

        return node.rigthChild;
    }

    public static class Node {
        public int value;
        public Node leftChild;
        public Node rigthChild;

        public Node(int value) {
            this.value = value;
            this.leftChild = null;
            this.rigthChild = null;
        }

        public Node(Node anotherNode) {
            this.value = anotherNode.value;
            this.leftChild = anotherNode.leftChild;
            this.rigthChild = anotherNode.rigthChild;
        }

        public void copy(Node anotherNode) {
            this.value = anotherNode.value;
            this.leftChild = anotherNode.leftChild;
            this.rigthChild = anotherNode.rigthChild;
        }
    }

    public static void main(String[] argv) {
        BinaryTree tree = new BinaryTree();
//        tree.inOrderTraverse();
//        tree.levelTraverse();
        tree.sumLevel();
        
    }
}
