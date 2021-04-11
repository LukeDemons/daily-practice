package algo.math;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/ugly-number-ii/
 * <p>
 * 2021-04-11 每日一题
 * 和昨天的区别很大，暴力会超时。。思想是反过来，逐个去找丑数
 */
public class MathLC264 {

    public static void main(String[] args) {
        MathLC264 instance = new MathLC264();

        int result = instance.nthUglyNumber(1352);

        System.out.println(result);
    }

    public int nthUglyNumber(int n) {
        int[] nums = new int[]{2, 3, 5};
        Set<Long> set = new HashSet<>();
        Queue<Long> heap = new PriorityQueue<>();
        set.add(1L);
        heap.add(1L);
        long maxUgly = -1;
        // 反过来想，逐个寻找丑数，一个一个往上乘，借助set去重
        for (int i = 1; i <= n; i++) {
            maxUgly = heap.poll();
            for (int num : nums) {
                long curMax = num * maxUgly;
                if (!set.contains(curMax)) {
                    set.add(curMax);
                    heap.add(curMax);
                }
            }
        }
        return (int) maxUgly;
    }
}
