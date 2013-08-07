package jiaojiang.leetcode;

import jiaojiang.leetcode.ListNode;

/**
 * @author: zhang
 * @since: Apr 14, 2013 1:47:00 AM
 */
public class SwapNodesInPair {

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead =  head.next;
        head.next =  swapPairs(newHead.next);
        newHead.next = head;

        return newHead;
    }

//test cases:
//{}
//
//{1}
//
//{1,2}
//
//{1,2,3}
//
//{1,2,3,4}
//
//{1,2,3,4,5}
//
//{4,8}
//
//{2,5,3,4,6,2,2}
}
