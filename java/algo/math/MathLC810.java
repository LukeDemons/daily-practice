package algo.math;

/**
 * https://leetcode-cn.com/problems/chalkboard-xor-game/
 * <p>
 * 2021-05-22 每日一题
 * 异或月，常见套路是前缀和+递推；再一个就是数据推导/找规律
 */
public class MathLC810 {

    public static void main(String[] args) {
        MathLC810 instance = new MathLC810();

        boolean result = instance.xorGame(new int[]{1, 1, 2});

        System.out.println(result);
    }

    public boolean xorGame(int[] nums) {
        if (nums.length % 2 == 0) {
            return true;
        }
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor == 0;
    }
}
