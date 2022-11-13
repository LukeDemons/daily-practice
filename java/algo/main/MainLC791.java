package algo.main;

/**
 * https://leetcode.cn/problems/custom-sort-string/
 * <p>
 * 2022-11-13 每日一题
 * 找寻源动力ing
 */
public class MainLC791 {

    public static void main(String[] args) {
        MainLC791 instance = new MainLC791();

        String result = instance.customSortString("cbd", "cbds");

        System.out.println(result);
    }

    /**
     * 学了一招 while中对个数--直接搞定次数
     */
    public String customSortString(String order, String s) {
        int[] cnts = new int[26];
        for (char c : s.toCharArray()) {
            cnts[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) {
            while (cnts[c - 'a']-- > 0) {
                sb.append(c);
            }
        }

        for (int i = 0; i < 26; i++) {
            while (cnts[i]-- > 0) {
                sb.append((char) (i + 'a'));
            }
        }

        return sb.toString();
    }

}
