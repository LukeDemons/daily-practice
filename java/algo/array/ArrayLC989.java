package algo.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/add-to-array-form-of-integer/
 * <p>
 * 这个题的边界情况还是挺多的，要考虑溢出、K大等情况，看似简单实际很容易WA
 * 从低到高位计算，再看K还有没有剩余数字就可以了；或者把数组直接加到K上
 */
public class ArrayLC989 {

    public static void main(String[] args) {
        ArrayLC989 instance = new ArrayLC989();

//        List<Integer> result = instance.addToArrayForm(new int[]{1, 2, 0, 0}, 34);
//        List<Integer> result = instance.addToArrayForm(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, 1);
//        List<Integer> result = instance.addToArrayForm(new int[]{0}, 23);
        List<Integer> result = instance.addToArrayForm(new int[]{1}, 23);

        System.out.println(result);
    }

    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> result = new ArrayList<>();
        for (int i = A.length - 1; i >= 0; i--) {
            K += A[i];
            result.add(K % 10);
            K /= 10;
        }

        // 把K剩下的部分搞进去
        while (K > 0) {
            result.add(K % 10);
            K /= 10;
        }
        Collections.reverse(result);
        return result;
    }

    public List<Integer> addToArrayForm2(int[] A, int K) {
        List<Integer> result = new ArrayList<>();
        for (int i = A.length - 1; i >= 0 || K > 0; i--, K /= 10) {
            // 如果数组对应的位上有值，就加到K上
            K += i >= 0 ? A[i] : 0;
            result.add(K % 10);
        }
        Collections.reverse(result);
        return result;
    }
}
