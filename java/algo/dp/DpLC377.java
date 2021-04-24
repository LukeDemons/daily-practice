package algo.dp;

/**
 * https://leetcode-cn.com/problems/combination-sum-iv/
 * <p>
 * 2021-04-24 每日一题
 * 动归月做实了，好难理解递推公式，前置题目39、40、216
 */
public class DpLC377 {

    public static void main(String[] args) {
        DpLC377 instance = new DpLC377();

        int result = instance.combinationSum4(new int[]{3}, 4);

        System.out.println(result);
    }

    /**
     * target（背包）放在外循环，将nums（物品）放在内循环，内循环从前到后遍历。
     */
    public int combinationSum4(int[] nums, int target) {
        // 定义为前i个数字组成加和的组合的个数
        int[] dp = new int[target + 1];
        // dp[i]=dp[target−num](每一个num),target⩾num
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                // 递推定义为，和为i的组合的个数，等于，每一个 和为i-num 组合的个数
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }

        return dp[target];
    }
}
