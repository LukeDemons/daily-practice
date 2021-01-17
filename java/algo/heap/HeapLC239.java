package algo.heap;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class HeapLC239 {

    public static void main(String[] args) {
        HeapLC239 instance = new HeapLC239();

        int[] result = instance.maxSlidingWindow(new int[]{1, -1}, 1);

        System.out.println(Arrays.toString(result));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        // 保证队列都是从大到小排序，这样只需要一直取队列头即可
        Deque<Integer> deque = new LinkedList<>();

        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.removeLast();
            }
            // 添加当前值对应的数组下标
            deque.addLast(i);
            // 判断当前队列中队首的值是否有效
            if (deque.peekFirst() <= i - k) {
                deque.removeFirst();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if (i + 1 >= k) {
                result[i + 1 - k] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    // 暴力解会超时 time limit exceed
    public int[] maxSlidingWindowTLE(int[] nums, int k) {
        int l = 0, r = l + k - 1;

        int[] result = new int[nums.length - k + 1];

        while (r < nums.length) {
            int cur = Integer.MIN_VALUE;
            for (int i = l; i <= r; i++) {
                if (cur < nums[i]) {
                    cur = nums[i];
                }
            }
            result[l] = cur;
            l++;
            r = l + k - 1;
        }

        return result;
    }
}
