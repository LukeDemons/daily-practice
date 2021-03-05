package algo.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 * <p>
 * 2021-03-05 每日一题
 * 经典题目，两个队列模拟一个栈，两个栈模拟一个队列，看似简单细节不少，今天写法偷懒了
 */
public class StackLC232 {

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        int param_2 = obj.pop();
        System.out.println(param_2);
        int param_3 = obj.peek();
        System.out.println(param_3);
        boolean param_4 = obj.empty();
        System.out.println(param_4);
    }
}


/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
class MyQueue {
    Deque<Integer> deque;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        deque = new ArrayDeque<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        deque.addLast(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        return deque.removeFirst();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return deque.peek() == null ? 0 : deque.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return deque.isEmpty();
    }
}