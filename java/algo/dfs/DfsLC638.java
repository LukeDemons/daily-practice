package algo.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/shopping-offers/
 * <p>
 * 2021-10-24 每日一题
 * 1024 纪念一下，虽然啃题解才搞定
 */
public class DfsLC638 {

    public static void main(String[] args) {
        DfsLC638 instance = new DfsLC638();

        int result = instance.shoppingOffers(
                Arrays.asList(2, 3, 4),
                Arrays.asList(Arrays.asList(1, 1, 0, 4), Arrays.asList(2, 2, 1, 9)),
                Arrays.asList(1, 2, 1));

        System.out.println(result);
    }

    // 记忆化搜索，存储已经计算过的信息
    private Map<List<Integer>, Integer> cacheMap = new HashMap<>();

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int n = price.size();
        // 过滤不需要计算的大礼包，只保留需要计算的大礼包
        List<List<Integer>> effectSpecial = new ArrayList<>();
        for (List<Integer> cur : special) {
            int totalCount = 0;
            int totalPrice = 0;
            for (int i = 0; i < n; i++) {
                totalCount += cur.get(i);
                totalPrice += cur.get(i) * price.get(i);
            }
            if (totalCount > 0 && totalPrice > cur.get(n)) {
                // 商品数大于0，且确实有优惠，才算有效的大礼包
                effectSpecial.add(cur);
            }
        }

        return dfs(price, effectSpecial, needs);
    }

    // 记忆化搜索计算满足购物清单所需花费的最低价格
    private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if (!cacheMap.containsKey(needs)) {
            int n = price.size();
            int minPrice = 0;
            for (int i = 0; i < n; i++) {
                minPrice += needs.get(i) * price.get(i); // 不购买任何大礼包，原价购买购物清单中的所有物品
            }

            for (List<Integer> cur : special) {
                List<Integer> nextNeeds = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    int leftI = needs.get(i) - cur.get(i);
                    if (leftI < 0) { // 不能购买超出购物清单指定数量的物品
                        break;
                    }
                    nextNeeds.add(leftI);
                }
                if (nextNeeds.size() == n) { // 大礼包可以购买
                    minPrice = Math.min(minPrice, dfs(price, special, nextNeeds) + cur.get(n));
                }
            }
            cacheMap.put(needs, minPrice);
        }
        return cacheMap.get(needs);
    }

}
