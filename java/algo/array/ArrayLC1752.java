package algo.array;

/**
 * https://leetcode.cn/problems/check-if-array-is-sorted-and-rotated/
 * <p>
 * 2022-11-27 每日一题
 * 简单但挺有意思 适合作为面试题目
 */
public class ArrayLC1752 {

    public static void main(String[] args) {
        ArrayLC1752 instance = new ArrayLC1752();

//        boolean result = instance.check(new int[]{3, 4, 5, 1, 2});
//        boolean result = instance.check(new int[]{2, 1, 3, 4});
        boolean result = instance.check(new int[]{1, 2, 3});

        System.out.println(result);
    }

    /**
     * 如何判断两段单调递增 并且后半段的最大值还要小于前半段的最小值
     */
    public boolean check(int[] nums) {
        int cursor = 0;
        while (cursor < nums.length - 1) {
            if (nums[cursor + 1] < nums[cursor]) {
                break;
            }
            cursor++;
        }
        cursor++;
        // 到最后都是单调递增的 就可以结束了
        if (cursor == nums.length) {
            return true;
        }
        while (cursor < nums.length - 1) {
            if (nums[cursor + 1] < nums[cursor]) {
                return false;
            }
            cursor++;
        }

        return nums[nums.length - 1] <= nums[0];
    }
}
