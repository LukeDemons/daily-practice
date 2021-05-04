package algo.binary_search;

/**
 * https://leetcode-cn.com/problems/search-insert-position/
 * <p>
 * 二分查找init
 */
public class BinarySearchLC35 {

    public static void main(String[] args) {
        BinarySearchLC35 instance = new BinarySearchLC35();

        int result = instance.searchInsert(new int[]{1, 2, 3, 4}, 5);

        System.out.println(result);
    }

    /**
     * 1. 循环条件使用小于，可以使结束时left=right
     * 2. mid将区间分为两部分，思考下一次选取哪个区间，不考虑一定不存在的，考虑可能存在的区间，l~m? l~m-1? m~r? m+1~r?
     * 3. 条件判断时先想好想的
     *
     * 本题，要找大于等于target的位置，所以区间划分为l~m m+1~r
     */
    public int searchInsert(int[] nums, int target) {
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + right >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
