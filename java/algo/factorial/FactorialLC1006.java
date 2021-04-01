package algo.factorial;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/clumsy-factorial/
 * <p>
 * 2021-04-01 每日一题
 * 和使用栈来实现计算器 有异曲同工之妙，清明看一下三叶的双栈通解！flag！
 */
public class FactorialLC1006 {

    public static void main(String[] args) {
        FactorialLC1006 instance = new FactorialLC1006();

        int result = instance.clumsy(8);

        System.out.println(result);
    }

    public int clumsy(int N) {
        Deque<Integer> stack = new LinkedList<>();
        int op = 0;
        int sum = 0;
        stack.push(N);
        for (int i = N - 1; i > 0; i--) {
            if (op == 0) {
                stack.push(stack.pop() * i);
            } else if (op == 1) {
                stack.push(stack.pop() / i);
            } else if (op == 2) {
                stack.push(i);
            } else {
                stack.push(-i);
            }
            op = (op + 1) % 4;
        }

        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

}
