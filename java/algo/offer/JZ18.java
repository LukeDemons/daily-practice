package algo.offer;

import algo.ListNode;

/**
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 * <p>
 * 2021-05-15 链表最简单思路，牢记哨兵，注意边界
 */
public class JZ18 {

    public static void main(String[] args) {
        JZ18 instance = new JZ18();

//        ListNode result = instance.deleteNode(ListNode.init(4, 5, 1, 9), 5);
//        ListNode result = instance.deleteNode(ListNode.init(4, 5, 1, 9), 4);
        ListNode result = instance.deleteNode(ListNode.init(4, 5, 1, 9), 9);

        ListNode.print(result);
    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummyNode = new ListNode(0);
        ListNode newHead = dummyNode;
        newHead.next = head;
        while (newHead != null && newHead.next != null) {
            if (newHead.next.val == val) {
                newHead.next = newHead.next.next;
            }
            newHead = newHead.next;
        }

        return dummyNode.next;
    }
}
