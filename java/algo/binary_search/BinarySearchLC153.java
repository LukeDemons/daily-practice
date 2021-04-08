package algo.binary_search;

/**
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 *
 * 2021-04-08 每日一题
 * 二分查找通用解法
 * https://leetcode-cn.com/problems/search-insert-position/solution/te-bie-hao-yong-de-er-fen-cha-fa-fa-mo-ban-python-/
 */
public class BinarySearchLC153 {

    public static void main(String[] args) {
        BinarySearchLC153 instance = new BinarySearchLC153();

        int result = instance.findMin(new int[]{4,5,6,7,0,1,2});

        System.out.println(result);
    }

    /**
     * 本题的 left + 1 ，要么是更大的值（升序），要么突然降序，掉到了最小值。
     * 所以无论如何，最小值还是包括在寻找范围内的。而右侧区域，如果草率就 right - 1 的话，可能就会错过最小值了
     */
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
//            int mid = (left + right) / 2;
            // 参考 JDK 中 Arrays.binarySearch() 函数的写法。
            // 理由是 left + right 即使是在整型溢出以后，由于无符号右移 >>> 1 ，仍然能够得到正确的结果
            int mid = (left + right) >>> 1;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
