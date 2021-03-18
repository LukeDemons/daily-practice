package algo.list;

import algo.ListNode;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * <p>
 * 2021-03-18 每日一题
 * 链表题必须画图，希望后面可以不这么绕，不这么乱
 */
public class ListLC92 {

    public static void main(String[] args) {
        ListLC92 instance = new ListLC92();

        ListNode result = instance.reverseBetween(ListNode.init(1, 2, 3, 4, 5), 2, 4);

        ListNode.print(result);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        int count = 1;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy.next;
        while (count < left) {
            pre = pre.next;
            cur = cur.next;
            count++;
        }
        while (count < right) {
            ListNode removed = cur.next;
            cur.next = cur.next.next;

            removed.next = pre.next;
            pre.next = removed;
            count++;
        }

        return dummy.next;
    }
}
