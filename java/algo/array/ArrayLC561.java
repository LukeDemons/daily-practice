package algo.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/array-partition-i/
 * <p>
 * 2021-02-16 每日一题
 * 简单的不像easy 写的和官方题解差了一丢丢
 */
public class ArrayLC561 {

    public static void main(String[] args) {
        ArrayLC561 instance = new ArrayLC561();

        int result = instance.arrayPairSum(new int[]{6, 2, 6, 5, 1, 2});

        System.out.println(result);
    }

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            // 这里和官方题解写的不太一样，应该用i+=2比较好，少遍历一般的数量
            if (i % 2 == 0) {
                sum += nums[i];
            }
        }

        return sum;
    }
}
