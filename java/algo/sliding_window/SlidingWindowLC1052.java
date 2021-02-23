package algo.sliding_window;

/**
 * https://leetcode-cn.com/problems/grumpy-bookstore-owner/
 * <p>
 * 2021-02-23 每日一题
 * 题意理解错了。。其实只要看不生气时的量，去滑X大小窗的最大增量就可以了
 */
public class SlidingWindowLC1052 {

    public static void main(String[] args) {
        SlidingWindowLC1052 instance = new SlidingWindowLC1052();

        int result = instance.maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3);
//        int result = instance.maxSatisfied(new int[]{9, 10, 4, 5}, new int[]{1, 0, 1, 1}, 1);

        System.out.println(result);
    }

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        // 先看不生气的时候能接待多少
        int base = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                base += customers[i];
            }
        }

        // 然后滑动固定大小的窗口即可
        int left = 0, right = 0;
        int increase = 0, maxIncrease = 0;
        while (right < customers.length) {
            increase += customers[right] * grumpy[right];
            while (right - left + 1 > X) {
                increase -= customers[left] * grumpy[left];
                left++;
            }
            maxIncrease = Math.max(maxIncrease, increase);
            right++;
        }
        return base + maxIncrease;
    }

}
