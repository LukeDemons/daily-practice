package algo.dp;

/**
 * https://leetcode-cn.com/problems/house-robber/
 * <p>
 * 2021-04-15 每日一题的前置题目，感觉是最简单的动态规划
 */
public class DpLC198 {

    public static void main(String[] args) {
        DpLC198 instance = new DpLC198();

        int result = instance.rob(new int[]{2, 7, 9, 3, 1});

        System.out.println(result);
    }

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // 选到第i个房屋后，最多能偷多少钱
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    /**
     * 新增临时变量，减少边界情况的判断
     */
    public int rob1(int[] nums) {
        int pre = 0, cur = 0, tmp;
        for (int num : nums) {
            tmp = cur;
            cur = Math.max(pre + num, cur);
            pre = tmp;
        }
        return cur;
    }
}
