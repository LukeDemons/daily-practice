package algo.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/fair-candy-swap/
 * <p>
 * 2021-02-01 每日一题
 * 周一来道easy，对于数组、相等的问题要思考求和会有什么用处；另外，lc考察的都是单一知识点，所以理解题目本意也非常重要
 */
public class ArrayLC888 {

    public static void main(String[] args) {
        ArrayLC888 instance = new ArrayLC888();

        int[] result = instance.fairCandySwap(new int[]{1, 2}, new int[]{2, 3});

        System.out.println(Arrays.toString(result));
    }

    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = Arrays.stream(A).sum(), sumB = Arrays.stream(B).sum();

        for (int a : A) {
            for (int b : B) {
                if (sumA - a + b == sumB + a - b) {
                    return new int[]{a, b};
                }
            }
        }

        return null;
    }

}
