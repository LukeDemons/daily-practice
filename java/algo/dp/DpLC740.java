package algo.dp;

/**
 * https://leetcode-cn.com/problems/delete-and-earn/
 * <p>
 * 2021-05-05 每日一题
 * 稍微转一下的动归问题，难点是想到构造bucket中间数组
 */
public class DpLC740 {

    public static void main(String[] args) {
        DpLC740 instance = new DpLC740();

        int result = instance.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}); // [0,0,2,3,1]

        System.out.println(result);
    }

    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] bucket = new int[max + 1];
        for (int num : nums) {
            bucket[num]++;
        }

        int[] dp = new int[max + 1];
        dp[0] = 0;
        dp[1] = bucket[1];
        for (int i = 2; i <= max; i++) {
            // 不选这个 和 选这个 的最大值
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * bucket[i]);
        }

        return dp[max];
    }
}
