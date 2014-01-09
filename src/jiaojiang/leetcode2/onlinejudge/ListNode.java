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

    public static ListNode getSampleList(int length) {
        return getSampleList(0, length);
    }

    public static ListNode getSampleList(int start, int length) {
        if (length == 0) {
            return null;
        }

        ListNode root = new ListNode(start);
        ListNode pre = root;
        for (int i = 1; i < length; i++) {
            pre.next = new ListNode(start + i + 1);
            pre = pre.next;
        }

        return root;
    }
}
