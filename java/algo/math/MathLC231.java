package algo.math;

/**
 * https://leetcode-cn.com/problems/power-of-two/
 * <p>
 * 2021-05-30 每日一题
 * 补一道昨天的easy
 */
public class MathLC231 {

    public static void main(String[] args) {
        MathLC231 instance = new MathLC231();

        boolean result = instance.isPowerOfTwo(5);

        System.out.println(result);
    }

    public boolean isPowerOfTwo1(int n) {
        return n > 0 && (n & n - 1) == 0;
    }

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        while (n != 1) {
            if (n % 2 != 0) {
                return false;
            }
            n /= 2;
        }

        return true;
    }
}
