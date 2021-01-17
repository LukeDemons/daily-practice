package algo.union_find;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/most-stones-removed-with-same-row-or-column/
 */
public class UnionFindLC947 {

    public static void main(String[] args) {
        UnionFindLC947 instance = new UnionFindLC947();

        int result = instance.removeStones(new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}});

        System.out.println(result);
    }

    public int removeStones(int[][] stones) {
        int length = stones.length;
        Map<Integer, Integer> parent = new HashMap<>(length * 2);

        for (int[] site : stones) {
            union(parent, site[0] + 10001, site[1]);
        }

        return length - count;
    }

    // 连通分量的个数
    int count = 0;

    public void union(Map<Integer, Integer> parent, int i, int j) {
        int x = find(parent, i);
        int y = find(parent, j);

        if (x == y) {
            System.out.println("x == y");
        } else if (x > y) {
            parent.put(y, x);
            count--;
        } else {
            parent.put(x, y);
            count--;
        }
    }

    public int find(Map<Integer, Integer> parent, int i) {
        if (!parent.containsKey(i)) {
            parent.put(i, i);
            count++;
        }

        if (parent.get(i) != i) {
            parent.put(i, find(parent, parent.get(i)));
        }

        return parent.get(i);
    }
}
