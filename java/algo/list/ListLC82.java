package algo.list;

import algo.ListNode;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 * <p>
 * 2021-03-25 每日一题
 * 1. dummy减少边界判断，后面的答案链表会在dummy后面
 * 2. 使用tail代表有效链表的结尾（最后记得清空）
 * 3. 使用head进行链表扫描
 */
public class ListLC82 {

    public static void main(String[] args) {
        ListLC82 instance = new ListLC82();

        ListNode result = instance.deleteDuplicates(ListNode.init(1, 2, 3, 3, 4, 4, 5));

        ListNode.print(result);
    }

    public ListNode deleteDuplicates(ListNode head) {
        // 创建一个虚拟节点来减少边界判断
        ListNode dummy = new ListNode(0);
        // 使用tail代表当前有效链表的结尾
        ListNode tail = dummy;
        while (head != null) {
            // 进入循环时，确保了 head 不会与上一节点相同
            if (head.next == null || head.val != head.next.val) {
                tail.next = head;
                tail = tail.next;
            }
            // 如果 head 与下一节点相同，跳过相同节点
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            head = head.next;
        }
        tail.next = null;
        return dummy.next;
    }
}
