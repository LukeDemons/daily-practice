package algo.dp;

/**
 * https://leetcode-cn.com/problems/range-sum-query-2d-immutable/
 * <p>
 * 2021-03-02 每日一题
 * 连续两天，前缀和升级版。比较简单，边界判断的时候踩了几次坑，不过也是在没看答案的情况下ac的
 */
public class DpLC304 {
    public static void main(String[] args) {

        NumMatrix instance = new NumMatrix(new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}});
        System.out.println(instance.sumRegion(2, 1, 4, 3));

//        NumMatrix instance = new NumMatrix(new int[][]{{}});
//        NumMatrix instance = new NumMatrix(new int[][]{{-1}});
//        NumMatrix instance = new NumMatrix(new int[][]{{1},{-7}});

//        System.out.println(instance.sumRegion(0, 0, 0, 0));

        System.out.println(instance.sumRegion(0, 0, 1, 0));
    }
}

class NumMatrix {
    // 表示从（0,0）到（i,j）的数据加和
    int[][] sums;

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        int m = matrix.length, n = matrix[0].length;
        this.sums = new int[m][n];

        int sum;
        for (int i = 0; i < m; i++) {
            sum = 0;
            for (int j = 0; j < n; j++) {
                sum += matrix[i][j];
                sums[i][j] = sum;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            // 因为col1的位置已经加过当前值，所以需要往前错一个
            sum += sums[i][col2] - (col1 == 0 ? 0 : sums[i][col1 - 1]);
        }

        return sum;
    }
}