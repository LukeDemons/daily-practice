package algo.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/group-anagrams-lcci/
 * <p>
 * 2021-07-18 每日一题
 * 排序法好理解
 */
public class Interview10_02 {

    public static void main(String[] args) {
        Interview10_02 instance = new Interview10_02();

        List<List<String>> result = instance.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});

        System.out.println(result);

    }

    /**
     * 排序后相同的放到一个list里面
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            String key = String.valueOf(cs);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

}
