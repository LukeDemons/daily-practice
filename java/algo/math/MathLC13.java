package algo.math;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/roman-to-integer/
 * <p>
 * 2021-05-15 每日一题
 * 一次遍历，要想清楚谁和谁比较，什么时候加什么时候减。最后一位一定是加！
 */
public class MathLC13 {

    public static void main(String[] args) {
        MathLC13 instance = new MathLC13();

//        int result = instance.romanToInt("MCMXCIV");
        int result = instance.romanToInt("IV");

        System.out.println(result);
    }

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>(7);
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            // 当前字符对应的数字，小于右边的数字时，减去它
            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                result -= map.get(s.charAt(i));
            } else {
                result += map.get(s.charAt(i));
            }
        }
        // 加上最后一个字符对应的数字
        result += map.get(s.charAt(s.length() - 1));
        return result;
    }
}
