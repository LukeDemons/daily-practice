package algo.array;

/**
 * https://leetcode-cn.com/problems/minimum-elements-to-add-to-form-a-given-sum/
 * 找了上周末(2021-03-07)的231周赛，第二题思路简单越界不好调
 */
public class ArrayLC1785 {
    public static void main(String[] args) {
        ArrayLC1785 instance = new ArrayLC1785();

        int result = instance.minElements(new int[]{1, -1, 1}, 3, -4);

        System.out.println(result);
    }

    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        double delta = Math.abs(goal - sum);
        return (int) Math.ceil(delta / limit);
    }
}
