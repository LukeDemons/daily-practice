package algo.sliding_window;

/**
 * https://leetcode-cn.com/problems/max-consecutive-ones-iii/
 * <p>
 * 2021-02-19 每日一题
 * 重点在于理解题意，「最多K个0转为1，求最长1的数量」变为「最多含有K个0的1连续最长长度」
 */
public class SlidingWindowLC1004 {

    public static void main(String[] args) {
        SlidingWindowLC1004 instance = new SlidingWindowLC1004();

        int result = instance.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2);

        System.out.println(result);
    }

    public int longestOnes(int[] A, int K) {
        int left = 0, right = 0;

        int maxCnt = 0, zeroCnt = 0;
        while (right < A.length) {
            // 先判断右指针情况
            if (A[right] == 0) {
                zeroCnt++;
            }
            // 再看窗口是否满足，调整左指针
            while (zeroCnt > K) {
                if (A[left] == 0) {
                    zeroCnt--;
                }
                left++;
            }
            // 最后记录窗口长度，调整右指针
            maxCnt = Math.max(maxCnt, right - left + 1);
            right++;
        }

        return maxCnt;
    }
}
