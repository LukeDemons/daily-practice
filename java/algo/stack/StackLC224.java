package algo.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/basic-calculator/
 * <p>
 * 2021-03-10 每日一题
 * 用栈来实现，思路比较清晰，但还是细节满满，不愧为hard
 */
public class StackLC224 {

    public static void main(String[] args) {
        StackLC224 instance = new StackLC224();

        int result = instance.calculate("(1+(4+5+2)-3)+(6+8)");

        System.out.println(result);
    }

    // 栈保存左表达式的结果和运算符，在计算右表达式的结果之后，从栈中取运算符和结果，再进行计算整个表达式的结果。
    public int calculate(String s) {
        int res = 0, num = 0, sign = 1;
        Deque<Integer> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // 如果当前字符是一个数字，则用num进行记录，但当前有可能是一个>9的数字，所以需要num = num * 10 + c - '0'
                num = 10 * num + c - '0';
            } else if (c == '+' || c == '-') {
                res += sign * num;
                // 将num置为0，用来存放当前符号(+/-)之后的数字
                num = 0;
                if (c == '+') {
                    sign = 1;
                } else {
                    sign = -1;
                }
            } else if (c == '(') {
                stack.addLast(res);
                stack.addLast(sign);
                res = 0;
                sign = 1;
            } else if (c == ')') {
                res += sign * num;
                num = 0;
                res *= stack.pollLast();
                res += stack.pollLast();
            }
        }

        res += sign * num;
        return res;
    }
}
