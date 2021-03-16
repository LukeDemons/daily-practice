package algo.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/spiral-matrix-ii/
 * <p>
 * 2021-03-16 每日一题
 * 一高兴，把螺旋矩阵2也给刷了一下，和54题思路一样。昨天压中了今天的每日一题～
 */
public class ArrayLC59 {

    public static void main(String[] args) {
        ArrayLC59 instance = new ArrayLC59();

        int[][] result = instance.generateMatrix(1);

        System.out.println(Arrays.deepToString(result));
    }

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int num = 1;

        int u = 0, d = n - 1, l = 0, r = n - 1;

        while (true) {
            for (int i = l; i <= r; i++) {
                result[u][i] = num++;
            }
            if (u++ == d) {
                break;
            }
            for (int i = u; i <= d; i++) {
                result[i][r] = num++;
            }
            if (r-- == l) {
                break;
            }
            for (int i = r; i >= l; i--) {
                result[d][i] = num++;
            }
            if (d-- == u) {
                break;
            }
            for (int i = d; i >= u; i--) {
                result[i][l] = num++;
            }
            if (l++ == r) {
                break;
            }
        }

        return result;
    }
}
