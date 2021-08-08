package algo.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/n-th-tribonacci-number/
 * <p>
 * 2021-08-08 每日一题
 * 简单想是递归+缓存，再加深一下就是动归
 */
public class DpLC1137 {

    public static void main(String[] args) {
        DpLC1137 instance = new DpLC1137();

        int result = instance.tribonacci(5);

        System.out.println(result);
    }

    Map<Integer, Integer> cache = new HashMap<>();

    public int tribonacci(int n) {
        if (cache.get(n) != null) {
            return cache.get(n);
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        int result = tribonacci(n - 3) + tribonacci(n - 2) + tribonacci(n - 1);
        cache.put(n, result);
        return result;
    }

    /**
     * 动态数组 实现动态规划
     */
    public int tribonacci1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        int a = 0, b = 1, c = 1;
        for (int i = 3; i <= n; i++) {
            int d = a + b + c;
            a = b;
            b = c;
            c = d;
        }

        return c;
    }
}
