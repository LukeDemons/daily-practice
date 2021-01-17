package algo.dp;

/**
 * 输入一个二维数组grid，其中的元素都是非负整数，现在你站在左上角，只能向右或者向下移动，需要到达右下角。现在请你计算，经过的路径和最小是多少？
 *
 *
 * 递归 + 备忘录
 */
public class Init {

    public static void main(String[] args) {

    }

    public int minPathSum(int[][] grid) {
        return dp(grid, grid.length - 1, grid[0].length - 1);
    }

    private int dp(int[][] grid, int i, int j) {
        // base case
        if (i == 0 && j == 0) {
            return grid[0][0];
        }
        // 如果索引出界，返回一个很大的值，
        // 保证在取 min 的时候不会被取到
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }
        // 左边和上面的最小路径和加上 grid[i][j]
        // 就是到达 (i, j) 的最小路径和
        return Math.min(dp(grid, i - 1, j), dp(grid, i, j - 1)) + grid[i][j];
    }

    public int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        /**** base case ****/
        dp[0][0] = grid[0][0];

        for (int i = 1; i < m; i++)
            dp[i][0] = dp[i - 1][0] + grid[i][0];

        for (int j = 1; j < n; j++)
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        /*******************/

        // 状态转移
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }
}
