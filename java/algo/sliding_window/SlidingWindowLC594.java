package algo.sliding_window;

import java.util.Arrays;

/**
 * 2021-11-20 每日一题
 * 不要被表象迷惑，走滑窗模版就ok
 * <p>
 * https://leetcode-cn.com/problems/longest-harmonious-subsequence/
 */
public class SlidingWindowLC594 {

    public static void main(String[] args) {
        SlidingWindowLC594 instance = new SlidingWindowLC594();

//        int result = instance.findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7});
        int result = instance.findLHS(new int[]{1, 1, 1, 2});

        System.out.println(result);
    }

    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = 0;

        int result = 0;

        // right 从0滑到头
        while (right < nums.length) {
            while (nums[right] - nums[left] > 1) {
                left++;
            }
            if (nums[right] - nums[left] == 1) {
                result = Math.max(result, right - left + 1);
            }
            right++;
        }

        return result;
    }
}
