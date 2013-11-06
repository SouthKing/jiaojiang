package jiaojiang.leetcode.onlinejudge;

/**
 * @author: zhang
 * @since: Nov 5, 2013 10:13:55 PM
 */
public class ReorderList {
    /*
    Given a singly linked list L: L0?L1?…?Ln-1?Ln,
    reorder it to: L0?Ln?L1?Ln-1?L2?Ln-2?…

    You must do this in-place without altering the nodes' values.

    For example,
    Given {1,2,3,4}, reorder it to {1,4,2,3}.
     */
    public static void reorderList(ListNode head) {

    }

    private static void test() {
        ListNode head = ListNode.constructList(10);
        head.print();

        reorderList(head);
        head.print();
    }

    public static void main(String[] args){
        test();
    }
}
