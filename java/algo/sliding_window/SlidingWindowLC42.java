package algo.sliding_window;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/trapping-rain-water/
 * https://leetcode-cn.com/problems/volume-of-histogram-lcci/
 * <p>
 * 2021-04-02 每日一题
 * 这两个是一道题，非常经典，最好理解的方法是双指针，单调栈和动态规划还需要再看一看
 */
public class SlidingWindowLC42 {

    public static void main(String[] args) {
        SlidingWindowLC42 instance = new SlidingWindowLC42();

        int result = instance.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});

        System.out.println(result);
    }

    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int sum = Arrays.stream(height).sum();
        int all = 0, high = 1;
        while (left <= right) {
            while (left <= right && height[left] < high) {
                left++;
            }
            while (left <= right && height[right] < high) {
                right--;
            }
            all += right - left + 1;
            high++;
        }
        // 双指针每层的加和 减去 本身柱子的面积，即为所求
        return all - sum;
    }
}
