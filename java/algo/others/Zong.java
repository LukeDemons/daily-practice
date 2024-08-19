package algo.others;

/**
 * 从前，有一条贪吃蛇，他非常喜欢吃东西。有一天，他在森林里发现了一棵苹果树，他一口气吃掉了好多苹果。随着它吃的越多，身体越长。可是当他想转身回家时，却发现自己被缠住了。
 * 此时，它的身体正好可以排成一个n*m的长方形网格，每个格中都有个没消化的苹果。苹果的编号按照下列顺序：
 * 最底层的苹果从左到右依次编号为1～m；第二层的苹果从右到左为m+1～2m；......现在贪吃蛇想知道，编号为k的苹果上下左右的苹果编号是什么（如果没有对应位置输出为0）
 *
 * @author yanchuang
 * @date 2024/08/19
 */
public class Zong {

    public static void main(String[] args) {
        int m = 5, n = 4, k = 8;

        int[] result = new Zong().around(m, n, k);

        System.out.println();
        for (int res : result) {
            System.out.print(res + ". ");
        }
    }

    /**
     * 获取周围属性
     */
    public int[] around(int m, int n, int k) {
        int[][] matrix = new int[n][m];
        int s = 1;

        // left:true right:false 从下往上，先左后右
        boolean leftOrRight = true;
        for (int i = n - 1; i >= 0; i--) {
            if (leftOrRight) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = s++;
                }
            } else {
                for (int j = m - 1; j >= 0; j--) {
                    matrix[i][j] = s++;
                }
            }
            // 调头
            leftOrRight = !leftOrRight;
        }

        print(matrix);

        int[] result = new int[4];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == k) {
                    System.out.println("==> i:" + i + ", j:" + j);
                    // 上
                    if (i == 0) {
                        result[0] = 0;
                    } else {
                        result[0] = matrix[i - 1][j];
                    }

                    // 下
                    if (i == n - 1) {
                        result[1] = 0;
                    } else {
                        result[1] = matrix[i + 1][j];
                    }

                    // 左
                    if (j == 0) {
                        result[2] = 0;
                    } else {
                        result[2] = matrix[i][j - 1];
                    }

                    // 右
                    if (j == m - 1) {
                        result[3] = 0;
                    } else {
                        result[3] = matrix[i][j + 1];
                    }
                }
            }
        }

        return result;
    }

    private void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println();
        }
    }
}
