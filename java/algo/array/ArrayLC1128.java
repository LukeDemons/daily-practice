package algo.array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs/
 * <p>
 * 2021-01-26 每日一题
 * 虽然是连通性的问题，但是考察的不是并查集了T_T；只需理清思路，每个多米诺骨牌对儿记录一下数量就可以了
 */
public class ArrayLC1128 {

    public static void main(String[] args) {
        ArrayLC1128 instance = new ArrayLC1128();

        int result = instance.numEquivDominoPairs(new int[][]{{1, 2}, {2, 2}, {2, 1}, {1, 2}});

        System.out.println(result);
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        if (dominoes == null || dominoes.length == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>(dominoes.length);

        int cnt = 0;
        for (int[] domino : dominoes) {
            int val = Math.min(domino[0] * 10 + domino[1], domino[1] * 10 + domino[0]);

            if (map.containsKey(val)) {
                // 新来一个和之前能连通的数组，需要加上之前所有的多米诺骨牌对儿
                cnt += map.get(val);
            }
            map.put(val, map.get(val) == null ? 1 : map.get(val) + 1);
        }

        return cnt;
    }
}
