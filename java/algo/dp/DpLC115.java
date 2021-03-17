package algo.dp;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/distinct-subsequences/
 * <p>
 * 2021-03-17 每日一题
 * 动归还不懂，再cv一次吧，dp定义和递推公式不好理解
 */
public class DpLC115 {

    public static void main(String[] args) {
        DpLC115 instance = new DpLC115();

        int result = instance.numDistinct("rabbbit", "rabbit");

        System.out.println(result);
    }

    // 计算在 s 的子序列中 t 出现的个数
    public int numDistinct(String s, String t) {
        // dp[i][j] 代表 T 前 i 字符串可以由 S j 字符串组成最多个数
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    // 当 S[j] == T[i] , dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    // 当 S[j] != T[i] , dp[i][j] = dp[i][j-1]
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }
}
