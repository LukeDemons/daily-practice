package algo.dp;

/**
 * https://leetcode.cn/problems/closest-dessert-cost/
 * <p>
 * 2022-12-04 每日一题
 * 写了很久 逐渐找寻回忆
 */
public class DpLC1774 {

    public static void main(String[] args) {
        DpLC1774 instance = new DpLC1774();

//        int result = instance.closestCost(new int[]{1, 2}, new int[]{3, 4}, 10);
//        int result = instance.closestCost(new int[]{2, 3}, new int[]{4, 5, 100}, 18);
        // 超过target也是可以的
        int result = instance.closestCost(new int[]{10}, new int[]{1}, 1);

        System.out.println(result);
    }

    int result = Integer.MAX_VALUE;

    /**
     * base必选一个，topping可选0 1 2，要找到最接近target的值，一样接近时要最便宜的
     */
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        for (int base : baseCosts) {
            dfs(0, base, target, toppingCosts);
        }

        return result;
    }

    public void dfs(int x, int sum, int target, int[] toppingCosts) {
        int a = Math.abs(target - sum), b = Math.abs(target - result);
        // 选最接近的
        if (a < b) {
            result = sum;
        }
        // 一样接近选便宜的
        if (a == b && sum < result) {
            result = sum;
        }
        if (sum > target) {
            return;
        }
        for (int i = x; i < toppingCosts.length; i++) {
            // 加一份
            dfs(i + 1, sum + toppingCosts[i], target, toppingCosts);
            // 加两份
            dfs(i + 1, sum + 2 * toppingCosts[i], target, toppingCosts);
        }
    }
}
