package algo.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 * <p>
 * 2021-02-13 每日一题
 * 简单实现是easy，没想出原地解法，可以通过相反数的方式巧妙打标，厉害了
 */
public class ArrayLC448 {

    public static void main(String[] args) {
        ArrayLC448 instance = new ArrayLC448();

        List<Integer> result = instance.findDisappearedNumbers1(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
//        List<Integer> result = instance.findDisappearedNumbers1(new int[]{1, 1});

        System.out.println(result);
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null) {
            return new ArrayList<>();
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }

    public List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> result = new ArrayList<>();

        // 把数组里的值打上标记。如果数组里的值(也就是对应的下标)还没标记过，就变为负数
        for (int i = 0; i < nums.length; i++) {
            // 绝对值是为了忽略下面负号的影响；减一是因为下标都是从0开始的
            int curIndex = Math.abs(nums[i]) - 1;
            if (nums[curIndex] > 0) {
                nums[curIndex] = -nums[curIndex];
            }
        }

        // 如果已经打过标，则这个下标没有出现过
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                // 这里注意，序号要把下标加一。数组里值的大小不再重要了。
                result.add(i + 1);
            }
        }

        return result;
    }
}
