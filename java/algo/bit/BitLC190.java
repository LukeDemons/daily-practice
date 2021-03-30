package algo.bit;

/**
 * https://leetcode-cn.com/problems/reverse-bits/
 * <p>
 * 2021-03-29 每日一题
 * 昨天忘记提交了，位运算的逻辑了解欠佳
 */
public class BitLC190 {

    public static void main(String[] args) {
        BitLC190 instance = new BitLC190();

        int result = instance.reverseBits(8);

        System.out.println(result);
    }

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int t = (n >> i) & 1; // 去掉其他位置的0
            // 逐位检查，如果第i位是1，就把对应位置的值置为1
            if (t == 1) {
                result |= (1 << (31 - i));
            }
        }
        return result;
    }
}
