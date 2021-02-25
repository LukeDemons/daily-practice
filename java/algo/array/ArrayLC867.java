package algo.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/transpose-matrix/
 * <p>
 * 2021-02-25 每日一题
 * 这题在维护下标的时候和566题思路是不同的，一个关心定位下标，一个关心横纵坐标交换
 */
public class ArrayLC867 {

    public static void main(String[] args) {
        ArrayLC867 instance = new ArrayLC867();

        int[][] result = instance.transpose(new int[][]{{1, 2, 3}, {4, 5, 6}});

        System.out.println(Arrays.deepToString(result));
    }

    public int[][] transpose(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] result = new int[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[j][i] = matrix[i][j];
            }
        }

//        for (int x = 0; x < m * n; x++) {
//            result[x % n][x / n] = matrix[x / n][x % n];
//        }

        return result;
    }
}
