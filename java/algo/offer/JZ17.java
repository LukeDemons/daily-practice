package algo.offer;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 * <p>
 * 2021-05-15 简单到不应该写到题目里。大数表示使用dfs
 */
public class JZ17 {

    public static void main(String[] args) {
        JZ17 instance = new JZ17();

        int[] result = instance.printNumbers(2);

        System.out.println(Arrays.toString(result));
    }

    public int[] printNumbers(int n) {
        int max = (int) (Math.pow(10, n) - 1);
        int[] result = new int[max];
        for (int i = 1; i <= max; i++) {
            result[i - 1] = i;
        }
        return result;
    }
}
