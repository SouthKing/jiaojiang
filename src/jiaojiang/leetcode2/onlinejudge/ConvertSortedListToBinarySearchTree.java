package jiaojiang.leetcode2.onlinejudge;

/**
 * @author: zhang
 * @since: Jan 26, 2014 10:33:16 PM
 */
public class ConvertSortedListToBinarySearchTree {
    /*
    Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
     */
    public static TreeNode sortedListToBST(ListNode head) {

    }

    private static void test() {
        TreeNode.inOrder(sortedListToBST(ListNode.getSampleList(7)));
    }

    public static void main(String[] args) {
        test();
    }
}
