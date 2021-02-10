package algo.string;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/permutation-in-string/
 *
 * 2021-02-10 每日一题
 * 固定大小的滑动窗口，对数组模拟map更熟悉了一些，通过ide的提示学会了Arrays.equals，底层实现就是逐个比较
 */
public class StringLC567 {

    public static void main(String[] args) {
        StringLC567 instance = new StringLC567();

//        boolean result = instance.checkInclusion("ab", "adeqabkk");
//        boolean result = instance.checkInclusion("adc", "dcda");
        boolean result = instance.checkInclusion("ab", "a");

        System.out.println(result);
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1Map = new int[26];
        int[] s2Map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Map[s1.charAt(i) - 'a']++;
            s2Map[s2.charAt(i) - 'a']++;
        }

        int left = 0, right = s1.length();
        while (right < s2.length()) {
            if (Arrays.equals(s1Map, s2Map)) {
                return true;
            }
            s2Map[s2.charAt(left) - 'a']--;
            s2Map[s2.charAt(right) - 'a']++;

            left++;
            right = left + s1.length();
        }

        // 最后还要判断一下两个字典是否相同
        return Arrays.equals(s1Map, s2Map);
    }
}
