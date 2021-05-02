package algo.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/brick-wall/
 * <p>
 * 2021-05-02 每日一题
 * 正难则反，正向找砖块不好做，尝试反向思考如何找缝隙
 */
public class ArrayLC554 {

    public static void main(String[] args) {
        ArrayLC554 instance = new ArrayLC554();

        int result = instance.leastBricks(Arrays.asList(
                Arrays.asList(1, 2, 2, 1),
                Arrays.asList(3, 1, 2),
                Arrays.asList(1, 3, 2),
                Arrays.asList(2, 4),
                Arrays.asList(3, 1, 2),
                Arrays.asList(1, 3, 1, 1)
        ));

        System.out.println(result);
    }

    /**
     * 穿过最少的砖块=高度-穿过最多的缝隙
     */
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> gapMap = new HashMap<>();
        int maxCnt = 0;
        for (List<Integer> line : wall) {
            int sum = 0;
            for (int i = 0; i < line.size() - 1; i++) {
                sum += line.get(i);
                gapMap.put(sum, gapMap.getOrDefault(sum, 0) + 1);
                if (gapMap.get(sum) > maxCnt) {
                    maxCnt = gapMap.get(sum);
                }
            }
        }
        System.out.println(gapMap);

        return wall.size() - maxCnt;
    }
}
