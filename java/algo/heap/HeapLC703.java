package algo.heap;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
 *
 * 2021-02-11 每日一题
 * 按场景想到堆这个数据结构后 题目就变得异常简单了
 */
public class HeapLC703 {

    public static void main(String[] args) {
        KthLargest instance = new KthLargest(3, new int[]{4, 5, 8, 2});

        System.out.println(instance.add(3));
        System.out.println(instance.add(5));
        System.out.println(instance.add(10));
        System.out.println(instance.add(9));
        System.out.println(instance.add(4));
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
class KthLargest {

    PriorityQueue<Integer> heap = new PriorityQueue<>();
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
    }

    public int add(int val) {
        heap.add(val);
        if (heap.size() > k) {
            heap.poll();
        }
        return heap.peek();
    }
}
