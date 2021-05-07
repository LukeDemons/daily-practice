package algo.bit;

/**
 * https://leetcode-cn.com/problems/xor-operation-in-an-array/
 * <p>
 * 2021-05-07 每日一题
 * 按部就班也不超时
 */
public class BitLC1486 {

    public static void main(String[] args) {
        BitLC1486 instance = new BitLC1486();

        int result = instance.xorOperation(5, 0);

        System.out.println(result);
    }

    /**
     * 按部就班法
     */
    public int xorOperation(int n, int start) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = start + 2 * i;
        }

        int result = 0;
        for (int i : arr) {
            result ^= i;
        }
        return result;
    }
}
