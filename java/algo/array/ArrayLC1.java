package algo.array;

/**
 * https://leetcode-cn.com/problems/two-sum/
 */
public class ArrayLC1 {

    public static void main(String[] args) {
        ArrayLC1 instance = new ArrayLC1();

        int[] result = instance.twoSum(new int[]{2, 7, 11, 15}, 9);

        for (int res : result) {
            System.out.println(res);
        }
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{j, i};
                }
            }
        }
        return null;
    }
}
