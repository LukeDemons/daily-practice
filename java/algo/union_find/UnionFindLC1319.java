package algo.union_find;

/**
 * https://leetcode-cn.com/problems/number-of-operations-to-make-network-connected/
 *
 * 这题的对并查集的使用比较直接，思考一下返回值和连通分量的关系就可以了
 */
public class UnionFindLC1319 {

    public static void main(String[] args) {
        UnionFindLC1319 instance = new UnionFindLC1319();

        int result = instance.makeConnected(4, new int[][]{{0, 1}, {0, 2}, {1, 2}});

        System.out.println(result);
    }

    public int makeConnected(int n, int[][] connections) {
        int len = connections.length;
        // 如果连通线的个数小于计算机的个数减一，那么一定不够连，反之一定能连通
        if (len < n - 1) {
            return -1;
        }
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int num = n;
        for (int[] conn : connections) {
            if (union(parent, conn[0], conn[1])) {
                // 连上两个点，连通分量减一
                num--;
            }
        }

        // 把这些连接都连上之后，返回目前的连通分量减一就是还需要动多少个边，反正一定能连通
        return num - 1;
    }

    public boolean union(int[] parent, int i, int j) {
        int x = find(parent, i);
        int y = find(parent, j);

        if (x == y) {
            return false;
        } else if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
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
