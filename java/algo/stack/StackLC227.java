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

        int result = instance.calculate(" 3+5 / 2 ");

        System.out.println(result);
    }

    //FIXME 还没ac
    public int calculate(String s) {
        s = s.replace(" ", "");
        char[] charArr = s.toCharArray();
        int num = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < charArr.length; i++) {
            if (Character.isDigit(charArr[i])) {
                num = num * 10 + charArr[i] - '0';
            } else if (i == s.length() - 1) {
                if (charArr[i] == '+') {
                    stack.addLast(charArr[i] - '0');
                } else if (charArr[i] == '-') {
                    stack.addLast(-(charArr[i] - '0'));
                } else if (charArr[i] == '*') {
                    stack.addLast(stack.removeLast() * num);
                } else if (charArr[i] == '/') {
                    stack.addLast(stack.removeLast() / num);
                }
                num = 0;
            }
        }

        int result = 0, size = stack.size();
        for (int i = 0; i < size; i++) {
            result += stack.removeLast();
        }
        return result;
    }
}
