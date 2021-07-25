package algo.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/restore-the-array-from-adjacent-pairs/
 * <p>
 * 2021-07-25 每日一题
 * 挺好的一道哈希表题目
 */
public class ArrayLC1743 {

    public static void main(String[] args) {
        ArrayLC1743 instance = new ArrayLC1743();

        int[] result = instance.restoreArray(new int[][]{{2, 1}, {3, 4}, {3, 2}});
//        int[] result = instance.restoreArray(new int[][]{{4, -2}, {1, 4}, {-3, 1}});

        System.out.println(Arrays.toString(result));
    }

    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, Integer> cnt = new HashMap<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pair : adjacentPairs) {
            List<Integer> p0Val = map.getOrDefault(pair[0], new ArrayList<>());
            p0Val.add(pair[1]);
            map.put(pair[0], p0Val);

            List<Integer> p1Val = map.getOrDefault(pair[1], new ArrayList<>());
            p1Val.add(pair[0]);
            map.put(pair[1], p1Val);

            cnt.put(pair[0], cnt.getOrDefault(pair[0], 0) + 1);
            cnt.put(pair[1], cnt.getOrDefault(pair[1], 0) + 1);
        }

        int[] result = new int[adjacentPairs.length + 1];
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            if (entry.getValue() == 1) {
                result[0] = entry.getKey();
                break;
            }
        }

        for (int i = 1; i < adjacentPairs.length + 1; i++) {
            List<Integer> valList = map.get(result[i - 1]);
            result[i] = valList.get(0);
            // 删除两个键值对
            Iterator<Integer> iterator = map.get(result[i]).iterator();
            while (iterator.hasNext()) {
                if (iterator.next() == result[i - 1]) {
                    iterator.remove();
                }
            }
        }

        return result;
    }
}
