package algo.list;

import algo.ListNode;

/**
 * https://leetcode-cn.com/problems/partition-list/
 */
public class ListLC86 {

    public static void main(String[] args) {
        ListLC86 instance = new ListLC86();

        ListNode result = instance.partition(ListNode.init(1, 4, 3, 2, 5, 2), 3);

        ListNode.print(result);
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode lower = new ListNode(0);
        ListNode lowerDummy = lower;
        ListNode upper = new ListNode(0);
        ListNode upperDummy = upper;

        while (head != null) {
            if (head.val < x) {
                lower.next = head;
                lower = lower.next;
            } else {
                upper.next = head;
                upper = upper.next;
            }
            head = head.next;
        }
        upper.next = null;
        lower.next = upperDummy.next;

        return lowerDummy.next;
    }
}
