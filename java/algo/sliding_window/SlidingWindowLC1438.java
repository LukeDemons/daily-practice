package algo.sliding_window;

import java.util.TreeMap;

/**
 * https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
 * <p>
 * 2021-02-21 每日一题
 * 暴力解直接超时。直接套滑窗模版没问题，但是在如何快速判断左指针移动的时候（最大值和最小值的差）需要利用冗余空间（有序集合或者单调队列）
 */
public class SlidingWindowLC1438 {

    public static void main(String[] args) {
        SlidingWindowLC1438 instance = new SlidingWindowLC1438();

        int result = instance.longestSubarray1(new int[]{8, 2, 4, 7}, 4);

        System.out.println(result);
    }

    public int longestSubarray1(int[] nums, int limit) {
        // key->每项的值 value->出现的数量，利用treeMap的特性可以直接拿到最大值和最小值
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int left = 0, right = 0;
        int longestCnt = 0;
        while (right < nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.lastKey() - map.firstKey() > limit) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            longestCnt = Math.max(longestCnt, right - left + 1);
            right++;
        }

        return longestCnt;
    }

    public int longestSubarray(int[] nums, int limit) {
        // 记录每个值为左端点的合规子数组的长度，时间复杂度是n2，可能会超时
        int longestCnt = 0;
        for (int i = 0; i < nums.length; i++) {
            int curMax = nums[i], curMin = nums[i];
            int left = i, right = i;
            while (right < nums.length) {
                curMax = Math.max(curMax, nums[right]);
                curMin = Math.min(curMin, nums[right]);
                if (curMax - curMin > limit) {
                    break;
                }
                longestCnt = Math.max(longestCnt, right - left + 1);
                right++;
            }
        }

        return longestCnt;
    }

}
