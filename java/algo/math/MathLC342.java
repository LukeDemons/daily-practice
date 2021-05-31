package algo.math;

/**
 * https://leetcode-cn.com/problems/power-of-four/
 * <p>
 * 2021-05-31 每日一题
 * 尽量恢复正轨
 */
public class MathLC342 {

    public static void main(String[] args) {
        MathLC342 instance = new MathLC342();

        boolean result = instance.isPowerOfFour(0);

        System.out.println(result);
    }

    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }
        while (n != 1) {
            if (n % 4 != 0) {
                return false;
            }
            n /= 4;
        }

        return true;
    }
}
