package algo.main;

/**
 * https://leetcode.cn/problems/second-largest-digit-in-a-string/
 * <p>
 * 2022-12-03 每日一题
 * 基本白板写的
 */
public class MainLC1796 {

    public static void main(String[] args) {
        MainLC1796 instance = new MainLC1796();

        int result = instance.secondHighest("ck0777");

        System.out.println(result);
    }

    /**
     * 找到第二大的数字，考点在于相等的数字不计到second里面
     */
    public int secondHighest(String s) {
        int max = -1, secMax = -1;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') {
                continue;
            }
            int cur = c - '0';
            if (cur > max) {
                secMax = max;
                max = cur;
            } else if (cur < max && cur > secMax) {
                secMax = cur;
            }
        }

        return secMax;
    }
}
