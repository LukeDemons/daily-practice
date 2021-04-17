package algo.sliding_window;

import java.util.TreeSet;

/**
 * https://leetcode-cn.com/problems/contains-duplicate-iii/
 * <p>
 * 2021-04-17 每日一题
 * 转换为滑窗问题，找到结束条件
 */
public class SlidingWindowLC220 {

    public static void main(String[] args) {
        SlidingWindowLC220 instance = new SlidingWindowLC220();

        boolean result = instance.containsNearbyAlmostDuplicate1(new int[]{1, 2, 3, 1}, 3, 0);

        System.out.println(result);
    }

    /**
     * 暴力解直接超时
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs((long)nums[i] - nums[j]) <= t && Math.abs(i - j) <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 使用TreeSet维护一个，大小固定为k的，有序集合（滑窗）
     * 求其中的 最小大数和当前 当前和最大小数 的差值 是否满足要求
     */
    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        TreeSet<Long> ts = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long u = (long) nums[i];
            // 从 ts 中找到小于等于 u 的最大值（小于等于 u 的最接近 u 的数）
            Long l = ts.floor(u);
            // 从 ts 中找到大于等于 u 的最小值（大于等于 u 的最接近 u 的数）
            Long r = ts.ceiling(u);
            if (l != null && u - l <= t) return true;
            if (r != null && r - u <= t) return true;
            // 将当前数加到 ts 中
            ts.add(u);
            // 移除下标范围不在 [max(0, i - k), i) 的数（维持滑动窗口大小为 k）
            if (i >= k) ts.remove((long) nums[i - k]);
        }
        return false;
    }
}
