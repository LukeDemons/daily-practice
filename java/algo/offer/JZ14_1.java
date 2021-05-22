package algo.offer;

/**
 * https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 * <p>
 * 2021-05-22 状态转移方程有点不好想
 */
public class JZ14_1 {

    public static void main(String[] args) {
        JZ14_1 instance = new JZ14_1();

        int result = instance.cuttingRope(8);

        System.out.println(result);
    }

    public int cuttingRope(int n) {
        // dp[i] 表示长度为i的绳子剪成m段后的最大乘积
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j < i / 2 + 1; ++j) {
                // 剪下一段j后，剩下的i-j可以剪也可以不剪。没剪就是(i-j)*j；剪了就是dp[i-j]*j；再和上一次循环的最大值dp[i]取最大值
                dp[i] = Math.max(Math.max(dp[i - j], i - j) * j, dp[i]);
            }
        }
        return dp[n];
    }
}
