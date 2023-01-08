package algo.array;

/**
 * https://leetcode.cn/problems/counting-words-with-a-given-prefix/
 * <p>
 * 2023-01-08 每日一题
 * 没啥意思，需要 挑战-努力-成就
 */
public class ArrayLC2185 {

    public static void main(String[] args) {
        ArrayLC2185 instance = new ArrayLC2185();

        int result = instance.prefixCount(new String[]{"pay", "attention", "practice", "attend"}, "at");

        System.out.println(result);
    }

    /**
     * 计算数组中字符串的前缀满足prefix的个数
     */
    public int prefixCount(String[] words, String pref) {
        int result = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                result++;
            }
        }
        return result;
    }
}
