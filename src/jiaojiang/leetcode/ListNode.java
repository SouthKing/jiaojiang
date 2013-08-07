package jiaojiang.leetcode;

/**
 * @author: zhang
 * @since: Apr 14, 2013 4:10:28 PM
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
   }

    public void print() {
            ListNode next = this;
            while (next.next != null) {
                System.out.print(next.val + " --> ");
                next = next.next;
            }
            System.out.println(next.val);
    }
}
