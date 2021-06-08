package algo.dp;

/**
 * https://leetcode-cn.com/problems/last-stone-weight-ii/
 * <p>
 * 2021-06-08 每日一题
 * 01背包，@see DfsLC494
 */
public class DpLC1049 {

    public static void main(String[] args) {
        DpLC1049 instance = new DpLC1049();

        int result = instance.lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1});

        System.out.println(result);
    }

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        // 背包容量为⌊sum/2⌋，物品重量和价值均为stone的0-1背包问题
        int t = sum / 2;
        int[] dp = new int[t + 1];
        for (int stone : stones) {
            for (int i = t; i >= stone; i--) {
                // 滚动数组，决定是否装进背包
                dp[i] = Math.max(dp[i], dp[i - stone] + stone);
            }
        }
        return Math.abs(sum - dp[t] - dp[t]);
    }
}
