package algo.offer;

/**
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 * <p>
 * 2021-05-22 dfs，注意回溯方式
 */
public class JZ13 {

    public static void main(String[] args) {
        JZ13 instance = new JZ13();

        int result = instance.movingCount(2, 3, 1);

        System.out.println(result);
    }

    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        dfs(visited, m, n, 0, 0, k);
        return result;
    }

    int result = 0;

    private void dfs(boolean[][] visited, int m, int n, int i, int j, int k) {
        if (i < 0 || i >= m || j < 0 || j >= n || getNum(i) + getNum(j) > k || visited[i][j]) {
            return;
        }
        if (!visited[i][j]) {
            visited[i][j] = true;
            result++;
            dfs(visited, m, n, i + 1, j, k);
            dfs(visited, m, n, i - 1, j, k);
            dfs(visited, m, n, i, j + 1, k);
            dfs(visited, m, n, i, j - 1, k);
        }
    }

    private int getNum(int x) {
        int result = 0;
        while (x != 0) {
            result += x % 10;
            x /= 10;
        }
        return result;
    }
}
