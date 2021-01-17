package algo.list;

import algo.ListNode;

/**
 * https://leetcode-cn.com/problems/odd-even-linked-list
 */
public class ListLC328 {

    public static void main(String[] args) {
        ListNode h = new ListNode(2);
        ListNode head = h;
        h.next = new ListNode(1);
        h = h.next;
        h.next = new ListNode(3);
        h = h.next;
        h.next = new ListNode(5);
        h = h.next;
        h.next = new ListNode(6);
        h = h.next;
        h.next = new ListNode(4);
        h = h.next;
        h.next = new ListNode(7);

        ListLC328 instance = new ListLC328();

        ListNode newHead = instance.oddEvenList(head);

        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;

        return head;
    }
}
