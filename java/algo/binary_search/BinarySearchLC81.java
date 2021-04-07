package algo.binary_search;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
 * <p>
 * 2021-04-07 每日一题
 * 两段升序，没有重复数字的是33题。如果有了重复数字，要多思考数组值相等的情况
 */
public class BinarySearchLC81 {

    public static void main(String[] args) {
        BinarySearchLC81 instance = new BinarySearchLC81();

        boolean result = instance.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3);

        System.out.println(result);
    }

    /**
     * 先CV 再理解
     */
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[left] == nums[right]) {
                left++;
                continue;
            }
            if (nums[mid] <= nums[right]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }

}
