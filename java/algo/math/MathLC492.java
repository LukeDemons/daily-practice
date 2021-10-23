package algo.math;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/construct-the-rectangle/
 *
 * 2021-10-23 每日一题
 * easy 注意返回值大小即可
 */
public class MathLC492 {

    public static void main(String[] args) {
        MathLC492 instance = new MathLC492();

        int[] result = instance.constructRectangle(4);

        System.out.println(Arrays.toString(result));
    }

    public int[] constructRectangle(int area) {
        int x = (int) Math.sqrt(area);
        while (area % x != 0) {
            x--;
        }
        int[] result = new int[2];
        result[0] = Math.min(x, area / x);
        result[1] = Math.max(x, area / x);
        return result;
    }
}
