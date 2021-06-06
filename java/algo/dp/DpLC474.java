package algo.dp;

/**
 * https://leetcode-cn.com/problems/ones-and-zeroes/
 *
 * 2021-06-06 每日一题
 * 子集回溯不熟练，想不出动归要三维，继续加油
 */
public class DpLC474 {

    public static void main(String[] args) {
        DpLC474 instance = new DpLC474();

        int result = instance.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5,3);

        System.out.println(result);
    }

    public int findMaxForm(String[] strs, int m, int n) {
        // dp[i][j][k] 表示输入字符串在子区间 [0, i] 能够使用 j 个 0 和 k 个 1 的字符串的最大数量
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];

        for (int i = 1; i <= strs.length; i++) {
            // 注意：有一位偏移
            int[] count = countZeroAndOne(strs[i - 1]);
            int zeros = count[0];
            int ones = count[1];
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    // 先把上一行抄下来
                    dp[i][j][k] = dp[i - 1][j][k];
                    // 如果0，1的量还够选择，就更新dp
                    if (j >= zeros && k >= ones) {
                        // 不选择这个数字 选择这个数字 两个里面取最大值
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zeros][k - ones] + 1);
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }

    private int[] countZeroAndOne(String str) {
        int[] cnt = new int[2];
        for (char c : str.toCharArray()) {
            cnt[c - '0']++;
        }
        return cnt;
    }
}
