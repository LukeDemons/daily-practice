package algo.stack;

/**
 * https://leetcode-cn.com/problems/132-pattern/
 * <p>
 * 2021-03-24 每日一题
 * 看起来和湍流还不太一样，这个题的132可以是不连续的。单调栈的写法还需要再写一下
 */
public class StackLC456 {

    public static void main(String[] args) {
        StackLC456 instance = new StackLC456();

//        boolean result = instance.find132pattern(new int[]{1, 2, 3, 4});
        boolean result = instance.find132pattern(new int[]{3, 1, 4, 2});

        System.out.println(result);
    }

    // n1=num n3=nums[i] n2=nums[j]
    public boolean find132pattern(int[] nums) {
        int num = nums[0];
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] > nums[j] && nums[j] > num) {
                    return true;
                }
                num = Math.min(num, nums[i]);
            }
        }
        return false;
    }
}
