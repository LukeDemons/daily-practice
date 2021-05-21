package algo.dp;

/**
 * https://leetcode-cn.com/problems/uncrossed-lines/
 *
 * @see DpLC1143
 * 2021-05-21 每日一题
 * 完全看不出是LCS的微变形
 */
public class DpLC1035 {

    public static void main(String[] args) {
        DpLC1035 instance = new DpLC1035();

        int result = instance.maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4});

        System.out.println(result);
    }

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[nums1.length][nums2.length];
    }
}
