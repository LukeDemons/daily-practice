package algo.dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/palindrome-partitioning/
 * <p>
 * 2021-03-07 每日一题
 * 回溯还不太明白，目前的状态还是有的偏向记住了解法
 */
public class DfsLC131 {

    public static void main(String[] args) {
        DfsLC131 instance = new DfsLC131();

        // [["a","a","b"],["aa","b"]]
        List<List<String>> result = instance.partition("aab");

        System.out.println(result);
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        // 这里保存从根结点到叶子结点的路径
        Deque<String> stack = new ArrayDeque<>();
        dfs(s.toCharArray(), 0, s.length(), stack, result);
        return result;
    }

    /**
     * @param from   起始字符的索引
     * @param len    字符串 s 的长度，可以设置为全局变量
     * @param path   记录从根结点到叶子结点的路径
     * @param result 记录所有的结果
     */
    private void dfs(char[] charArray, int from, int len, Deque<String> path, List<List<String>> result) {
        if (from == len) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = from; i < len; i++) {
            // 因为截取字符串是消耗性能的，因此，采用传子串下标的方式判断一个子串是否是回文子串
            if (!isHuiWen(charArray, from, i)) {
                continue;
            }
            path.addLast(new String(charArray, from, i + 1 - from));
            dfs(charArray, i + 1, len, path, result);
            path.removeLast();
        }
    }

    public boolean isHuiWen(char[] charArray, int from, int to) {
        while (from < to) {
            if (charArray[from] != charArray[to]) {
                return false;
            }
            from++;
            to--;
        }
        return true;
    }
}
