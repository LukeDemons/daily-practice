package algo.union_find;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree/
 * <p>
 * Kruskal 算法创建最小生成树，其实就是把边按权重排序，利用并查集逐渐连接，直到连通分量等于1
 */
public class UnionFindLC1489 {

    public static void main(String[] args) {
        UnionFindLC1489 instance = new UnionFindLC1489();

        List<List<Integer>> result = instance.findCriticalAndPseudoCriticalEdges(5,
                new int[][]{{0, 1, 1}, {1, 2, 1}, {2, 3, 2}, {0, 3, 2}, {0, 4, 3}, {3, 4, 3}, {1, 4, 6}});

        System.out.println(result);
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int length = edges.length;
        int[][] newEdges = new int[length][4];
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < length; ++i) {
            // 把edge的[0,1,2]复制到newEdge，然后下标3存边的下标
            System.arraycopy(edges[i], 0, newEdges[i], 0, 3);
            newEdges[i][3] = i;
        }
        // 按边的权重排序
        Arrays.sort(newEdges, Comparator.comparingInt(u -> u[2]));

        // 计算 value
        int value = 0;
        for (int i = 0; i < length; ++i) {
            if (union(parent, newEdges[i][0], newEdges[i][1])) {
                value += newEdges[i][2];
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < 2; ++i) {
            result.add(new ArrayList<>());
        }


        for (int i = 0; i < length; i++) {
            // 判断是否是关键边
            for (int i1 = 0; i1 < n; i1++) {
                parent[i1] = i1;
            }
            int v = 0;
            int num = n;
            for (int j = 0; j < length; j++) {
                if (i != j && union(parent, newEdges[j][0], newEdges[j][1])) {
                    num--;
                    v += newEdges[j][2];
                }
            }
            // 当连通分量大于1，或者都连起来了但总权重小（去环还有环）就认为是关键边
            if (num > 1 || (num == 1 && v > value)) {
                result.get(0).add(newEdges[i][3]);
                continue;
            }

            // 判断是否是伪关键边
            for (int i2 = 0; i2 < n; i2++) {
                parent[i2] = i2;
            }
            // 可能会出现在某些最小生成树中但不会出现在所有最小生成树中的边。
            // 所以先将这条边的两端点合并，如果权重不变，则是伪关键边
            union(parent, newEdges[i][0], newEdges[i][1]);
            v = newEdges[i][2];
            for (int j = 0; j < length; ++j) {
                if (i != j && union(parent, newEdges[j][0], newEdges[j][1])) {
                    v += newEdges[j][2];
                }
            }
            if (v == value) {
                result.get(1).add(newEdges[i][3]);
            }
        }

        return result;
    }

    public boolean union(int[] parent, int i, int j) {
        int x = find(parent, i);
        int y = find(parent, j);

        if (x == y) {
            return false;
        } else if (x < y) {
            parent[x] = y;
        } else {
            parent[y] = x;
        }
        return true;
    }

    public int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }

        return parent[i];
    }
}
