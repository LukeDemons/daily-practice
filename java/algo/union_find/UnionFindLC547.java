package algo.union_find;

/**
 * https://leetcode-cn.com/problems/number-of-provinces/
 */
public class UnionFindLC547 {

    public static void main(String[] args) {
        int[][] isConnected = new int[3][3];
        isConnected[0] = new int[]{1,1,0};
        isConnected[1] = new int[]{1,1,0};
        isConnected[2] = new int[]{0,0,1};

        UnionFindLC547 instance = new UnionFindLC547();
        int result = instance.findCircleNum(isConnected);
        System.out.println(result);
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] parent = new int[n];
        // 初始化
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        // 使用union_find
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }
        // 遍历拿结果
        int circleNum = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                circleNum++;
            }
        }
        return circleNum;
    }

    public void union(int[] parent, int i, int j) {
        int x = find(parent, i);
        int y = find(parent, j);
        parent[x] = y;
    }

    public int find(int[] parent, int i) {
        if (parent[i] == i) {
            return i;
        } else {
            parent[i] = find(parent, parent[i]);
            return parent[i];
        }
    }

}
