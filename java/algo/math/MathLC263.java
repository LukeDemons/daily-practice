package algo.math;

/**
 * https://leetcode-cn.com/problems/maximum-product-of-three-numbers/
 * <p>
 * 2021-04-10 每日一题
 * 这题唯一的争议就是当n小于0的时候，算不算丑数
 */
public class MathLC263 {

    public static void main(String[] args) {
        MathLC263 instance = new MathLC263();

        boolean result = instance.isUgly(14);

        System.out.println(result);
    }

    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }
        return n == 1;
    }
}
