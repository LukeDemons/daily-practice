package algo.array;

/**
 * https://leetcode.cn/problems/first-letter-to-appear-twice/
 * <p>
 * 2023-01-01 每日一题
 * 元旦快乐：）
 */
public class ArrayLC2351 {

    public static void main(String[] args) {
        ArrayLC2351 instance = new ArrayLC2351();

        char result = instance.repeatedCharacter("abscdbaa");

        System.out.println(result);
    }

    /**
     * 判断本次出现的字符之前有没有出现过
     */
    public char repeatedCharacter(String s) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            if (map[c - 'a'] == 1) {
                return c;
            }
            map[c - 'a']++;
        }
        throw new RuntimeException();
    }
}
