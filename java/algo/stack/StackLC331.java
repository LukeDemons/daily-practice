package algo.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree/
 * <p>
 * 2021-03-12 每日一题
 * 感觉好久没做二叉树了，这题竟然是用栈来做，不看题解没思路
 * （根左右）遇到数字就放2，代表后面要有两个叶子；不论什么值都减1，代表来了一个叶子；值为0就pop，代表处理完了
 */
public class StackLC331 {

    public static void main(String[] args) {
        StackLC331 instance = new StackLC331();

//        boolean result = instance.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#");
        boolean result = instance.isValidSerialization("9,#,4,#,#,1,#,#,2,#,6,#,#");

        System.out.println(result);
    }

    public boolean isValidSerialization(String preorder) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(1);
        for (String str : preorder.split(",")) {
            if (stack.isEmpty()) {
                // 如果栈为空，就代表着不够减一的，序列不合法
                return false;
            }
            // 将栈顶元素减一，如果栈顶元素为0了就pop出来
            stack.addLast(stack.pollLast() - 1);
            if (stack.peekLast() == 0) {
                stack.pollLast();
            }
            if (!"#".equals(str)) {
                // 数字的时候加一个2进去，供后面的两个#减一
                stack.addLast(2);
            }
        }

        return stack.size() == 0;
    }
}
