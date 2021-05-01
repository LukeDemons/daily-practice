package algo.offer;

import algo.ListNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * <p>
 * 2020-05-01 easy搭配easy，有种虐菜的爽感
 */
public class JZ06 {

    public static void main(String[] args) {
        JZ06 instance = new JZ06();

        int[] result = instance.reversePrint(ListNode.init(1, 3, 2));

        System.out.println(Arrays.toString(result));
    }

    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[list.size() - i - 1] = list.get(i);
        }
        return result;
    }
}
