package algo.sliding_window;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/sliding-window-median/
 * <p>
 * 2021-02-03 每日一题
 * 滑动窗口月=，= 写出了暴力解法，不超时的只要维护好「排好序」的窗口即可
 */
public class SlidingWindowLC480 {

    public static void main(String[] args) {
        SlidingWindowLC480 instance = new SlidingWindowLC480();

        double[] result = instance.medianSlidingWindow2(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);

        System.out.println(Arrays.toString(result));
    }

    public double[] medianSlidingWindow2(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        // 取第一个窗口的数据
        int[] window = Arrays.copyOf(nums, k);
        // 对窗口里的值排序
        Arrays.sort(window);
        result[0] = getMedian(window);

        int left = 0;
        // 窗口滑动
        while (left + k < nums.length) {
            // 需要删除的数（left）
            int index = binarySearch(window, nums[left]);
            // 替换为需要插入的数（right）
            window[index] = nums[left + k];
            // 向后冒泡
            while (index < window.length - 1 && window[index] > window[index + 1]) {
                swap(window, index, index + 1);
                index++;
            }
            // 向前冒泡
            while (index > 0 && window[index] < window[index - 1]) {
                swap(window, index, index - 1);
                index--;
            }
            // 给下一个赋值并右移
            result[++left] = getMedian(window);
        }

        return result;
    }

    private void swap(int[] window, int i, int j) {
        int temp = window[i];
        window[i] = window[j];
        window[j] = temp;
    }

    public int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
//            int mid = (left + right) / 2;
            int mid = left + (right - left) / 2; // 避免越界
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    /**
     * 暴力解法会超时
     */
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        int left = 0, right = left + k - 1;
        while (right < nums.length) {
            result[left] = getMedian(Arrays.copyOfRange(nums, left, right + 1));
            left++;
            right++;
        }

        return result;
    }

    public double getMedian(int[] nums) {
        nums = Arrays.stream(nums).sorted().toArray();
        if (nums.length % 2 == 0) {
//            return (nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2.0;
            return nums[nums.length / 2 - 1] / 2.0 + nums[nums.length / 2] / 2.0; // 避免越界
        } else {
            return nums[nums.length / 2];
        }
    }
}
