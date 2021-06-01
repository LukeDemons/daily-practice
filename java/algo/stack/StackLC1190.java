package algo.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses/
 * <p>
 * 2021-05-26 每日一题
 * 歪歪出生的日子题打卡
 */
public class StackLC1190 {

    public static void main(String[] args) {
        StackLC1190 instance = new StackLC1190();

        String result = instance.reverseParentheses("(ed(et(oc))el)");

        System.out.println(result);
    }

    public String reverseParentheses(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();

        for (char c : chars) {
            if (c == ')') {
                List<Character> tmpList = new ArrayList<>();
                while (!stack.isEmpty() && stack.peekLast() != '(') {
                    tmpList.add(stack.pollLast());
                }
                stack.pollLast();
                // 去除括号后 放回栈里 可以复用逻辑
                for (Character tmp : tmpList) {
                    stack.addLast(tmp);
                }
            } else {
                stack.addLast(c);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            // 最后取的时候再反过来一下就可以了
            result.append(stack.pollFirst());
        }
        return result.toString();
    }
}
