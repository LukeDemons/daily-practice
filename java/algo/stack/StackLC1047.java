package algo.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
 *
 * 2021-03-09 每日一题
 * 一次通过，简单的不像easy 抠细节的话就是使用数组下标索引而不是charAt，然后准原地修改
 */
public class StackLC1047 {

    public static void main(String[] args) {
        StackLC1047 instance = new StackLC1047();

        String result = instance.removeDuplicates("abbaca");

        System.out.println(result);
    }

    public String removeDuplicates(String S) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < S.length(); i++) {
            if (stack.isEmpty() || stack.peekLast() != S.charAt(i)) {
                stack.addLast(S.charAt(i));
            } else {
                stack.pollLast();
            }
        }
        StringBuilder result = new StringBuilder();
        for (Character c : stack) {
            result.append(c);
        }
        return result.toString();
    }
}
