package algo.list;

import algo.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 *
 * 2021-06-04 每日一题
 * 相交链表，就是缓存一个，判断下一个在什么时候重合上
 */
public class ListLC160 {

    public static void main(String[] args) {
        ListLC160 instance = new ListLC160();

        ListNode result = instance.getIntersectionNode(ListNode.init(4, 1, 8, 4, 5), ListNode.init(5, 0, 1, 8, 4, 5));

        ListNode.print(result);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> cacheA = new HashSet<>();
        ListNode dummy = headA;
        while (dummy != null) {
            cacheA.add(dummy);
            dummy = dummy.next;
        }
        dummy = headB;
        while (dummy != null) {
            if (cacheA.contains(dummy)) {
                return dummy;
            }
            dummy = dummy.next;
        }
        return null;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
