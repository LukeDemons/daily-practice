package algo.array;

/**
 * https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
 *
 * 2021-01-24 每日一题
 * 道行太浅，目前只知道思路是常规实现，不知道这个和贪心、动规、并查集怎么搞到一起去=，=
 */
public class ArrayLC674 {

    public static void main(String[] args) {
        ArrayLC674 instance = new ArrayLC674();

//        int result = instance.findLengthOfLCIS(new int[]{1, 3, 5, 4, 7});
        int result = instance.findLengthOfLCIS(new int[]{2, 2, 2, 2, 2, 2});

        System.out.println(result);
    }

    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int maxLength = 1;
        int length = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                maxLength = Math.max(maxLength, length);
                length = 0;
            }
            length++;
        }
        maxLength = Math.max(maxLength, length);
        return maxLength;
    }
}
