package algo.union_find;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/min-cost-to-connect-all-points/
 *
 * 想清楚如何使用并查集，何时连通，在连通过程中能得到什么信息
 */
public class UnionFindLC1584 {

    public static void main(String[] args) {
        UnionFindLC1584 instance = new UnionFindLC1584();

        int result = instance.minCostConnectPoints(new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}});

        System.out.println(result);
    }

    public int minCostConnectPoints(int[][] points) {
        if (points == null || points.length <= 1) return 0;

        int length = points.length;
        int[] parent = new int[length];

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            parent[i] = i;
            for (int j = i + 1; j < length; j++) {
                // 将所有的边都创建好放入edges集合
                edges.add(new Edge(dist(points, i, j), i, j));
            }
        }
        // 按len排序，相当于小顶堆
        edges.sort(Comparator.comparingInt(e -> e.len));
        int ret = 0, num = 1;
        for (Edge edge : edges) {
            int len = edge.len, x = edge.x, y = edge.y;
            if (union(parent, x, y)) {
                ret += len;
                num++;
                // 当连通分量中的点数等于总点数时不再连接
                if (num == length) {
                    break;
                }
            }
        }
        return ret;
    }

    public int dist(int[][] points, int x, int y) {
        return Math.abs(points[x][0] - points[y][0]) + Math.abs(points[x][1] - points[y][1]);
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


    class Edge {
        int len, x, y;

        public Edge(int len, int x, int y) {
            this.len = len;
            this.x = x;
            this.y = y;
        }
    }
}

