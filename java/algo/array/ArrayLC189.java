package algo.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/rotate-array/
 */
public class ArrayLC189 {

    public static void main(String[] args) {
        ArrayLC189 instance = new ArrayLC189();

        int[] arr = new int[]{1, 2};
        instance.rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
    }

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int n = nums.length;
        // 并不是原地完成的
        int[] numCopy = Arrays.stream(nums).toArray();

        for (int i = 0; i < n; i++) {
            int replace = numCopy[(n + n - k + i) % n];

            nums[i] = replace;
        }
    }

    public void correct2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}
