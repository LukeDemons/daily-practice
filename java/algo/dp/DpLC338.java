package algo.dp;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/counting-bits/
 * <p>
 * 2021-03-03 每日一题
 * 不看标签都不知道该如何归类了
 */
public class DpLC338 {

    public static void main(String[] args) {
        DpLC338 instance = new DpLC338();

        int[] result = instance.countBits(5);

        System.out.println(Arrays.toString(result));
    }

    // 使用jdk-api直接实现
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            result[i] = Integer.bitCount(i);
        }
        return result;
    }

    // 使用容易理解的计算实现
    public int[] countBits1(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int ones = 0;
            while (i > 0) {
                // 当前值 与 当前值减一，可以得出？？？
                i &= (i - 1);
                ones++;
            }
            result[i] = ones;
        }
        return result;
    }

    // 最高有效位。还不是很明白，需要再看一看。类似的题解思路还有 最低有效位、最低设置位
    public int[] countBits2(int num) {
        int[] result = new int[num + 1];
        int highBit = 0;
        for (int i = 1; i <= num; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            result[i] = result[i - highBit] + 1;
        }
        return result;
    }
}
