package algo.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * <p>
 * 2021-04-05 每日一题
 * 一次AC，但是属于标准API-CALLER，，其实核心的思想就是正着不好解就倒着想
 */
public class ArrayLC88 {

    public static void main(String[] args) {
        ArrayLC88 instance = new ArrayLC88();

        int[] num1 = new int[]{1, 2, 3, 0, 0, 0};
        instance.merge1(num1, 3, new int[]{2, 5, 6}, 3);

        System.out.println(Arrays.toString(num1));
    }

    // 先复制再合并
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, idx = m + n - 1;
        while (i >= 0 || j >= 0) {
            if (i >= 0 && j >= 0) {
                // 两个数组都还有值
                nums1[idx--] = nums1[i] >= nums2[j] ? nums1[i--] : nums2[j--];
            } else if (i >= 0) {
                // 只剩nums1有值
                nums1[idx--] = nums1[i--];
            } else {
                // 只剩nums2有值
                nums1[idx--] = nums2[j--];
            }
        }
    }

    // 多余空间
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];
        int i = 0, j = 0, idx = 0;
        while (i < m || j < n) {
            if (i < m && j < n) {
                result[idx++] = nums1[i] <= nums2[j] ? nums1[i++] : nums2[j++];
            } else if (i < m) {
                result[idx++] = nums1[i++];
            } else {
                result[idx++] = nums2[j++];
            }
        }
        System.arraycopy(result, 0, nums1, 0, m + n);
    }
}
