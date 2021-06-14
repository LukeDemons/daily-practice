package algo.binary_search;

/**
 * https://leetcode-cn.com/problems/guess-number-higher-or-lower/
 * <p>
 * 2021-06-14 每日一题
 * 基础二分，just like yesterday
 */
public class BinarySearchLC374 {

    public static void main(String[] args) {
        BinarySearchLC374 instance = new BinarySearchLC374();

        int result = instance.guessNumber(2);

        System.out.println(result);
    }

    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + right >>> 1;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == -1) {
                // 因为一定会找到猜测的值，所以这里的1可减可不减，可以随意把mid划分到一个区间
                right = mid;
            } else if (guess(mid) == 1) {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * @param num your guess
     * @return -1 if num is lower than the guess number
     * 1 if num is higher than the guess number
     * otherwise return 0
     */
    private int guess(int num) {
        int pick = 2;
        return Integer.compare(pick, num);
    }
}
