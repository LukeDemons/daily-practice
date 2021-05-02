package algo.offer;

import algo.struct.StructLC232;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * <p>
 * 2021-05-02 饶一个 2stack->1queue
 * @see StructLC232 和第232题一样
 */
public class JZ09 {

    public static void main(String[] args) {
        CQueue obj = new CQueue();
        obj.appendTail(1);
        obj.appendTail(2);
        System.out.println(obj.deleteHead());
    }
}

class CQueue {

    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public CQueue() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        while (!stack2.isEmpty()) {
            stack1.addLast(stack2.pollLast());
        }
        stack1.addLast(value);
    }

    public int deleteHead() {
        while (!stack1.isEmpty()) {
            stack2.addLast(stack1.pollLast());
        }
        return stack2.isEmpty() ? -1 : stack2.pollLast();
    }
}
