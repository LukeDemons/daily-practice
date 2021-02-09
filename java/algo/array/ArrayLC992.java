package algo.array;

/**
 * https://leetcode-cn.com/problems/subarrays-with-k-different-integers/
 * <p>
 * 2021-02-09 每日一题
 * 这题好难，看完答案还绕了一会儿，逐步拆解成下面三步
 * 1）先求最多K个不同字符时的窗口大小
 * 2）此时窗口大小相当于右指针不动，左指针逐个右移，也就是对应子数组个数
 * 3）K个不同字符就等于最多K个字符时数组的个数（1个到K个）减去 最多K-1个字符时数组的个数（1个到K-1个）
 */
public class ArrayLC992 {

    public static void main(String[] args) {
        ArrayLC992 instance = new ArrayLC992();

        int result = instance.subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2);

        System.out.println(result);
    }

    public int subarraysWithKDistinct(int[] A, int K) {
        // K个不同整数的子数组的个数 = 最多K个不同整数的子数组的个数（1个到K个） - 最多K-1个不同整数的子数组的个数（1个到K-1个）
        return atMostK(A, K) - atMostK(A, K - 1);
    }

    /**
     * 子数组中最多K个字符时，子数组个数是多少
     */
    public int atMostK(int[] A, int K) {
        int n = A.length;
        // 数组模拟map，如果出现了不同的字符就在窗口里就加一
        int[] map = new int[n + 1];
        int left = 0, right = 0;
        int distinct = 0;
        int result = 0;
        while (right < n) {
            if (map[A[right]] == 0) {
                distinct++;
            }
            map[A[right]]++;
            while (distinct > K) {
                // 这次右指针右移扩大窗口时，不同的字符数超了，要把左指针右移缩小窗口
                map[A[left]]--;
                if (map[A[left]] == 0) {
                    distinct--;
                }
                left++;
            }
            // 窗口大小等于最长子数组长度
            // 题目要求的子数组个数，就等于窗口长度，就相当于左指针逐步右移，移动一下算一个数组
//            result = Math.max(result, right - left + 1);
            result += right - left + 1;
            right++;
        }

        return result;
    }
}
