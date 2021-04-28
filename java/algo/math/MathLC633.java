package algo.math;

/**
 * https://leetcode-cn.com/problems/sum-of-square-numbers/
 * <p>
 * 2021-04-28 每日一题
 * 暴力容易解，回家写dp
 */
public class MathLC633 {

    public static void main(String[] args) {
        MathLC633 instance = new MathLC633();

        boolean result = instance.judgeSquareSum(1);

        System.out.println(result);
    }

    /**
     * 暴力肯定超时
     */
    public boolean judgeSquareSum(int c) {
        for (int i = 0; i <= c; i++) {
            for (int j = i; j <= c; j++) {
                if (Math.pow(i, 2) + Math.pow(j, 2) == c) {
                    return true;
                }
            }
        }
        return false;
    }
}
