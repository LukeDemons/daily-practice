package algo.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 * <p>
 * 2021-05-03 递归->记忆化递归->dp
 */
public class JZ10_1 {

    public static void main(String[] args) {
        JZ10_1 instance = new JZ10_1();

        int result = instance.fib2(45);

        System.out.println(result);
    }

    /**
     * 最简单DP不能省
     */
    public int fib2(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] dp = new int[101];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }

    Map<Integer, Integer> cache = new HashMap<>();

    public int fib1(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (cache.get(n) != null) {
            return cache.get(n);
        }
        int result = fib1(n - 1) + fib1(n - 2);
        // 题目要求结果对1000000007取模，，，，我想了半天
        result %= 1000000007;
        cache.put(n, result);
        return result;
    }

    /**
     * 简单递归竟然超时了，记忆化走起
     */
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
