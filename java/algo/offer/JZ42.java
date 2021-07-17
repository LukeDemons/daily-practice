package algo.offer;

/**
 * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 * <p>
 * 2021-07-17 每日一题
 * 许久不写了，easy的动归还是能搞定，开心
 */
public class JZ42 {

    public static void main(String[] args) {
        JZ42 instance = new JZ42();

        int result = instance.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});

        System.out.println(result);
    }

    /**
     * 连续子数组最大和
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int curMax = nums[0];
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            dp[i + 1] = Math.max(nums[i], dp[i] + nums[i]);
            curMax = Math.max(curMax, dp[i + 1]);
        }
        return curMax;
    }
}
