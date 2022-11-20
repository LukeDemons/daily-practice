package algo.main;

/**
 * https://leetcode.cn/problems/champagne-tower/
 * <p>
 * 2022-11-20 每日一题
 * 按题意模拟，看似复杂，看答案后挺好理解
 */
public class MainLC799 {

    public static void main(String[] args) {
        MainLC799 instance = new MainLC799();

        double result = instance.champagneTower(2, 1, 1);

        System.out.println(result);
    }

    /**
     * 按层倒酒，模拟处理香槟量
     */
    public double champagneTower(int poured, int query_row, int query_glass) {
        // 表示第i层j列的初始香槟量
        double[][] f = new double[101][101];
        f[0][0] = poured;

        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                if (f[i][j] > 1) {
                    double half = (f[i][j] - 1) / 2.0;
                    f[i][j] = 1;
                    f[i + 1][j] += half;
                    f[i + 1][j + 1] += half;
                }
            }
        }

        return Math.min(1, f[query_row][query_glass]);
        // 由于每一层的香槟量只与上一层的香槟量有关，因此可以用滚动数组的方式优化空间复杂度，将二维数组优化为一维数组
    }
}
