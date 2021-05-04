package algo.binary_search;

/**
 * https://leetcode-cn.com/problems/binary-search/
 * <p>
 * 二分查找init
 */
public class BinarySearchLC704 {

    public static void main(String[] args) {
        BinarySearchLC704 instance = new BinarySearchLC704();

        int result = instance.search(new int[]{3}, 3);

        System.out.println(result);
    }

    /**
     * 1. 循环的判断使用小于号，结果出来时left=right
     * 2. 区间划分最重要，都是闭区间 l~m---m+1~r l~m-1---m~r
     * 3. 先判断非常肯定的分支
     * <p>
     * 退出循环不代表题目做完！
     */
    public int search(int[] nums, int target) {
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
        // 按之前的套路解完题之后，还要处理left下标情况
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }
}
