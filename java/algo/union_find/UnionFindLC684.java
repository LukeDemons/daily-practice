package algo.union_find;

/**
 * https://leetcode-cn.com/problems/redundant-connection/
 *
 * 在一棵树中，边的数量比节点的数量少 1。如果一棵树有 N 个节点，则这棵树有 N−1 条边。这道题中的图在树的基础上多了一条附加的边，因此边的数量也是 N。
 *
 * 树是一个连通且无环的无向图，在树中多了一条附加的边之后就会出现环，因此附加的边即为导致环出现的边。
 *
 * 可以通过并查集寻找附加的边。初始时，每个节点都属于不同的连通分量。遍历每一条边，判断这条边连接的两个顶点是否属于相同的连通分量。
 *
 * 如果两个顶点属于不同的连通分量，则说明在遍历到当前的边之前，这两个顶点之间不连通，因此当前的边不会导致环出现，合并这两个顶点的连通分量。
 *
 * 如果两个顶点属于相同的连通分量，则说明在遍历到当前的边之前，这两个顶点之间已经连通，因此当前的边导致环出现，为附加的边，将当前的边作为答案返回
 */
public class UnionFindLC684 {

    public static void main(String[] args) {
    }

    public int[] findRedundantConnection(int[][] edges) {
        int sideLength = edges.length;
        int[] parent = new int[sideLength + 1];
        for (int i = 0; i < sideLength; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            // 如果两个点属于相同连通分量，就说明之前已经连通了，现在再连就是环，所以需要返回
            if (find(parent, x) == find(parent, y)) {
                return edge;
            }
            // 如果两个点属于不同连通分量就合并
            union(parent, x, y);
        }

        return new int[0];
    }

    public void union(int[] parent, int i, int j) {
        int x = find(parent, i);
        int y = find(parent, j);

        if (x >= y) {
            parent[x] = y;
        } else {
            parent[y] = x;
        }
    }

    public int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }

        return parent[i];
    }
}
