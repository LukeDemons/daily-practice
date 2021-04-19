package algo.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/remove-element/
 * <p>
 * 2021-04-19 每日一题
 * easy重拳出击，但是我的方法要考虑最后一个值的情况
 */
public class ArrayLC27 {

    public static void main(String[] args) {
        ArrayLC27 instance = new ArrayLC27();

//        int result = instance.removeElement(new int[]{1, 3, 2, 2, 3, 3, 4, 5}, 3);
        int result = instance.removeElement(new int[]{3, 2, 2, 3}, 3);

        System.out.println(result);
    }

    public int removeElement(int[] nums, int val) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            while (fast < nums.length && nums[fast] == val) {
                fast++;
            }
            // 对于最后一个值的时候特殊考虑
            if (fast == nums.length) {
                continue;
            }
            nums[slow] = nums[fast];
            slow++;
            fast++;
        }
        System.out.println(Arrays.toString(nums));

        return slow;
    }
}
