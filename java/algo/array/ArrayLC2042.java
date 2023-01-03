package algo.array;

/**
 * https://leetcode.cn/problems/check-if-numbers-are-ascending-in-a-sentence/
 * <p>
 * 2023-01-03 每日一题
 * 通过API绕开了对数字的判断。。
 */
public class ArrayLC2042 {

    public static void main(String[] args) {
        ArrayLC2042 instance = new ArrayLC2042();

        boolean result = instance.areNumbersAscending("");

        System.out.println(result);
    }

    /**
     * 空格隔开的字符串，其中的数字是否单调递增？
     */
    public boolean areNumbersAscending(String s) {
        String[] tokens = s.split(" ");
        int max = Integer.MIN_VALUE;
        for (String token : tokens) {
            try {
                int cur = Integer.parseInt(token);
                if (cur > max) {
                    max = cur;
                } else {
                    return false;
                }
            } catch (NumberFormatException ignored) {
            }
        }
        return true;
    }
}
