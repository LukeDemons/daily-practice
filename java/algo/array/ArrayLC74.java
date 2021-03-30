package algo.array;

/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 * <p>
 * 2021-03-30 每日一题
 * 一看就知道是两次二分，但细节太多了，，另外对BST一无所知，，，，
 */
public class ArrayLC74 {

    public static void main(String[] args) {
        ArrayLC74 instance = new ArrayLC74();

//        boolean result = instance.searchMatrix(new int[][]{{1, 2, 3}, {4, 5, 6}}, 3);
//        boolean result = instance.searchMatrix(new int[][]{{1}}, 1);
        boolean result = instance.searchMatrix(new int[][]{{1, 1}}, 0);

        System.out.println(result);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0, right = matrix.length - 1;

        // 对行进行二分查找
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] > target) {
                right = mid - 1;
            } else if (matrix[mid][0] < target) {
                // 如果当前行的最后一个值大于等于target，说明已经找到
                if (matrix[mid][matrix[0].length - 1] >= target) {
                    break;
                } else {
                    left = mid + 1;
                }
            }
        }
        // 对列进行二分查找
        int targetRow = (left + right) / 2;
        left = 0;
        right = matrix[0].length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[targetRow][mid] == target) {
                return true;
            } else if (matrix[targetRow][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }
}
