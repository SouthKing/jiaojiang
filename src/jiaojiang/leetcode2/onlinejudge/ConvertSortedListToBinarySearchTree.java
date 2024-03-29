package jiaojiang.leetcode2.onlinejudge;

import java.util.Set;
import java.util.HashSet;
import java.util.List;

/**
 * @author: zhang
 * @since: Jan 26, 2014 10:33:16 PM
 */
public class ConvertSortedListToBinarySearchTree {
    /*
    Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
     */
    public static TreeNode sortedListToBST(ListNode head) {
        int length;
        ListNode node;

        for (length = 0, node = head; node != null; node = node.next, length++);

        ListNode[] nodes = new ListNode[1];
        nodes[0] = head;
        
        return sortedLlistToBST(nodes, 0, length - 1);
    }

    public static TreeNode sortedLlistToBST(ListNode[] head, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) >>> 1;

        TreeNode left = sortedLlistToBST(head, start, mid - 1);
        TreeNode p = new TreeNode(head[0].val);
        head[0] = head[0].next;
        TreeNode right = sortedLlistToBST(head, mid + 1, end);
        p.left = left;
        p.right = right;

        return p;
    }

    private static void test() {
        TreeNode.inOrder(sortedListToBST(ListNode.getSampleList(3)));
        System.out.println("");
        TreeNode.inOrder(sortedListToBST(ListNode.getSampleList(7)));
    }

    public static void main(String[] args) {
        test();
    }
}
