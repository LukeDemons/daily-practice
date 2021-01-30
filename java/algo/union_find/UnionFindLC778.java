package algo.union_find;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/swim-in-rising-water/
 * <p>
 * 2021-01-30 每日一题
 * 和昨天的很像，可以直接走并查集最小生成树连通的思路；如果再遇到类似的，我可以再写一下bfs的实现思路了
 */
public class UnionFindLC778 {

    public static void main(String[] args) {
        UnionFindLC778 instance = new UnionFindLC778();

        int result = instance.swimInWater(new int[][]{{0, 2}, {1, 3}});

        System.out.println(result);
    }

    public int swimInWater(int[][] grid) {
        int n = grid.length;

        int[] parent = new int[n * n];
        for (int i = 0; i < n * n; i++) {
            parent[i] = i;
        }
        // 相邻节点之间的权值为对应两个相邻小方格值的较大者
        List<int[]> edges = new ArrayList<>(n * n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 下邻接点
                if (i + 1 < n) {
                    edges.add(new int[]{i * n + j, (i + 1) * n + j, Math.max(grid[i][j], grid[i + 1][j])});
                }
                // 右邻接点
                if (j + 1 < n) {
                    edges.add(new int[]{i * n + j, i * n + j + 1, Math.max(grid[i][j], grid[i][j + 1])});
                }
            }
        }

        edges.sort(Comparator.comparingInt(e -> e[2]));

        int result = 0;
        for (int[] edge : edges) {
            union(parent, edge[0], edge[1]);

            if (find(parent, 0) == find(parent, n * n - 1)) {
                result = edge[2];
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
