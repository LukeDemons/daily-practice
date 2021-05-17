package algo.math;

/**
 * https://leetcode-cn.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/
 * <p>
 * 2021-05-18 每日一题
 * 最近和异或干上了，一看以为是dfs，其实是前缀和
 */
public class MathLC1442 {

    public static void main(String[] args) {
        MathLC1442 instance = new MathLC1442();

        int result = instance.countTriplets(new int[]{2, 3, 1, 6, 7});

        System.out.println(result);
    }

    public int countTriplets(int[] arr) {
        int[] preSum = new int[arr.length + 1];
        for (int i = 1; i <= arr.length; i++) {
            preSum[i] = preSum[i - 1] ^ arr[i - 1];
        }
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int k = i + 1; k < arr.length; k++) {
                // 从i到k+1 这段区间里面的数字异或之后前缀和的值不变
                // 所以i和k固定，然后j可以是这里面的任意一个
                if (preSum[i] == preSum[k + 1]) {
                    result += k - i;
                }
            }
        }

        return result;
    }
}
