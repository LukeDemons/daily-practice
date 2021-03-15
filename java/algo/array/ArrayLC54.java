package algo.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/spiral-matrix/
 * <p>
 * 2021-03-15 每日一题
 * 螺旋遍历，记录遍历的位置，边界相交时遍历完成
 */
public class ArrayLC54 {

    public static void main(String[] args) {
        ArrayLC54 instance = new ArrayLC54();

        List<Integer> result = instance.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});

        System.out.println(result);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        int u = 0, d = matrix.length - 1, l = 0, r = matrix[0].length - 1;
        // 每层遍历完调整对应坐标值，当两个边界相交时遍历完成
        while (true) {
            for (int i = l; i <= r; i++) {
                result.add(matrix[u][i]);
            }
            if (u++ == d) {
                break;
            }
            for (int i = u; i <= d; i++) {
                result.add(matrix[i][r]);
            }
            if (r-- == l) {
                break;
            }
            for (int i = r; i >= l; i--) {
                result.add(matrix[d][i]);
            }
            if (d-- == u) {
                break;
            }
            for (int i = d; i >= u; i--) {
                result.add(matrix[i][l]);
            }
            if (l++ == r) {
                break;
            }
        }

        return result;
    }
}
