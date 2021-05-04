package algo.array;

/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 * <p>
 * 和JZ04一样，是双指针但不是二分
 */
public class ArrayLC240 {

    public static void main(String[] args) {
        ArrayLC240 instance = new ArrayLC240();

        boolean result = instance.searchMatrix(new int[][]{{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {18, 21, 23, 26, 30}
        }, 18);

        System.out.println(result);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }
}
