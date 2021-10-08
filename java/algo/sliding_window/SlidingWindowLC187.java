package algo.sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/repeated-dna-sequences/
 * <p>
 * 2021-10-08 每日一题
 * 上来就hash的方法还是挺容易的，相当于固定窗口问题，注意等于边界
 */
public class SlidingWindowLC187 {

    public static void main(String[] args) {
        SlidingWindowLC187 instance = new SlidingWindowLC187();

//        List<String> result = instance.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        List<String> result = instance.findRepeatedDnaSequences("AAAAAAAAAAA");

        System.out.println(result);
    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int length = 10;
        for (int i = 0; i <= s.length() - length; i++) {
            String subStr = s.substring(i, i + length);
            map.put(subStr, map.getOrDefault(subStr, 0) + 1);
            if (map.get(subStr) == 2) {
                result.add(subStr);
            }
        }
        return result;
    }
}
