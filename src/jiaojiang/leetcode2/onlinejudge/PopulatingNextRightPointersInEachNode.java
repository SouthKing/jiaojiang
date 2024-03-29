package jiaojiang.leetcode2.onlinejudge;

import java.util.Queue;
import java.util.LinkedList;

/**
 * @author: mizhang
 * @since: Jan 9, 2014 2:27:09 PM
 */
public class PopulatingNextRightPointersInEachNode {
    /*
    Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
    Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

    Initially, all next pointers are set to NULL.

    Note:

    You may only use constant extra space.
    You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
    For example,
    Given the following perfect binary tree,
             1
           /  \
          2    3
         / \  / \
        4  5  6  7
    After calling your function, the tree should look like:
             1 -> NULL
           /  \
          2 -> 3 -> NULL
         / \  / \
        4->5->6->7 -> NULL
    */
    public static void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.add(root);
        queue.add(null);

        TreeLinkNode preNode = null;
        while (!queue.isEmpty()) {
            TreeLinkNode node = queue.remove();
            if (preNode != null) {
                preNode.next = node;
            }
            if (node == null && !queue.isEmpty()) {
                queue.add(null);
            }

            if (node != null && node.left != null) {
                queue.add(node.left);
            }

            if (node != null && node.right != null) {
                queue.add(node.right);
            }
            preNode = node;
        }
    }

    public static void connect2(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        root.next = null;

        TreeLinkNode leftMostNode = root, node, preNode;
        while (leftMostNode.left != null) {
            node = leftMostNode;
            node.left.next = node.right;
            preNode = node.right;
            node = node.next;

            while (node != null) {
                preNode.next = node.left;
                node.left.next = node.right;
                preNode = node.right;
                node = node.next;
            }
            leftMostNode = leftMostNode.left;
        }
    }
}
