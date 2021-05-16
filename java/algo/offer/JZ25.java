package algo.offer;

import algo.ListNode;

/**
 * https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 * <p>
 * 2021-05-16 再来个easy
 */
public class JZ25 {

    public static void main(String[] args) {
        JZ25 instance = new JZ25();

//        ListNode result = instance.mergeTwoLists(ListNode.init(1, 2, 4), ListNode.init(1, 3, 4));
        ListNode result = instance.mergeTwoLists(ListNode.init(-9,3), ListNode.init(5,7));

        ListNode.print(result);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode head = dummyNode;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                head.next = l2;
                l2 = l2.next;
                head = head.next;
                continue;
            } else if (l2 == null) {
                head.next = l1;
                l1 = l1.next;
                head = head.next;
                continue;
            }

            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }

        return dummyNode.next;
    }
}
