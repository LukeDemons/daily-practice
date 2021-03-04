package algo.dp;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/russian-doll-envelopes/
 * <p>
 * 2021-03-04 每日一题
 * 一看就是动态规划问题，hard题直接看题解了，学会区间排序和LIS题目就容易多了
 */
public class DpLC354 {

    public static void main(String[] args) {
        DpLC354 instance = new DpLC354();

        // (2,3)->(5,4)->(6,7) 返回3
        int result = instance.maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}});

        System.out.println(result);
    }

    public int maxEnvelopes(int[][] envelopes) {
        // 区间问题先排序，按w升序，w相同时按h降序
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        // 对高度数组寻找 LIS
        int[] height = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++)
            height[i] = envelopes[i][1];

        // 转化为一维数组的最长递增子序列问题
        return lengthOfLIS(height);
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int result = 0;
        for (int d : dp) {
            result = Math.max(result, d);
        }
        return result;
    }
}
