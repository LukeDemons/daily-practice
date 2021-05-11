package algo.bit;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/xor-queries-of-a-subarray/
 * <p>
 * 2021-05-12 每日一题
 * 这段时间和异或干上了
 */
public class BitLC1310 {

    public static void main(String[] args) {
        BitLC1310 instance = new BitLC1310();

        int[] result = instance.xorQueries1(new int[]{1, 3, 4, 8, 2, 4}, new int[][]{{0, 1}, {1, 2}, {0, 3}, {3, 3}});
//        int[] result = instance.xorQueries1(new int[]{15, 8, 8, 8, 15}, new int[][]{{2, 2}, {3, 3}});

        System.out.println(Arrays.toString(result));
    }

    /**
     * 按部就班 没有超时 但是很慢
     */
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int one = 0;
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                one ^= arr[j];
            }
            result[i] = one;
        }

        return result;
    }

    /**
     * 前缀和 加 异或性质
     */
    public int[] xorQueries1(int[] arr, int[][] queries) {
        int[] result = new int[queries.length];
        int[] preSum = new int[arr.length];
        preSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            preSum[i] = preSum[i - 1] ^ arr[i];
        }
        for (int i = 0; i < queries.length; i++) {
            // 0~left-1 ^ 0~right
            result[i] = (queries[i][0] == 0 ? 0 : preSum[queries[i][0] - 1]) ^ preSum[queries[i][1]];
        }
        return result;
    }
}
