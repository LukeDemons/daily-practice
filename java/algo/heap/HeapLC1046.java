package algo.heap;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/last-stone-weight/
 */
public class HeapLC1046 {

    public static void main(String[] args) {
        HeapLC1046 instance = new HeapLC1046();

        int result = instance.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1});

        System.out.println(result);
    }

    public int lastStoneWeight(int[] stones) {
        if (stones == null) {
            return 0;
        }
        if (stones.length == 1) {
            return stones[0];
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2-o1);

        for (int s : stones) {
            heap.add(s);
        }

        while (heap.size() > 1) {
            int top1 = heap.poll();
            int top2 = heap.poll();

            heap.add(Math.abs(top1 - top2));
        }

        return heap.poll();
    }
}
