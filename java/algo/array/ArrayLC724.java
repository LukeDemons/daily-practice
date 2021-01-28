package algo.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/find-pivot-index/
 * <p>
 * 2021-01-28 每日一题
 * 这个就比较简单了，但是左右两个指针做起来并不容易，尝试良久，换成零和解法
 */
public class ArrayLC724 {

    public static void main(String[] args) {
        ArrayLC724 instance = new ArrayLC724();

//        int result = instance.pivotIndex(new int[]{1, 7, 3, 6, 5, 6});
//        int result = instance.pivotIndex(new int[]{-1, -1, 0, 0, -1, -1});
        int result = instance.pivotIndex(new int[]{-1, -1, 0, -1, -1, -1});

        System.out.println(result);
    }

    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int total = Arrays.stream(nums).sum();

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            // 当前值和其左右两侧值的和等于总和时，认为找到了这个值，因为total一定等于左+中+右
            if (sum * 2 + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }

        return -1;
    }

}
