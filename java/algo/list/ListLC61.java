package algo.list;

import algo.ListNode;

/**
 * https://leetcode-cn.com/problems/rotate-list/
 * <p>
 * 2021-03-27 每日一题
 * 没想起来JZ22我之前竟然做过，需要肯画图，舍得用变量，然后对边界情况考虑周全
 */
public class ListLC61 {

    public static void main(String[] args) {
        ListLC61 instance = new ListLC61();

//        ListNode result = instance.rotateRight(ListNode.init(1, 2, 3, 4, 5), 2);
//        ListNode result = instance.rotateRight(ListNode.init(0, 1, 2), 4);
//        ListNode result = instance.rotateRight(ListNode.init(), 0);
        ListNode result = instance.rotateRight(ListNode.init(1, 2), 2);

        ListNode.print(result);
    }

    public ListNode rotateRight(ListNode head, int k) {
        ListNode p1 = head;
        int cnt = 0;
        while (p1 != null) {
            cnt++;
            p1 = p1.next;
        }
        // 如果是空链表 或者 旋转长度是链表长度的整数倍
        if (cnt == 0 || k % cnt == 0) {
            return head;
        }
        k %= cnt;

        ListNode p2 = head;
        ListNode p3 = head;

        for (int i = 0; i < cnt - k - 1; i++) {
            p2 = p2.next;
            p3 = p3.next;
        }
        // 此时p2是倒数k+1个节点，需要从这儿断开，后面重拼接
        ListNode h = p2.next;
        ListNode tail = p2;

        for (int i = 0; i < k; i++) {
            p3 = p3.next;
        }
        p3.next = head;
        tail.next = null;
        return h;
    }
}
