package algo.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/summary-ranges/
 */
public class ArrayLC228 {

    public static void main(String[] args) {
        ArrayLC228 instance = new ArrayLC228();
        List<String> result = instance.summaryRanges(new int[]{0,2,3,4,6,8,9});
        System.out.println(result);
    }

    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        int begin = nums[0];
        int end = nums[0];
        List<String> result = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                end++;
                continue;
            }
            if (begin == end) {
                result.add(begin + "");
            } else {
                result.add(begin + "->" + end);
            }
            begin = nums[i];
            end = nums[i];
        }
        if (begin == end) {
            result.add(begin + "");
        } else {
            result.add(begin + "->" + end);
        }

        return result;
    }
}
