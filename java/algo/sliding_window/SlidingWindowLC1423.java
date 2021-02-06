package algo.sliding_window;

/**
 * https://leetcode-cn.com/problems/maximum-points-you-can-obtain-from-cards/
 * <p>
 * 2021-02-06 每日一题
 * 这道滑动窗口题的窗口是固定的，只要把所有可能的情况滑出来比一下就行了
 */
public class SlidingWindowLC1423 {

    public static void main(String[] args) {
        SlidingWindowLC1423 instance = new SlidingWindowLC1423();

        int result = instance.maxScore(new int[]{2, 3, 4, 5, 1, -1, 2}, 2);

        System.out.println(result);
    }

    public int maxScore(int[] cardPoints, int k) {
        int length = cardPoints.length;

        int initSum = 0;
        // 从-k到0开始滑
        for (int i = length - 1; i > length - k - 1; i--) {
            initSum += cardPoints[i];
        }

        int curSum = initSum;
        int maxSum = initSum;
        for (int i = 0; i < k; i++) {
            curSum -= cardPoints[length - k + i];
            curSum += cardPoints[i];
            maxSum = Math.max(maxSum, curSum);
        }

        return maxSum;
    }
}
