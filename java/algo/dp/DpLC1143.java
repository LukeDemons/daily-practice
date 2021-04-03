package algo.dp;

/**
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 * <p>
 * 2021-04-03 每日一题
 * 一个字符串或者一个数组的递增子序列，dp[i]定义为0-i位置想要的结果；
 * 两个字符串或者两个数组的公共子序列，dp[i][j]定义为A 0-i位置与B 0-j位置匹配的结果
 */
public class DpLC1143 {

    public static void main(String[] args) {
        DpLC1143 instance = new DpLC1143();

        int result = instance.longestCommonSubsequence("abcde", "aced");

        System.out.println(result);
    }

    /**
     * 当两个位置的值相等(c1[i]==c2[j])时，dp[i][j]=dp[i-1][j-1]+1
     * 当两个位置的值不等(c1[i]!=c2[j])时，dp[i][j]=max{dp[i-1][j],dp[i][j-1]}
     */
    public int longestCommonSubsequence(String text1, String text2) {
        char[] c1 = text1.toCharArray();
        char[] c2 = text2.toCharArray();
        // 默认初始化值为全零，符合题意
        int[][] dp = new int[c1.length + 1][c2.length + 1];
        for (int i = 1; i <= c1.length; i++) {
            for (int j = 1; j <= c2.length; j++) {
                // 这里注意下标范围，需要做减一处理
                if (c1[i - 1] == c2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[c1.length][c2.length];
    }

}
