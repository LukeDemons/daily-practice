package algo.list;

import algo.ListNode;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 *
 * 2021-03-26 每日一提
 * 经历了昨天的medium，今天的确实easy。。。
 */
public class ListLC83 {

    public static void main(String[] args) {
        ListLC83 instance = new ListLC83();

        ListNode result = instance.deleteDuplicates(ListNode.init(1,1,2));

        ListNode.print(result);
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = dummy;

        while (head != null) {
            if (head.next == null || head.val != head.next.val) {
                tail.next = head;
                tail = tail.next;
            }
            head = head.next;
        }
        tail.next = null;
        return dummy.next;
    }
}
