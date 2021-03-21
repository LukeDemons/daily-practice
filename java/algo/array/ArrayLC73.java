package algo.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/set-matrix-zeroes/
 * <p>
 * 2021-03-21 每日一题
 * 只能想到 两次遍历 多m+n空间的解法
 */
public class ArrayLC73 {

    public static void main(String[] args) {
        ArrayLC73 instance = new ArrayLC73();

        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};

        instance.setZeroes(matrix);

        System.out.println(Arrays.deepToString(matrix));
    }

    // 只能想到 空间复杂度O(m+n)的标记
    // O(1)空间复杂度的标记方法可读性不好，大概意思就是用flag标记本行or列是否有0
    public void setZeroes(int[][] matrix) {
        Set<Integer> is = new HashSet<>();
        Set<Integer> js = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    is.add(i);
                    js.add(j);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (is.contains(i) || js.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
