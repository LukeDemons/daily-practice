package algo.math;

/**
 * https://leetcode-cn.com/problems/sum-of-square-numbers/
 * <p>
 * 2021-04-28 每日一题
 * 遍历一次最好理解，还可以双指针，二分的细节还要巩固
 */
public class MathLC633 {

    public static void main(String[] args) {
        MathLC633 instance = new MathLC633();

        boolean result = instance.judgeSquareSum2(2038480973);

        System.out.println(result);
    }

    /**
     * 借助二分思想 优化指针移动 （只能优化右边界，才一定不会错过）
     */
    public boolean judgeSquareSum2(int c) {
        int left = 0, right = (int) Math.sqrt(c);
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (left * left + right * right == c) {
                return true;
            } else if (left * left + right * right > c) {
                if (left * left + mid * mid > c) {
                    right = mid;
                }
                right--;
            } else {
                left++;
            }
        }
        return false;
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
