package algo.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/the-k-weakest-rows-in-a-matrix/
 * <p>
 * 2021-08-01 每日一题
 * 本题两个小点：二分时向上取整还是向下取整；进堆出堆的判断逻辑
 */
public class HeapLC1337 {

    public static void main(String[] args) {
        HeapLC1337 instance = new HeapLC1337();

//        int[] result = instance.kWeakestRows(new int[][]{
//                {1, 1, 0, 0, 0},
//                {1, 1, 1, 1, 0},
//                {1, 0, 0, 0, 0},
//                {1, 1, 0, 0, 0},
//                {1, 1, 1, 1, 1}}, 3);

        int[] result = instance.kWeakestRows(new int[][]{
                {1, 0, 0, 0},
                {1, 1, 1, 1},
                {1, 0, 0, 0},
                {1, 0, 0, 0}}, 2);

        System.out.println(Arrays.toString(result));
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        // 先按cnt倒排，相同的按index倒排
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0];
            }
            return b[1] - a[1];
        });
        for (int i = 0; i < mat.length; i++) {
            int rightest = findRightest(mat[i]);
            // 看最右一个是不是1，其实是兼容一下全0的情况
            int oneCnt = mat[i][rightest] == 1 ? rightest + 1 : rightest;
            // 堆满的时候，堆顶大于cnt的才需要弹出来（相等的也不用弹，后面相等的直接进不去堆，相当于保留了cnt相等时靠前的i）
            if (heap.size() == k && !heap.isEmpty() && heap.peek()[0] > oneCnt) {
                heap.poll();
            }
            if (heap.size() < k) {
                heap.add(new int[]{oneCnt, i});
            }
        }
        int[] result = new int[k];
        int idx = k - 1;
        while (!heap.isEmpty()) {
            result[idx--] = heap.poll()[1];
        }
        return result;
    }

    private int findRightest(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + right + 1 >>> 1;
            // 找到最后一个1的位置
            if (arr[mid] == 1) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
