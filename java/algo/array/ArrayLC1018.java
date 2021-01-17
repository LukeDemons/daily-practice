package algo.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-prefix-divisible-by-5/
 */
public class ArrayLC1018 {

    public static void main(String[] args) {
        ArrayLC1018 instance = new ArrayLC1018();

        List<Boolean> result = instance.prefixesDivBy5(new int[]{1,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,1,0,0,0,0,1,1,0,1,0,0,0,1});

        System.out.println(result);
    }

    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> result = new ArrayList<>(A.length);

        int digit = 0;
        for (int i = 0; i < A.length; i++) {
            digit = (digit * 2 + A[i]) % 5;
            result.add(digit == 0);
        }

        return result;
    }
}
