package algo.array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/minimum-number-of-k-consecutive-bit-flips/
 * <p>
 * 2021-02-18 每日一题
 * 开工一道hard，贪心就不太好想，而且不是普通滑动窗口，想法还挺有意思的
 */
public class ArrayLC995 {

    public static void main(String[] args) {
        ArrayLC995 instance = new ArrayLC995();

        int result = instance.minKBitFlips1(new int[]{0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 1}, 3);
//        int result = instance.minKBitFlips1(new int[]{0, 1, 1}, 2);

        System.out.println(result);
    }

    // 其实也是贪心，只不过不真翻，而是拿队列记一下
    public int minKBitFlips1(int[] A, int K) {
        // 队列的含义是 前K-1个数字翻转情况
        Queue<Integer> queue = new LinkedList<>();
        int cnt = 0;
        for (int i = 0; i < A.length; i++) {
            // 不在窗口中时，移出队头元素。这里注意 队头+窗口=下标 时，队头已经覆盖不到下标，需要移出
            if (queue.peek() != null && i >= queue.peek() + K) {
                queue.remove();
            }
            // 值不够K个就不能再翻了。如果还需翻转，直接返回-1
            if (i > A.length - K && ((queue.size() % 2) ^ A[i]) == 0) {
                return -1;
            }
            // 如果队列里的数量为偶数，数组当前值为0，则翻转
            // 如果队列里的数量为奇数，数组当前值为1，也翻转
            if (((queue.size() % 2) ^ A[i]) == 0) {
                cnt++;
                queue.offer(i);
            }
        }

        return cnt;
    }

    // 贪心策略 遇到0就翻 超时
    public int minKBitFlips(int[] A, int K) {
        int cnt = 0;
        for (int i = 0; i <= A.length - K; i++) {
            if (A[i] == 0) {
                cnt++;
                // 反转K个
                for (int j = i; j < i + K; j++) {
                    if (A[j] == 0) {
                        A[j] = 1;
                    } else if (A[j] == 1) {
                        A[j] = 0;
                    }
                }
            }
        }

        for (int i = A.length - K; i < A.length; i++) {
            if (A[i] == 0) {
                return -1;
            }
        }
        return cnt;
    }
}
