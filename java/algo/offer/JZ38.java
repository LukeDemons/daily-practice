package algo.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 * <p>
 * 2021-06-22 每日一题
 * 标准回溯，着急还是写不出
 */
public class JZ38 {

    public static void main(String[] args) {
        JZ38 instance = new JZ38();

        String[] result = instance.permutation("abc");

        System.out.println(Arrays.toString(result));
    }

    Set<String> result = new HashSet<>();

    public String[] permutation(String s) {
        List<Character> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            list.add(c);
        }
        dfs("", list);
        return result.toArray(new String[0]);
    }

    // alreadyList为以选择列表，waitList为待选择列表
    public void dfs(String alreadyList, List<Character> waitList) {
        if (waitList.size() == 0) {
            result.add(alreadyList);
            return;
        }

        for (int i = 0; i < waitList.size(); i++) {
            // 做选择
            char c = waitList.remove(i);
            String subStr = alreadyList + c;
            // 回溯
            dfs(subStr, waitList);
            // 撤销选择
            waitList.add(i, c);
        }
    }
}
