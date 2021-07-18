package algo.dp;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 *
 * @see algo.offer.JZ42
 */
public class DpLC53 {

    public static void main(String[] args) {

        DpLC53 instance = new DpLC53();

        int result = instance.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});

        System.out.println(result);
    }

    public int maxSubArray(int[] nums) {
        int curMax = nums[0];
        int[] dp = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            // 重开一个新的子数组，还是要继续累加之前的和。（也就是看dp[i]是否大于0）所以dp是连续数组和最大值，不是从0开始连续数组和最大值。
            dp[i + 1] = Math.max(nums[i], dp[i] + nums[i]);
            curMax = Math.max(curMax, dp[i + 1]);
        }
        return curMax;
    }
}
