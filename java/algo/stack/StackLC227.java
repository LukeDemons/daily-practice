package algo.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/basic-calculator-ii/
 * <p>
 * 2021-03-11 每日一题
 * 今天的计算器没有括号，但是多了乘除法
 */
public class StackLC227 {

    public static void main(String[] args) {
        StackLC227 instance = new StackLC227();

        int result = instance.calculate("3+2*2");

        System.out.println(result);
    }

    public int calculate(String s) {
        char[] charArr = s.toCharArray();
        int num = 0;
        char op = '+';
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < charArr.length; i++) {
            if (Character.isDigit(charArr[i])) {
                num = num * 10 + charArr[i] - '0';
            }
            // 符号 or 最后一位，都要进入计算
            if (!Character.isDigit(charArr[i]) && charArr[i] != ' ' || i == s.length() - 1) {
                if (op == '+') {
                    stack.addLast(num);
                } else if (op == '-') {
                    stack.addLast(-num);
                } else if (op == '*') {
                    stack.addLast(stack.removeLast() * num);
                } else if (op == '/') {
                    stack.addLast(stack.removeLast() / num);
                }
                num = 0;
                op = charArr[i];
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pollLast();
        }
        return result;
    }
}
