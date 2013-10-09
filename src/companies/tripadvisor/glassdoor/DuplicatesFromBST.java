package companies.tripadvisor.glassdoor;

import jiaojiang.twitter.BST;
import jiaojiang.twitter.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhang
 * @since: Apr 15, 2013 12:45:19 AM
 */
public class DuplicatesFromBST {
    //Count the number of duplicates in a BST without using recursion and constant space
    public static int getDuplicates(BST bst) {
        return getDuplicatesHelp(bst.root, bst.root.value, -1);
    }

    public static int getDuplicatesHelp(BinaryTree.Node<Integer> node, int pre, int count) {
        if (node == null) {
            return count;
        }

        int ret = getDuplicatesHelp(node.leftChild, pre, count);

        if (pre == node.value) {
            return getDuplicatesHelp(node.rightChild, pre, ret + 1);
        }

        return getDuplicatesHelp(node.rightChild, node.value, ret);
    }

    public static void inOrderList(BinaryTree.Node<Integer> node, List<Integer> nodeList) {
        if (node == null) {
            return;
        }

        inOrderList(node.leftChild, nodeList);
        nodeList.add(node.value);
        inOrderList(node.rightChild, nodeList);
    }

    public static BST constructSampleBST() {
        BST bst = new BST(5);

        bst.root.leftChild = new BinaryTree.Node<Integer>(3);
        bst.root.rightChild = new BinaryTree.Node<Integer>(10);

        bst.root.leftChild.leftChild = new BinaryTree.Node<Integer>(2);
        bst.root.leftChild.rightChild = new BinaryTree.Node<Integer>(4);
        bst.root.rightChild.leftChild = new BinaryTree.Node<Integer>(8);
        bst.root.rightChild.rightChild = new BinaryTree.Node<Integer>(10);

        bst.root.leftChild.rightChild.leftChild = new BinaryTree.Node<Integer>(3);
        bst.root.rightChild.leftChild.leftChild = new BinaryTree.Node<Integer>(5);
        bst.root.rightChild.leftChild.rightChild = new BinaryTree.Node<Integer>(8);

        bst.root.rightChild.leftChild.rightChild.rightChild = new BinaryTree.Node<Integer>(9);

        bst.root.rightChild.leftChild.rightChild.rightChild.leftChild = new BinaryTree.Node<Integer>(8);

        return bst;
    }

    public static int countListDuplicate(List<Integer> list) {
        if (list.size() == 0) {
            return 0;
        }

        int count = 0, element = list.get(0);
        for (int i = 1, n = list.size(); i < n; i++) {
            if (list.get(i) == element) {
                count++;
            } else {
                element = list.get(i);
            }
        }

        return count;
    }

    public static void testList() {
        BST bst = constructSampleBST();

        List<Integer> list = new ArrayList<Integer>();
        inOrderList(bst.root, list);
        for (int i : list) {
            System.out.print(i + "\t");
        }
        System.out.println("\nTotal duplicates is: " + countListDuplicate(list) + "\n");

        System.out.println("Total duplicates is: " + getDuplicates(bst));
    }

    public static void main(String[] args) {
        testList();
    }
}