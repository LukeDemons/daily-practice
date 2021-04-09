package algo.binary_search;

/**
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 *
 * 2021-04-09 每日一题
 * 和昨天题目类似，只是包含了重复数字
 */
public class BinarySearchLC154 {

    public static void main(String[] args) {
        BinarySearchLC154 instance = new BinarySearchLC154();

        int result = instance.findMin(new int[]{2,2,2,0,1});

        System.out.println(result);
    }

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                // 只判断中点值和右侧值大小即可。这个逻辑需要举例得到。
                left = mid + 1;
            } else {
                right--;
            }
        }

        return nums[left];
    }
}