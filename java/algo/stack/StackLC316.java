package algo.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/remove-duplicate-letters/
 */
public class StackLC316 {

    public static void main(String[] args) {
        StackLC316 instance = new StackLC316();

        String result = instance.removeDuplicateLetters("bcabc");
        // 因为栈里有两个单调递增的数组，且最大的那个字符一定是在现在的位置，不然就会被弹出去；
        // 所以当可以放弃当前字符，而选用栈里的

        System.out.println(result);
    }

    public String removeDuplicateLetters(String s) {
        int length = s.length();
        char[] chars = s.toCharArray();
        // 记录了遍历过程中字母的最后一个下标
        int[] lastIndex = new int[26];
        for (int i = 0; i < length; i++) {
            lastIndex[chars[i] - 'a'] = i;
        }

        Deque<Character> stack = new ArrayDeque<>(length);
        // visited 记录栈中有的字符
        boolean[] visited = new boolean[26];

        for (int i = 0; i < length; i++) {
            // 如果在栈中出现则舍弃当前字符
            if (visited[chars[i] - 'a']) {
                continue;
            }

            // 当前字符小于栈顶 并且 后面还有栈顶这个字符 =》 移除栈顶
            while (!stack.isEmpty() && chars[i] < stack.peekLast() && lastIndex[stack.peekLast() - 'a'] > i) {
                // 在出栈入栈的时候维护visited数组
                char top = stack.removeLast();
                visited[top - 'a'] = false;
            }

            stack.addLast(chars[i]);
            visited[chars[i] - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}
