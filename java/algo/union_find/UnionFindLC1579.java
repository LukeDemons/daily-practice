package algo.union_find;

/**
 * https://leetcode-cn.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/
 * <p>
 * 2021-01-27 每日一题
 * 一看就是并查集，但还不是最小生成树；另外，还是把连通分量揉到类属性里比较简单
 */
public class UnionFindLC1579 {

    public static void main(String[] args) {
        UnionFindLC1579 instance = new UnionFindLC1579();

        // 数组的第一个值代表类型，后两个才是节点；1->只有A 2->只有B 3->A和B
        int result = instance.maxNumEdgesToRemove(4, new int[][]{{3, 1, 2}, {3, 2, 3}, {1, 1, 3}, {1, 2, 4}, {1, 1, 2}, {2, 3, 4}});

        System.out.println(result);
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int[] parentA = new int[n + 1], parentB = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parentA[i] = i;
            parentB[i] = i;
        }

        int numA = n, numB = n, remove = 0;

        // 公共边
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                // 当无需连通时，才会将删除的个数加一
                if (!union(parentA, edge[1], edge[2])) {
                    remove++;
                } else {
                    numA--;
                    if (union(parentB, edge[1], edge[2])) {
                        numB--;
                    }
                }
            }
        }

        // 独占边
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                // A 独占边
                if (!union(parentA, edge[1], edge[2])) {
                    remove++;
                } else {
                    numA--;
                }
            } else if (edge[0] == 2) {
                // B 独占边
                if (!union(parentB, edge[1], edge[2])) {
                    remove++;
                } else {
                    numB--;
                }
            }
        }

        if (numA != 1 || numB != 1) {
            return -1;
        }

        return remove;
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
