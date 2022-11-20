package algo.main;

/**
 * https://leetcode.cn/problems/find-the-highest-altitude/
 * <p>
 * 2022-11-19 每日一题
 * 非常简单
 */
public class MainLC1732 {

    public static void main(String[] args) {
        MainLC1732 instance = new MainLC1732();

        int result = instance.largestAltitude(new int[]{-5, 1, 5, 0, -7});

        System.out.println(result);
    }

    public int largestAltitude(int[] gain) {
        int max = 0;
        int cur = 0;
        for (int g : gain) {
            cur += g;
            if (cur > max) {
                max = cur;
            }
        }
        return max;
    }
}
