package algo.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/maximum-product-of-three-numbers/
 */
public class ArrayLC628 {

    public static void main(String[] args) {
        ArrayLC628 instance = new ArrayLC628();

        int result = instance.maximumProduct(new int[]{-1, -9, 2, 3});

        System.out.println(result);
    }

    /**
     * 排序法
     */
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        // （倒一、零、一）<-有两负；（倒一、倒二、倒三）<-三正
        return Math.max(nums[n - 1] * nums[0] * nums[1], nums[n - 1] * nums[n - 2] * nums[n - 3]);
    }

    /**
     * 直接遍历
     */
    public int maximumProduct2(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE,
                min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }

            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
        }

        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }
}
