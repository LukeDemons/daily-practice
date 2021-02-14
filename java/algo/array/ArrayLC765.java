package algo.array;

/**
 * https://leetcode-cn.com/problems/couples-holding-hands/
 * <p>
 * 2021-02-14 每日一题
 * 并查集大概想到了，但是一月感觉还没有掌握精髓，没有写出代码，还要再复习复习。实际应用中的「点」怎么定义，如何「连接」，「连通分量」有什么含义
 */
public class ArrayLC765 {

    public static void main(String[] args) {
        ArrayLC765 instance = new ArrayLC765();

//        int result = instance.minSwapsCouples(new int[]{0, 2, 1, 3});
        int result = instance.minSwapsCouples(new int[]{3, 2, 0, 1});

        System.out.println(result);
    }

    public int minSwapsCouples(int[] row) {
        int n = row.length;

        int coupleCnt = n / 2;
        // 一对儿情侣对应一个点
        int[] parent = new int[coupleCnt];
        for (int i = 0; i < coupleCnt; i++) {
            parent[i] = i;
        }

        // 每两个相邻的连起来
        int connectCnt = 0;
        for (int i = 0; i < n; i += 2) {
            int l = row[i] / 2;         // 第 l 对儿的男生
            int r = row[i + 1] / 2;     // 第 r 对儿的女生
            // 如果是相同的（本来就相邻）或者已经连过（前面遍历过），就不会增加连通分量，也就不需要交换位置
            if (union(parent, l, r)) {
                connectCnt++;
            }
        }

        return connectCnt;
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
