package algo.dp;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * <p>
 * 是354题的前置题目，经典动归，最长递增子序列。目前只看了基本解法，后面有机会还要看一下二分查找的思路
 */
public class DpLC300 {

    public static void main(String[] args) {
        DpLC300 instance = new DpLC300();

        // 2，3，7，101 返回4
        int result = instance.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});

        System.out.println(result);
    }

    public int lengthOfLIS(int[] nums) {
        // dp[i]表示以nums[i]为结尾的最长递增子序列长度
        int[] dp = new int[nums.length];
        // base case：dp 数组全都初始化为 1
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    // 遍历所有比i小的值，找到最大的dp[i]
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
