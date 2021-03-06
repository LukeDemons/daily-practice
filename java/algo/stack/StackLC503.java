package algo.stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/next-greater-element-ii/
 * <p>
 * 2021-03-06 每日一题
 * 暴力击败5%，单调栈，栈里存的是没被更新答案的下标
 */
public class StackLC503 {

    public static void main(String[] args) {
        StackLC503 instance = new StackLC503();

        int[] result = instance.nextGreaterElements1(new int[]{1, 2, 1});

        System.out.println(Arrays.toString(result));
    }

    // 暴力解n2，击败5%
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length + i + 1; j++) {
                if (nums[j % nums.length] > nums[i]) {
                    result[i] = nums[j % nums.length];
                    break;
                }
            }
        }

        return result;
    }

    // 单调栈 栈里存的是没被更新答案的下标，可以解决「找最近一个比当前值大/小」的问题
    public int[] nextGreaterElements1(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums.length * 2; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % nums.length]) {
                // 把栈里的，小于当前值的下标一个一个的结果设置为当前值
                result[stack.pop()] = nums[i % nums.length];
            }
            stack.push(i % nums.length);
        }
        return result;
    }
}
