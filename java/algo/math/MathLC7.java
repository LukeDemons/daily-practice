package algo.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/reverse-integer/
 * <p>
 * 2021-05-03 每日一题
 * 重拳出击
 */
public class MathLC7 {

    public static void main(String[] args) {
        MathLC7 instance = new MathLC7();

//        int result = instance.reverse1(-123);
//        int result = instance.reverse1(1534236469);
        int result = instance.reverse1(-901000);

        System.out.println(result);
    }

    /**
     * 不借助额外空间的解法，最需要关注的就是对于溢出情况的判断
     */
    public int reverse1(int x) {
        int result = 0;
        while (x != 0) {
            // 每次取末尾的数字 填到另一个数字的头 然后数字后移一位
            int finalOne = x % 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && finalOne > 7)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && finalOne < -8)) {
                return 0;
            }
            result = result * 10 + finalOne;
            x /= 10;
        }
        return result;
    }

    /**
     * 简单思路
     */
    public int reverse(int x) {
        boolean up = true;
        if (x <= 0) {
            x = -x;
            up = false;
        }
        List<Integer> list = new ArrayList<>(32);
        int item = x;
        while (item > 0) {
            list.add(item % 10);
            item /= 10;
        }
        Collections.reverse(list);

        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            // 对溢出做特殊处理
            if (result + list.get(i) * Math.pow(10, i) >= Integer.MAX_VALUE) {
                return 0;
            }
            result += list.get(i) * Math.pow(10, i);
        }
        if (!up) {
            result = -result;
        }

        return result;
    }
}
