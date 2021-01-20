package algo.union_find;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/most-stones-removed-with-same-row-or-column/
 *
 * 然而会遇到这样一个问题：石头的位置是「有序数对（二维）」，并查集的底层是「一维数组」，我们在并查集里应该如何区分横纵坐标呢？
 *
 * 例如：
 * 如果一块石头的坐标为 [3, 3] ，那么所有横坐标为 3 的石头和所有纵坐标为 3 的石头都在一个连通分量中，
 * 但是我们需要在并查集里区分「横坐标」和「纵坐标」，它们在并查集里不能相等，根据题目的提示 0 <= x_i, y_i <= 10^40<=x
 * 可以把其中一个坐标 映射 到另一个与 [0, 10000] 不重合的区间，可以的做法是把横坐标全部减去 10001 或者全部加上 10001（一定不在 [0, 10000] 里）
 *
 * 在并查集里我们需要维护连通分量的个数，新创建顶点的时候连通分量加 1；合并不在同一个连通分量中的两个并查集的时候，连通分量减 1。
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
