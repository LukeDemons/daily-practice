package algo.bit;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/single-number-ii/
 * <p>
 * 2021-04-30 每日一题
 * 位运算、状态机 不好理解
 */
public class BitLC137 {

    public static void main(String[] args) {
        BitLC137 instance = new BitLC137();

        int result = instance.singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99});

        System.out.println(result);
    }

    /**
     * 好难理解，不打算磕了 =，=
     */
    public int singleNumber1(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }

    /**
     * 使用额外空间
     */
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
