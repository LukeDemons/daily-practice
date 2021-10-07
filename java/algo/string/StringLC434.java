package algo.string;

/**
 * https://leetcode-cn.com/problems/number-of-segments-in-a-string/
 *
 * 2021-10-07 每日一题
 * 简单的不像easy...
 */
public class StringLC434 {

    public static void main(String[] args) {
        StringLC434 instance = new StringLC434();

        int result = instance.countSegments(", , , ,        a, eaefa");

        System.out.println(result);
    }

    public int countSegments(String s) {
        int count = 0;
        for (String item : s.split(" ")) {
            if (item.equals("")) {
                continue;
            }
            count++;
        }
        return count;
    }
}
