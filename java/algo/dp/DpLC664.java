package algo.dp;

/**
 * https://leetcode-cn.com/problems/strange-printer/
 * <p>
 * 2021-05-24 每日一题
 * 习得词汇，区间DP，其他的都是看了解法才了解
 */
public class DpLC664 {

    public static void main(String[] args) {
        DpLC664 instance = new DpLC664();

        int result = instance.strangePrinter("aaabbbaa");

        System.out.println(result);
    }

    public int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        // 要从后往前，保证之前的i~j都计算过
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    // 首尾字符相同时，右指针左移一位
                    dp[i][j] = dp[i][j - 1];
                } else {
                    // 首尾字符不同时，区间动归，计算i~k + k+1~j的值
                    int minCnt = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        minCnt = Math.min(minCnt, dp[i][k] + dp[k + 1][j]);
                    }
                    dp[i][j] = minCnt;
                }
            }
        }
        return dp[0][n - 1];
    }
}
