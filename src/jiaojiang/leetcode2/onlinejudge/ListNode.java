package jiaojiang.leetcode2.onlinejudge;

/**
 * @author: zhang
 * @since: Jan 5, 2014 1:51:18 AM
 */
public class ListNode {
    
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    public static void print(ListNode root) {
        ListNode node = root;
        while (node != null) {
            System.out.print(node.val + "\t");
            node = node.next;
        }
        System.out.println();
    }

    public static ListNode getSampleList(int k) {
        if (k == 0) {
            return null;
        }

        ListNode root = new ListNode(1);
        ListNode pre = root;
        for (int i = 1; i < k; i++) {
            pre.next = new ListNode(i + 1);
            pre = pre.next;
        }

        return root;
    }
}
