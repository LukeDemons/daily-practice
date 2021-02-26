package algo.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/number-of-valid-words-for-each-puzzle/
 * <p>
 * 2021-02-26 每日一题
 * 其实我一开始想到bitmap来着，后面就直接想着暴力解了，不过bitmap在匹配的时候也不好理解，躲的过初一躲不过十五
 */
public class ArrayLC1178 {

    public static void main(String[] args) {
        ArrayLC1178 instance = new ArrayLC1178();

        List<Integer> result = instance.findNumOfValidWords(
                new String[]{"aaaa", "asas", "able", "ability", "actt", "actor", "access"},
                new String[]{"aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz"});

        System.out.println(result);
    }

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        // 先做状态压缩。每个word转换后 的数量
        Map<Integer, Integer> map = new HashMap<>();
        for (String word : words) {
            int key = 0;
            for (int i = 0; i < word.length(); i++) {
                // 就像businessType，1左移多少位代表该位置上有值
                key |= 1 << word.charAt(i) - 'a';
            }
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        // 再做匹配
        List<Integer> result = new ArrayList<>(puzzles.length);
        for (String p : puzzles) {
            char[] puzzle = p.toCharArray();
            result.add(dfs(puzzle, 1, map, 1 << puzzle[0] - 'a'));// 首字符必选
        }
        return result;
    }

    // 使用dfs在子集中寻找符合条件的个数
    public int dfs(char[] puzzle, int idx, Map<Integer, Integer> map, int key) {
        if (idx == puzzle.length) return map.getOrDefault(key, 0);
        // 首字符之外的字符可选可不选，两种情况
        return dfs(puzzle, idx + 1, map, key) + dfs(puzzle, idx + 1, map, key | 1 << puzzle[idx] - 'a');
    }
}
