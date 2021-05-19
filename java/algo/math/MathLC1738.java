package algo.math;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/find-kth-largest-xor-coordinate-value/
 * <p>
 * 2021-05-19 每日一题
 * 二维前缀和，昨天题目的升级版
 */
public class MathLC1738 {

    public static void main(String[] args) {
        MathLC1738 instance = new MathLC1738();

        int result = instance.kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 1);

        System.out.println(result);
    }

    public int kthLargestValue(int[][] matrix, int k) {
        int[][] preSum = new int[matrix.length + 1][matrix[0].length + 1];
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, Comparator.comparingInt(a -> a));

        for (int i = 1; i < preSum.length; i++) {
            for (int j = 1; j < preSum[0].length; j++) {
                // 这块的递推公式，是利用偶数个相同数字异或和为0，定义出来的
                preSum[i][j] = preSum[i][j-1] ^ preSum[i-1][j] ^ preSum[i-1][j-1] ^ matrix[i-1][j-1];
                if (heap.size() < k) {
                    heap.add(preSum[i][j]);
                } else {
                    if (preSum[i][j] > heap.peek()) {
                        heap.poll();
                        heap.add(preSum[i][j]);
                    }
                }
            }
        }

        return heap.peek();
    }
}
