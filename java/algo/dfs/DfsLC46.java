package algo.dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/
 * 回溯算法经典示例
 * https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
 */
public class DfsLC46 {

    public static void main(String[] args) {
        DfsLC46 instance = new DfsLC46();

        List<List<Integer>> result = instance.permute(new int[]{1, 2, 3});

        System.out.println(result);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, nums.length, 0, new boolean[nums.length], new ArrayDeque<>(), result);
        return result;
    }

    public void dfs(int[] nums, int length, int depth, boolean[] used, Deque<Integer> path, List<List<Integer>> result) {
        if (depth == length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < length; i++) {
            // 多加一个状态，空间换时间，判断第i个数字是否被使用了
            if (used[i]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, length, depth + 1, used, path, result);
            used[i] = false;
            path.removeLast();
        }
    }
}
