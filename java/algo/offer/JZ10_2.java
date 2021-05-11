package algo.offer;

/**
 * https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 * <p>
 * 2021-05-11 搭一个简单动归
 */
public class JZ10_2 {

    public static void main(String[] args) {
        JZ10_2 instance = new JZ10_2();

        int result = instance.numWays(5);

        System.out.println(result);
    }

    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }
}
