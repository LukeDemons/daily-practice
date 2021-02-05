package algo.sliding_window;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/get-equal-substrings-within-budget/
 *
 * 2021-02-05 每日一题
 * 滑动窗口，maxCost总开销是所有字符的开销和。medium题，暴力解法，一击即中，爽=，=
 */
public class SlidingWindowLC1208 {

    public static void main(String[] args) {
        SlidingWindowLC1208 instance = new SlidingWindowLC1208();

        int result = instance.equalSubstring("abcd", "bcdf", 3);

        System.out.println(result);
    }

    public int equalSubstring(String s, String t, int maxCost) {
        int length = s.length();

        int[] costArr = new int[length];
        for (int i = 0; i < length; i++) {
            int sIndex = s.charAt(i) - 'a';
            int tIndex = t.charAt(i) - 'a';
            costArr[i] = Math.abs(sIndex - tIndex);
        }
        System.out.println(Arrays.toString(costArr));
        // 这时候就变成了 有最大和的限制的 最长子序列
        int maxLength = 0;
        for (int i = 0; i < length; i++) {
            int curMax = 0;
            for (int j = i; j < length; j++) {
                curMax += costArr[j];
                if (curMax <= maxCost) {
                    maxLength = Math.max(maxLength, j - i + 1);
                } else {
                    break;
                }
            }
        }

        return maxLength;
    }

}
