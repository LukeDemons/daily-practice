package algo.offer;

/**
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 * <p>
 * 2021-05-04 每日一题太难了，结果还不是二分。。
 * @see algo.array.ArrayLC240 顺带水了一个240
 */
public class JZ04 {

    public static void main(String[] args) {
        JZ04 instance = new JZ04();

        boolean result = instance.findNumberIn2DArray(new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {18, 21, 23, 26, 30}
        }, 18);

        System.out.println(result);
    }

    /**
     * 不是二分过来双指针，逆时针45度，
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) {
                // 当前值大于目标值时，选择向左移动
                i--;
            } else if (matrix[i][j] < target) {
                // 当前值小于目标值时，选择向下移动
                j++;
            } else {
                return true;
            }
        }
        return false;
    }

}
