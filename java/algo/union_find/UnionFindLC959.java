package algo.union_find;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/regions-cut-by-slashes/
 * <p>
 * 2021-01-25 每日一题
 * 一看就知道并查集，还是不够清楚的分析出如何实现。连通相关=》并查集，然后思考需要连通的单位并标号，就能使用并查集的思路把可连通的单位连起来
 */
public class UnionFindLC959 {

    public static void main(String[] args) {
        UnionFindLC959 instance = new UnionFindLC959();

        int result = instance.regionsBySlashes(new String[]{" "});

        System.out.println(result);
    }

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        // 每个1x1的正方形可能会被一个边分割成4个小三角形，所以最小粒度是每个小三角形。最上是0，顺时针依次0、1、2、3
        int[] parent = new int[n * n * 4];
        for (int i = 0; i < n * n * 4; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 找到目前正方形的序号
                int idx = i * n + j;
                if (grid[i].charAt(j) == '/') {
                    // 撇时，把0和3连通、1和2连通
                    union(parent, idx * 4, idx * 4 + 3);
                    union(parent, idx * 4 + 1, idx * 4 + 2);
                } else if (grid[i].charAt(j) == '\\') {
                    // 捺时，把0和1连通、2和3连通
                    union(parent, idx * 4, idx * 4 + 1);
                    union(parent, idx * 4 + 2, idx * 4 + 3);
                } else {
                    // 空格时都连通
                    union(parent, idx * 4, idx * 4 + 1);
                    union(parent, idx * 4 + 1, idx * 4 + 2);
                    union(parent, idx * 4 + 2, idx * 4 + 3);
                }

                if (j < n - 1) {
                    int right = idx + 1;
                    // 除最右一个正方形外，把右边的1号三角形和下一个正方形的3号三角形连通
                    union(parent, idx * 4 + 1, right * 4 + 3);
                }

                if (i < n - 1) {
                    int bottom = idx + n;
                    // 除最下一个正方形外，把下面的2号三角形和n个后的下方正方形的0号三角形连通
                    union(parent, idx * 4 + 2, bottom * 4);
                }
            }
        }

        // 对所有连通分量的父节点去重，最终连通分量的数量即为「划分区域的个数」
        Set<Integer> parentSet = new HashSet<>();
        for (int i = 0; i < n * n * 4; i++) {
            int fa = find(parent, i);
            parentSet.add(fa);
        }
        return parentSet.size();
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
