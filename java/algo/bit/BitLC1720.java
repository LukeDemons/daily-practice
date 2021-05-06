package algo.bit;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/decode-xored-array/
 *
 * 2021-05-06 每日一题
 * 这题的重点就在于 a^b=c ---两边同时异或b---> a=c^b
 */
public class BitLC1720 {

    public static void main(String[] args) {
        BitLC1720 instance = new BitLC1720();

        int[] result = instance.decode(new int[]{6,2,7,3}, 4);

        System.out.println(Arrays.toString(result));
    }

    public int[] decode(int[] encoded, int first) {
        int[] result = new int[encoded.length + 1];
        result[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            result[i + 1] = encoded[i] ^ result[i];
        }

        return result;
    }
}


// 一个值与自身的异或总是为0 ------ x ^ x = 0
// 一个值与0异或等于本身    ------ x ^ 0 = x
// 可交换性               ------ a ^ b = b ^ a
// 可结合性               ------ (a ^ b) ^ c = a ^ (b ^ c)