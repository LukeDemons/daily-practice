package algo.array;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * <p>
 * 是80题的前置题目
 */
public class ArrayLC26 {

    public static void main(String[] args) {
        ArrayLC26 instance = new ArrayLC26();

        int result = instance.removeDuplicates(new int[]{});

        System.out.println(result);
    }

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n;
        }
        int slow = 1, fast = 1;
        while (fast < n) {
            if (nums[slow - 1] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
