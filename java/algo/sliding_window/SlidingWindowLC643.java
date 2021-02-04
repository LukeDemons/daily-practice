package algo.sliding_window;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/maximum-average-subarray-i/
 * <p>
 * 2021-02-04 每日一题
 * right=left+size-1 但是copyOfRange方法是右开的，to=left+size
 */
public class SlidingWindowLC643 {

    public static void main(String[] args) {
        SlidingWindowLC643 instance = new SlidingWindowLC643();

        double result = instance.findMaxAverage2(new int[]{0, 4, 0, 3, 2}, 1);
//        double result = instance.findMaxAverage2(new int[]{1, 12, -5, -6, 50, 3}, 4);
//        double result = instance.findMaxAverage2(new int[]{-1}, 1);

        System.out.println(result);
    }

    public double findMaxAverage2(int[] nums, int k) {
        int left = 0;
        double sum = 0d;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double result = sum / k;

        // 这个判断条件要注意，第一个窗口已经计算的不减一，尚未计算的减一
        // 计算完第一个区间 左指针没有加一的原因是，我还想拿到上一个区间的最左值
        while (left + k < nums.length) {
            sum = sum - nums[left] + nums[left + k];
            nums[left] = nums[left + k];
            result = Math.max(result, sum / k);
            left++;
        }

        return result;
    }

    /**
     * 原来easy题暴力解法也超时，时间肯定是费在复制和计算上了
     */
    public double findMaxAverage(int[] nums, int k) {
        double result = -Double.MAX_VALUE;
        int left = 0;
        while (left + k - 1 < nums.length) {
            result = Math.max(result, getAverage(Arrays.copyOfRange(nums, left, left + k)));
            left++;
        }

        return result;
    }

    public double getAverage(int[] nums) {
        if (Arrays.stream(nums).average().isPresent()) {
            return Arrays.stream(nums).average().getAsDouble();
        }
        return -Double.MAX_VALUE;
    }
}
