package algo.math;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/set-mismatch/
 * <p>
 * 2021-07-04 每日一题
 * 零散练一练easy =，=
 */
public class MathLC645 {

    public static void main(String[] args) {
        MathLC645 instance = new MathLC645();

        int[] result = instance.findErrorNums1(new int[]{1, 2, 2, 4});

        System.out.println(Arrays.toString(result));
    }

    /**
     * hash，两个的是重复的，零个的是丢失的
     */
    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        int[] map = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            map[nums[i - 1]]++;
        }
        for (int i = 1; i <= nums.length; i++) {
            if (map[i] == 2) {
                result[0] = i;
            } else if (map[i] == 0) {
                result[1] = i;
            }
        }

        return result;
    }

    /**
     * 使用set去重得到丢失的数字；通过求和和做差得到重复的数字
     */
    public int[] findErrorNums1(int[] nums) {
        int[] result = new int[2];
        int sum = 0;
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            set.add(num);
            sum += num;
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                result[1] = i;
                sum += i;  // 丢失的数字不能减
            }
            sum -= i;
        }
        result[0] = sum;  // 最后就剩加了两遍的数字
        return result;
    }
}
