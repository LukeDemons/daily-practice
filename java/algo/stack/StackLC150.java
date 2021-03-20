package algo.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 *
 * 2021-03-20 每日一题
 * 计算器题目还脱不开了。。。这题没带括号比较简单，但一次通过的顺利还不太好接受。。
 */
public class StackLC150 {

    public static void main(String[] args) {
        StackLC150 instance = new StackLC150();

        int result = instance.evalRPN(new String[]{"2","1","+","3","*"});

        System.out.println(result);
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String str : tokens) {
            if ("+".equals(str)) {
                int num1 = stack.pollLast();
                int num2 = stack.pollLast();
                stack.addLast(num2 + num1);
            } else if ("-".equals(str)) {
                int num1 = stack.pollLast();
                int num2 = stack.pollLast();
                stack.addLast(num2 - num1);
            } else if ("*".equals(str)) {
                int num1 = stack.pollLast();
                int num2 = stack.pollLast();
                stack.addLast(num2 * num1);
            } else if ("/".equals(str)) {
                int num1 = stack.pollLast();
                int num2 = stack.pollLast();
                stack.addLast(num2 / num1);
            } else {
                stack.addLast(Integer.parseInt(str));
            }
        }

        return stack.peekLast();
    }
}
