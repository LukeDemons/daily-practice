package algo.dp;

/**
 * @author yanchuang
 * @date 2020/3/23
 */
public class ZeroOne {

    /**
     * N = 3, W = 4
     * wt = [2, 1, 3] 重量
     * val = [4, 2, 3] 价值
     * <p>
     * 背包 可载重量W=4和物品个数N=3，应返回6
     * 这个题目中的物品不可以分割，要么装进包里，要么不装，不能说切成两块装一半。
     */
    public static void main(String[] args) {

        int[][] dp = new int[4][5]; // 基础数据类型省略了初始化
        int value = knapsack(3, 4, dp);
        System.out.println(value);
    }

    private static int knapsack(int N, int W, int[][] dp) {
        //第一步要明确两点，「状态」和「选择」。
        // for 状态1 in 状态1的所有取值：
        //    for 状态2 in 状态2的所有取值：
        //        for ...
        //            dp[状态1][状态2][...] = 择优(选择1，选择2...)

        //第二步要明确dp数组的定义。状态有两个，背包容量和物品数量
        // dp[i][w]表示：对于前i个物品，当前背包的容量为w时，这种情况下可以装下的最大价值是dp[i][w]。
        //int dp[N+1][W+1]
        //dp[0][..] = 0
        //dp[..][0] = 0
        //
        //for i in [1..N]:
        //    for w in [1..W]:
        //        dp[i][w] = max(
        //            不把物品 i 装进背包,
        //            把物品 i 装进背包
        //        )
        //return dp[N][W]

        //第三步，根据「选择」，思考状态转移的逻辑。
        //for i in [1..N]:
        //    for w in [1..W]:
        //        dp[i][w] = max(
        //            dp[i-1][w],
        // 剩余重量w-wt[i-1]限制下能装的最大价值，加上第i个物品的价值val[i-1]，这就是装第i个物品的前提下，背包可以装的最大价值。
        //            dp[i-1][w - wt[i-1]] + val[i-1]
        //        )
        //return dp[N][W]

        int[] wt = new int[]{2, 1, 3};
        int[] val = new int[]{4, 2, 3};
        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= W; w++) {
                if (w < wt[i - 1]) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - wt[i - 1]] + val[i - 1]);
                }
            }
        }

        return dp[N][W];
    }

    /**
     * 0-1背包的恰好装满的问题
     * 选择若干物品,使得物品价值和  恰好等于sum(array)/2
     * 背包容量: sum(array)/2
     * 重量花费cost: array[i]
     * 物品价值: 0         本题: 也可以将"价值"设定为array[i]
     *
     * 恰好装满: dp[0]=0, dp[1,...V]=INT_MIN
     */
//    public static boolean canPartition(int[] nums) {
//        //1、状态定义；
//        //
//        //2、状态转移方程；
//        //
//        //3、初始化；
//        //
//        //4、输出；
//        //
//        //5、思考状态压缩。
//        //
//        //这 5 个部分是本题解的结构。其它类似的动态规划问题也可以按照这样的方向去思考、解释和理解。
//
//    }
}
