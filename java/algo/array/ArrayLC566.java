package algo.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/reshape-the-matrix/
 * <p>
 * 2021-02-17 每日一题
 * 有点儿easy题内味儿了，通过率很高，写了半天才磕出来，感觉还不是最优解。果然不是，要了解增维和降维的逻辑
 */
public class ArrayLC566 {

    public static void main(String[] args) {
        ArrayLC566 instance = new ArrayLC566();

        int[][] result = instance.matrixReshape(new int[][]{{1, 2}, {3, 4}}, 1, 4);

        System.out.println(Arrays.deepToString(result));
    }

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int m = nums.length, n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }
        List<Integer> totalArr = new ArrayList<>(m * n);
        for (int[] num : nums) {
            for (int j = 0; j < n; j++) {
                totalArr.add(num[j]);
            }
        }

        int cnt = 0;
        int[][] result = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = totalArr.get(cnt++);
            }
        }

        return result;
    }

    /**
     * flatten时 (i,j)==>i*m+j
     * 反向操作时  i=x/n j=x%n
     */
    public int[][] matrixReshape1(int[][] nums, int r, int c) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int m = nums.length, n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }

        int[][] result = new int[r][c];
        for (int x = 0; x < m * n; x++) {
            // 这里注意 如何定位数组下标，机器学习向量flatten常用
            result[x / c][x % c] = nums[x / n][x % n];
        }

        return result;
    }
}
