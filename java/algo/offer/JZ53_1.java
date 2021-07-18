package algo.offer;

/**
 * https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 * <p>
 * 2021-07-16 每日一题
 * 答辩当天的题做一下，二分还是不太行。。。
 */
public class JZ53_1 {

    public static void main(String[] args) {
        JZ53_1 instance = new JZ53_1();

        int result = instance.search1(new int[]{5, 7, 7, 8, 8, 10}, 8);

        System.out.println(result);
    }

    public int search(int[] nums, int target) {
        int result = 0;
        for (int num : nums) {
            if (num == target) {
                result++;
            }
        }
        return result;
    }

    public int search1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 先找左节点
        while (left < right) {
            int mid = left + right >>> 1;
            if (target == nums[mid]) {
                right = mid;
            } else if (target < nums[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        int realLeft = left;
        left = 0;
        right = nums.length - 1;

        // 再找右节点
        while (left < right) {
            // 向上取整
            int mid = left + right + 1 >>> 1;
            if (target == nums[mid]) {
                left = mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        int realRight = left;

        return realRight - realLeft + 1;
    }
}
