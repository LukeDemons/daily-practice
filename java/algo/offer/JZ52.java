package algo.offer;

import algo.ListNode;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 *
 * @see algo.list.ListLC160
 * 2021-07-21 每日一题
 */
public class JZ52 {

    public static void main(String[] args) {
        JZ52 instance = new JZ52();

        ListNode result = instance.getIntersectionNode(ListNode.init(4, 1, 8, 4, 5), ListNode.init(5, 0, 1, 8, 4, 5));

        ListNode.print(result);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode nodeA = headA, nodeB = headB;
        // preA+C preB+C，A走了preA+C再走preB，B走了preB+C再走preB，整体走过preA+preB+C，就还剩C了
        while (nodeA != nodeB) {
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }
        return nodeA;
    }
}
