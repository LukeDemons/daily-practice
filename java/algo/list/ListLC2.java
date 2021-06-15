package algo.list;

import algo.ListNode;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 *
 * 6.10 猿辅导二面原题
 */
public class ListLC2 {

    public static void main(String[] args) {
        // 每个值求和
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        ListLC2 instance = new ListLC2();
        ListNode newHead = instance.addTwoNumbers(head, head);

        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;

        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        int addOne = 0;

        while (l1 != null || l2 != null || addOne != 0) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int sum = val1 + val2 + addOne;

            head.next = new ListNode(sum % 10);
            head = head.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

            addOne = sum / 10;
        }

        return dummy.next;
    }
}