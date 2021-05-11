package algo.bit;

/**
 * https://leetcode-cn.com/problems/number-of-1-bits/
 * <p>
 * 2021-03-22 每日一题
 * 这题是338题的前置条件，核心是了解，n&n-1 =》可以去掉n的最后一个1
 */
public class BitLC191 {

    public static void main(String[] args) {
        BitLC191 instance = new BitLC191();

//        String str = "11111111111111111111111111111001";
        String str = "00000000000000000000000000001011";
        long param = 0;
        for (int i = 0; i < str.length(); i++) {
            param += (str.charAt(str.length() - 1 - i) - '0') * Math.pow(2, i);
        }

        System.out.println(param);

        int result = instance.hammingWeight(param);

        System.out.println(result);
    }

    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    // you need to treat n as an unsigned value
    public int hammingWeight(long n) {
        int result = 0;
        // 这里的循环条件不能用n>0，要兼顾负数的情况
        while (n != 0) {
            // 当前数字 与 当前数字减一 会去掉最后一个1
            n &= n - 1;
            result++;
        }
        return result;
    }

}
