package algo.binary_search;

/**
 * https://leetcode-cn.com/problems/minimum-number-of-days-to-make-m-bouquets/
 * <p>
 * 2021-05-09 每日一题 致敬母亲节
 * 看起来挺难，其实就是按部就班的放大版
 */
public class BinarySearchLC1482 {

    public static void main(String[] args) {
        BinarySearchLC1482 instance = new BinarySearchLC1482();

        int result = instance.minDays(new int[]{7, 7, 7, 7, 12, 7, 7}, 2, 3);

        System.out.println(result);
    }

    public int minDays(int[] bloomDay, int m, int k) {
        if (m > bloomDay.length / k) {
            return -1;
        }
        int left = Integer.MAX_VALUE, right = 0;
        for (int day : bloomDay) {
            left = Math.min(left, day);
            right = Math.max(right, day);
        }
        // 对日期用二分查找
        while (left < right) {
            int days = left + right >>> 1;
            if (canMake(bloomDay, days, m, k)) {
                right = days;
            } else {
                left = days + 1;
            }
        }
        return left;
    }

    /**
     * 对某一天情况下，能否做够花束的判断
     */
    public boolean canMake(int[] bloomDay, int days, int m, int k) {
        int bouquets = 0;
        int flowers = 0;
        for (int i = 0; i < bloomDay.length && bouquets < m; i++) {
            if (bloomDay[i] <= days) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }
        return bouquets >= m;
    }
}
