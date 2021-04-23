package algo.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * 2021-04-23 每日一题太难了，动归整不明白，剑指来凑数
 */
public class JZ03 {

    public static void main(String[] args) {
        JZ03 instance = new JZ03();

        int result = instance.findRepeatNumber(new int[]{1, 2, 3, 3, 2});

        System.out.println(result);
    }

    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (!set.contains(n)) {
                set.add(n);
            } else {
                return n;
            }
        }
        return -1;
    }
}
