package jiaojiang.leetcode2.onlinejudge;

import java.util.ArrayList;

/**
 * @author: zhang
 * @since: Jan 21, 2014 3:21:14 PM
 */
public class MergeKSortedLists {
    /*
    Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
    */
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists.isEmpty()) {
            return null;
        }
        
        while (lists.size() > 1) {
            for (int i = 0, l = lists.size(); i < (l >> 1); i++) {
                lists.set(i, mergeLists(lists.get(i), lists.get(l - i - 1)));
                lists.remove(l - i - 1);
            }
        }

        return lists.get(0);
    }

    private static ListNode mergeLists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0), insertNode = dummyNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                insertNode.next = l1;
                l1 = l1.next;
            } else {
                insertNode.next = l2;
                l2 = l2.next;
            }
            insertNode = insertNode.next;
        }

        if (l1 != null) {
            insertNode.next = l1;
        } else {
            insertNode.next = l2;
        }

        return dummyNode.next;
    }
}
