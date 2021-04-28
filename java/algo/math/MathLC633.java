package algo.math;

/**
 * https://leetcode-cn.com/problems/sum-of-square-numbers/
 * <p>
 * 2021-04-28 每日一题
 * 遍历一次最好理解，还可以双指针
 */
public class MathLC633 {

    public static void main(String[] args) {
        MathLC633 instance = new MathLC633();

        boolean result = instance.judgeSquareSum1(3);

        System.out.println(result);
    }

    /**
     * 遍历一次
     */
    public boolean judgeSquareSum1(int c) {
        for (long i = 0; i * i <= c; i++) {
            double j = Math.sqrt(c - Math.pow(i, 2));
            // 这么写不如 (int) j == j 的效率高
            if (j % 1 == 0) {
                return true;
            }
        }
        return false;
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
