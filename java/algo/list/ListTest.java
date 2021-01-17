package algo.list;

import algo.ListNode;

/**
 * @author yanchuang
 * @date 2020/6/28
 */
public class ListTest {

    public static void main(String[] args) {
        ListNode h1 = new ListNode(1);
        h1.next = new ListNode(2);

        ListNode h2 = new ListNode(3);
        h2.next = new ListNode(4);

//        ListNode n = reverse(h1);

        ListNode n = addTwoNumbers(h1, h2);

        print(n);
    }

    public static ListNode reverse(ListNode head) {
        if (head == null) return null;

        ListNode pre = head;
        ListNode cur = head.next;

        ListNode tmp;

        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;

            pre = cur;
            cur = tmp;
        }
        head.next = null;

        return pre;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode head = dummy;

        int addOne = 0;

        while (l1 != null || l2 != null || addOne != 0) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + addOne;
            addOne = sum / 10;

            head.next = new ListNode(sum % 10);
            head = head.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return dummy.next;
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode n1 = head;
        ListNode n2 = head;
        while (n2 != null) {
            n1 = n1.next;
            n2 = n2.next.next;
            if (n1 == n2) {
                return true;
            }
        }

        return false;
    }

    public static void print(ListNode n) {
        StringBuilder sb = new StringBuilder();
        while (n != null) {
            sb.append(n.val);
            n = n.next;
        }
        System.out.println(sb.toString());
    }
}
