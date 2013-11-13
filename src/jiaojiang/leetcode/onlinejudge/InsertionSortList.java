package jiaojiang.leetcode.onlinejudge;

/**
 * @author: mizhang
 * @since: Nov 13, 2013 10:40:11 AM
 */
public class InsertionSortList {
    /*
    Sort a linked list using insertion sort.
     */
    public static ListNode insertionSortList(ListNode head) {
        ListNode dummyHead = new ListNode(0), node = head, nextNode;

        for (int i = 0; node != null; i++, node = nextNode) {
            ListNode insertPos = dummyHead;
            for (int j = 0; j < i && node.val > insertPos.next.val; j++, insertPos = insertPos.next);

            nextNode = node.next;
            node.next = insertPos.next;
            insertPos.next = node;
        }

        return dummyHead.next;
    }

    public static void test() {
        insertionSortList(ListNode.constructRandomList(10)).print();
        insertionSortList(ListNode.constructRandomList(10)).print();
    }

    public static void main(String[] args) {
        test();
    }
}
