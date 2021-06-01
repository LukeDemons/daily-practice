package algo.greedy;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/can-you-eat-your-favorite-candy-on-your-favorite-day/
 * <p>
 * 2021-06-01 每日一题
 * 祝yy小朋友节日快乐
 */
public class GreedyLC1744 {

    public static void main(String[] args) {
        GreedyLC1744 instance = new GreedyLC1744();

        boolean[] result = instance.canEat(new int[]{7, 4, 5, 3, 8}, new int[][]{{0, 2, 2}, {4, 2, 4}, {2, 13, 1000000000}});

        System.out.println(Arrays.toString(result));
    }

    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        boolean[] result = new boolean[queries.length];
        long[] preSum = new long[candiesCount.length + 1];
        // 算一个前缀和，表示第i颗糖果前面有多少糖果需要吃完
        for (int i = 1; i <= candiesCount.length; i++) {
            preSum[i] = preSum[i - 1] + candiesCount[i - 1];
        }
        for (int i = 0; i < queries.length; i++) {
            int type = queries[i][0], day = queries[i][1] + 1, cap = queries[i][2];
            // 最快吃到type类第一颗糖的时间是 前面天都按最快的速度吃；最慢吃到type类最后一颗糖的时间是 包括当天的糖果都按速度1来吃
            long fastestDay = preSum[type] / cap + 1, slowestDay = preSum[type + 1];
            // 判断每天能吃的量是否在最快～最慢的时间范围
            result[i] = fastestDay <= day && day <= slowestDay;
        }
        return result;
    }
}
