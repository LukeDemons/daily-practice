package algo.binary_search;

/**
 * https://leetcode-cn.com/problems/first-bad-version/
 * <p>
 * 2021-06-13 每日一题
 * 简单二分，盼回归做题
 */
public class BinarySearchLC278 {

    public static void main(String[] args) {
        BinarySearchLC278 instance = new BinarySearchLC278();

        int result = instance.firstBadVersion(10);

        System.out.println(result);
    }

    public int firstBadVersion(int n) {
        int left = 0, right = n;
        while (left < right) {
            int mid = left + right >>> 1;
            if (isBadVersion(mid)) {
                // mid 还有可能是答案
                right = mid;
            } else {
                // mid 一定不会是答案
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isBadVersion(int version) {
        return version >= 4;
    }
}
