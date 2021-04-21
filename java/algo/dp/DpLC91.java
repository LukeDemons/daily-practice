package algo.dp;

/**
 * https://leetcode-cn.com/problems/decode-ways/
 * <p>
 * 2021-04-21 每日一题
 * 动归和回溯的思路能想到但是写不出来，这道题的核心是分类讨论得到递推函数，技巧是加哨兵
 */
public class DpLC91 {

    public static void main(String[] args) {
        DpLC91 instance = new DpLC91();

        int result = instance.numDecodings("12");

        System.out.println(result);
    }

    /**
     * 哨兵值得拥有
     */
    public int numDecodings(String s) {
        s = " " + s;
        char[] cs = s.toCharArray();
        // 前 i 个字符的解码方案数
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            // a : 代表「当前位置」单独形成 item
            // b : 代表「当前位置」与「前一位置」共同形成 item
            int a = cs[i] - '0', b = (cs[i - 1] - '0') * 10 + (cs[i] - '0');
            if (1 <= a && a <= 9) {
                // 如果 a 属于有效值，那么 f[i] 可以由 f[i - 1] 转移过来
                dp[i] += dp[i - 1];
            }
            if (10 <= b && b <= 26) {
                // 如果 b 属于有效值，那么 f[i] 可以由 f[i - 2] 或者 f[i - 1] & f[i - 2] 转移过来
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length() - 1];
    }
}
