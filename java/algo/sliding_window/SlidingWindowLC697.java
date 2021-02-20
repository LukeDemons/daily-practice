package algo.sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/degree-of-an-array/
 * <p>
 * 2021-02-20 每日一题
 * 暴力拆解一次成功，但是只击败8%。看答案的方法感觉优化也不大，在第一次遍历的时候把所有的信息都记下来了，击败82%
 */
public class SlidingWindowLC697 {

    public static void main(String[] args) {
        SlidingWindowLC697 instance = new SlidingWindowLC697();

//        int result = instance.findShortestSubArray1(new int[]{1, 2, 2, 3, 1});
        int result = instance.findShortestSubArray1(new int[]{1, 2, 2, 3, 1, 4, 2});

        System.out.println(result);
    }

    public int findShortestSubArray1(int[] nums) {
        // 统计每个数出现的次数、第一次出现的位置、最后一次出现的位置
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            } else {
                map.put(nums[i], new int[]{1, i, i});
            }
        }

        int maxCnt = 0;
        int minLen = 0;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            if (maxCnt < entry.getValue()[0]) {
                // 发现更小的度就换
                maxCnt = entry.getValue()[0];
                minLen = entry.getValue()[2] - entry.getValue()[1] + 1;
            } else if (maxCnt == entry.getValue()[0]) {
                // 度相同的就取最小
                minLen = Math.min(minLen, entry.getValue()[2] - entry.getValue()[1] + 1);
            }
        }

        return minLen;
    }

    public int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> cntMap = new HashMap<>();
        List<Integer> du = new ArrayList<>();
        int maxCnt = 1;
        for (int n : nums) {
            int curCnt = cntMap.get(n) == null ? 0 : cntMap.get(n) + 1;
            cntMap.put(n, curCnt);
            if (maxCnt == curCnt) {
                du.add(n);
            } else if (maxCnt < curCnt) {
                maxCnt = curCnt;
                du = new ArrayList<>();
                du.add(n);
            }
        }

        int minLength = Integer.MAX_VALUE;
        for (int d : du) {
            minLength = Math.min(minLength, subArrayLength(nums, d));
        }

        return minLength;
    }

    public int subArrayLength(int[] nums, int m) {
        int left = 0, right = nums.length - 1;
        while (nums[left] != m) {
            left++;
        }
        while (nums[right] != m) {
            right--;
        }

        return right - left + 1;
    }
}
