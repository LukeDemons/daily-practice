package algo.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/flipping-an-image/
 * <p>
 * 2021-02-24 每日一题
 * 今天这个easy没啥意思，异或：两值相同就是0，两值不同就是1
 */
public class ArrayLC832 {

    public static void main(String[] args) {
        ArrayLC832 instance = new ArrayLC832();

//        int[][] result = instance.flipAndInvertImage1(new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}});
        int[][] result = instance.flipAndInvertImage1(new int[][]{{1, 1, 0, 1}, {1, 0, 1, 1}, {0, 0, 0, 1}});

        System.out.println(Arrays.deepToString(result));
    }

    public int[][] flipAndInvertImage(int[][] A) {
        for (int[] arr : A) {
            int len = arr.length;
            // 先翻转，两个操作一起做时要注意中间节点不能重复处理
            for (int i = 0; i < len / 2; i++) {
                int tmp = arr[i];
                arr[i] = arr[len - i - 1];
                arr[len - i - 1] = tmp;
            }
            // 再反转，这里也可以用 1-arr[i]
            for (int i = 0; i < len; i++) {
                arr[i] = arr[i] == 0 ? 1 : 0;
            }
        }

        return A;
    }

    public int[][] flipAndInvertImage1(int[][] A) {
        for (int[] arr : A) {
            int len = arr.length;
            // 先翻转再反转，注意第二步不能重复处理元素
            for (int i = 0; i < len / 2 + 1; i++) {
                if (len % 2 == 0 && i == len / 2) {
                    continue;
                }
                int tmp = arr[i];
                arr[i] = 1 - arr[len - i - 1];
                arr[len - i - 1] = 1 - tmp;
            }
        }

        return A;
    }
}
