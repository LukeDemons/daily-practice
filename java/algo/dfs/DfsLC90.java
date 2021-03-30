package algo.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets-ii/
 * <p>
 * 2021-03-31 每日一题
 * 回溯经典题目，dfs大法这题是经典，后面要常练
 */
public class DfsLC90 {

    public static void main(String[] args) {
        DfsLC90 instance = new DfsLC90();

        List<List<Integer>> result = instance.subsetsWithDup(new int[]{1, 2, 2});

        System.out.println(result);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> stack = new LinkedList<>();

        Arrays.sort(nums);
        dfs(nums, 0, nums.length, result, stack);
        return result;
    }

    private void dfs(int[] nums, int begin, int length, List<List<Integer>> result, Deque<Integer> stack) {
        result.add(new ArrayList<>(stack));
        for (int i = begin; i < length; i++) {
            // 从第二个值开始判断，如果和前一个值相同，则不用加到结果中
            if (i > begin && nums[i] == nums[i - 1]) {
                continue;
            }
            stack.addLast(nums[i]);
            dfs(nums, i + 1, length, result, stack);
            stack.pollLast();
        }
    }
}
