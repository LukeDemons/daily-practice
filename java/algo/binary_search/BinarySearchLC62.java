package algo.binary_search;

/**
 * https://leetcode-cn.com/problems/sqrtx/
 * <p>
 * 2021-05-05 二分查找day2
 */
public class BinarySearchLC62 {

    public static void main(String[] args) {
        BinarySearchLC62 instance = new BinarySearchLC62();

        int result = instance.mySqrt(8);

        System.out.println(result);
    }

    public int mySqrt(int x) {
        int left = 0, right = x;
        while (left < right) {
            // +1是为了向上取整，保证不会死循环
            int mid = left + right + 1 >>> 1;
            if (mid == x / mid) {
                return mid;
            } else if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        return left;
    }
}
