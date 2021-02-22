package algo.array;

/**
 * https://leetcode-cn.com/problems/toeplitz-matrix/
 * <p>
 * 2021-02-22 每日一题
 * 重拳出击。。。。
 */
public class ArrayLC766 {

    public static void main(String[] args) {
        ArrayLC766 instance = new ArrayLC766();

//        boolean result = instance.isToeplitzMatrix(new int[][]{{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}});
        boolean result = instance.isToeplitzMatrix(new int[][]{{1, 2}, {2, 2}});

        System.out.println(result);
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }

        return true;
    }
}
