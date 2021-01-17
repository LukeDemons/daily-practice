package algo.stack;

import java.util.Stack;

/**
 * 给出的n个非负整数表示每个直方图的高度，每个直方图的宽均为1，在直方图中找到最大矩形面积
 *
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 */
public class StackLC84 {

    public static void main(String[] args) {
        StackLC84 instance = new StackLC84();

        instance.largestRectangleArea2(new int[]{2, 1, 2});
    }

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int max = 0;

        for (int i = 0; i <= heights.length; i++) {
            int nowRectangle = -1;
            if (i < heights.length) {
                nowRectangle = heights[i];
            }
            while (!stack.isEmpty() && nowRectangle <= heights[stack.peek()]) {
                int thisHeight = heights[stack.pop()];
                int thisWidth = 1;
                if (!stack.isEmpty()) {
                    thisWidth = i - stack.peek() - 1;
                }
                max = Math.max(max, thisHeight - thisWidth);
            }
            stack.push(i);
        }
        return max;
    }

    public int largestRectangleArea2(int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int maxI = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (heights[j] >= heights[i]) {
                    maxI++;
                } else {
                    break;
                }
            }
            for (int j = i + 1; j < heights.length; j++) {
                if (heights[j] >= heights[i]) {
                    maxI++;
                } else {
                    break;
                }
            }
            max = Math.max(max, maxI * heights[i]);
        }

        return max;
    }
}
