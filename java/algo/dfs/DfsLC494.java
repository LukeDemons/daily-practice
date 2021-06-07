package algo.dfs;

/**
 * https://leetcode-cn.com/problems/target-sum/
 * <p>
 * 2021-06-07 每日一题
 * 回溯、动归；套路记不住，还需加强
 */
public class DfsLC494 {

    public static void main(String[] args) {
        DfsLC494 instance = new DfsLC494();

        int result = instance.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);

        System.out.println(result);
    }

    int count = 0;

    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums, target, 0, 0);
        return count;
    }

    private void dfs(int[] nums, int target, int index, int value) {
        if (index == nums.length) {
            if (target == value) {
                count++;
            }
            return;
        }
        dfs(nums, target, index + 1, value + nums[index]);
        dfs(nums, target, index + 1, value - nums[index]);
    }

}
