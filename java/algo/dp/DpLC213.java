package algo.dp;

/**
 * https://leetcode-cn.com/problems/house-robber-ii/
 * <p>
 * 2021-04-15 每日一题
 * 这题还是有点复杂度的，两遍动归没问题，主要是要考虑到起止下标。降空间复杂度的就先不学习了
 */
public class DpLC213 {

    public static void main(String[] args) {
        DpLC213 instance = new DpLC213();

        int result = instance.rob(new int[]{2, 3, 2});
//        int result = instance.rob(new int[]{1,2,3,1});

        System.out.println(result);
    }

    /**
     * 这题的难点在于头尾相连，最简单的思路就是判断第一个点是否选中
     */
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // 分两种情况讨论，抢第一间，或者不抢第一间
        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }

    /**
     * @see DpLC198#rob
     */
    private int rob(int[] nums, int start, int end) {
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i < end; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[end - 1];
    }

}
