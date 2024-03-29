package jiaojiang.leetcode2.onlinejudge;

/**
 * @author: zhang
 * @since: Jan 5, 2014 1:50:03 AM
 */
public class ReverseNodeInKGroup {
    /*
    Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

    If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

    You may not alter the values in the nodes, only nodes itself may be changed.

    Only constant memory is allowed.

    For example,
    Given this linked list: 1->2->3->4->5

    For k = 2, you should return: 2->1->4->3->5

    For k = 3, you should return: 3->2->1->4->5
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k < 2 || head == null || head.next == null) {
            return head;
        }

        ListNode newHead = head;
        for (int i = 1; i < k; i++, newHead = newHead.next){
            if (newHead.next == null) {
                return head;
            }
        }

        ListNode node = head;
        for (int i = 1; i < k; i++) {
            ListNode next = node.next;
            node.next = newHead.next;
            newHead.next = node;
            node = next;
        }

        head.next = reverseKGroup(head.next, k);

        return newHead;
    }

    private static void test() {
        ListNode.print(reverseKGroup(ListNode.getSampleList(5), 2));
        ListNode.print(reverseKGroup(ListNode.getSampleList(5), 3));
        ListNode.print(reverseKGroup(null, 1));
    }

    public static void main(String[] args){
        test();
    }
}
