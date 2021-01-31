package algo.union_find;

/**
 * https://leetcode-cn.com/problems/similar-string-groups/
 * <p>
 * 2021-01-31 每日一题
 * 很惭愧，一个月了，今天的题一开始都没读明白
 * 把每个字符串当做一个节点，相似的字符串连起来。每个连通区域是一个相似字符串组，不连通的区域个数即为所求
 */
public class UnionFindLC839 {

    public static void main(String[] args) {
        UnionFindLC839 instance = new UnionFindLC839();

        int result = instance.numSimilarGroups(new String[]{"tars", "rats", "arts", "star"});

        System.out.println(result);
    }

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int result = n;
        for (int i = 1; i < n; i++) {
            // 先把所有的字符串遍历一下，相似的就连上
            if (check(strs[i], strs[i - 1])) {
                // 第一次连通的，连通性减一
                if (union(parent, i, i - 1)) {
                    result--;
                }
            }
        }

        return result;
    }

    private boolean check(String str1, String str2) {
        if (str1.equals(str2)) {
            return true;
        }
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                count++;
            }
        }
        return count == 2;
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
