package algo.union_find;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/path-with-minimum-effort/
 * <p>
 * 2021-01-29 每日一题
 * 看起来不是动归，贪心就可以了；其实既可以动归，又可以并查集，甚至是狄杰斯特拉；现在并查集的解法还是没想出来，但是一看就能懂了，，
 */
public class UnionFindLC1631 {

    public static void main(String[] args) {
        UnionFindLC1631 instance = new UnionFindLC1631();

        int result = instance.minimumEffortPath(new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}});

        System.out.println(result);
    }

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        // edge 0->左端点 1->右端点 2->权重
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int id = i * n + j;
                if (i > 0) {
                    edges.add(new int[]{id - n, id, Math.abs(heights[i][j] - heights[i - 1][j])});
                }
                if (j > 0) {
                    edges.add(new int[]{id - 1, id, Math.abs(heights[i][j] - heights[i][j - 1])});
                }
            }
        }
        edges.sort(Comparator.comparingInt(edge -> edge[2]));

        int[] parent = new int[m * n];
        for (int i = 0; i < m * n; i++) {
            parent[i] = i;
        }
        int result = 0;
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1], weight = edge[2];
            // 按权重排序后，一条一条的连接
            union(parent, x, y);
            if (find(parent, 0) == find(parent, m * n - 1)) {
                // 当第一个点和最后点连通时，返回目前最大权重值
                result = weight;
                break;
            }
        }
        return result;
    }

    public void union(int[] parent, int i, int j) {
        int x = find(parent, i);
        int y = find(parent, j);

        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }

    public int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }

        return parent[i];
    }

}
