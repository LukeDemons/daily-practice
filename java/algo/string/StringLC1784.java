package algo.string;

/**
 * https://leetcode-cn.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/
 * 找了上周末(2021-03-07)的231周赛，原来周赛也有easy的可以一次过的题
 */
public class StringLC1784 {

    public static void main(String[] args) {
        StringLC1784 instance = new StringLC1784();

        boolean result = instance.checkOnesSegment("1001");

        System.out.println(result);
    }

    public boolean checkOnesSegment(String s) {
        int cnt = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) - s.charAt(i - 1) == 1) {
                cnt++;
            }
            if (cnt > 1) {
                return false;
            }
        }
        return true;
    }
}
