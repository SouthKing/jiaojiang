package jiaojiang.leetcode.onlinejudge;

/**
 * @author: mizhang
 * @since: Nov 18, 2013 2:21:50 PM
 */
public class SortList {
    /*
    Sort a linked list in O(n log n) time using constant space complexity.
     */
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = head, nodeNext = head;

        while (nodeNext != null && nodeNext.next != null) {
            node = node.next;
            nodeNext = nodeNext.next.next;
        }

        ListNode head2 = sortList(node.next);
        node.next = null;
        ListNode head1 = sortList(head);

        ListNode dummyHead = new ListNode(0);
        node = dummyHead;

        while (head1 != null && head2 != null) {
            if (head1.val > head2.val) {
                node.next = head2;
                head2 = head2.next;
            } else {
                node.next = head1;
                head1 = head1.next;
            }
            node = node.next;
            node.next = null;
        }

        while (head1 != null) {
            node.next = head1;
            head1 = head1.next;
        }

        return dummyHead.next;
    }

    private static void test() {
        ListNode head = ListNode.constructRandomList(10);
        head.print();
        sortList(head).print();
    }

    public static void main(String[] args) {
        test();
    }
}
