package algo.bit;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/decode-xored-permutation/
 * <p>
 * 2021-05-11 每日一题
 * 原数组是前n个正整数的排列，只看奇数部分得到所有，优化就是合并循环减少变量
 */
public class BitLC1734 {

    public static void main(String[] args) {
        BitLC1734 instance = new BitLC1734();

        int[] result = instance.decode(new int[]{6, 5, 4, 6});

        System.out.println(Arrays.toString(result));
    }

    public int[] decode(int[] encoded) {
        int[] perm = new int[encoded.length + 1];

        // 原数组是前n个正整数的排列，直接得到所有perm的异或值，注意n的长度要和perm对齐
        int all = 0;
        for (int i = 1; i <= perm.length; i++) {
            all ^= i;
        }

        int encode = 0;
        // 只看奇数部分，得到除了第一个以外所有perm的异或值
        for (int i = 1; i < encoded.length; i += 2) {
            encode ^= encoded[i];
        }

        // 第一个元素等于
        perm[0] = encode ^ all;
        for (int i = 1; i < perm.length; i++) {
            perm[i] = perm[i - 1] ^ encoded[i - 1];
        }

        return perm;
    }
}
