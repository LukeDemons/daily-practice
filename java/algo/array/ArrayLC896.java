package algo.array;

/**
 * https://leetcode-cn.com/problems/monotonic-array/
 * <p>
 * 2021-02-28 每日一题
 * 简单的不像easy但没有一次通关，不过在没看题解的前提下ac的还算可以吧，2月勋章拿到
 */
public class ArrayLC896 {

    public static void main(String[] args) {
        ArrayLC896 instance = new ArrayLC896();

        boolean result = instance.isMonotonic(new int[]{-1, -1, -3, -4});

        System.out.println(result);
    }

    public boolean isMonotonic(int[] A) {
        if (A == null || A.length <= 1) {
            return true;
        }

        int increase = 0;
        int decrease = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[i - 1]) continue;
            if (A[i] < A[i - 1]) {
                decrease++;
            }
            if (A[i] > A[i - 1]) {
                increase++;
            }
            if (increase * decrease != 0) {
                return false;
            }
        }

        return increase * decrease == 0;
    }

}
