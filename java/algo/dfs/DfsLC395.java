package algo.dfs;

/**
 * https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/
 * <p>
 * 2021-02-27 每日一题
 * 滑窗不好写，可以用分治。如果一个字符出现次数小于k，则符合要求的字符串一定被这个字符分割
 */
public class DfsLC395 {

    public static void main(String[] args) {
        DfsLC395 instance = new DfsLC395();

        int result = instance.longestSubstring("ababbc", 2);

        System.out.println(result);
    }

    public int longestSubstring(String s, int k) {
        return dfs(s, 0, s.length() - 1, k);
    }

    public int dfs(String s, int l, int r, int k) {
        if (r - l + 1 < k) {
            // 如果此时的l-r还不够k个字符，代表区间里有0个字符符合要求
            return 0;
        }
        // 记录s的l-r范围中所有字符出现的次数
        int[] cnt = new int[26];
        for (int i = l; i <= r; i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        while (l < r && cnt[s.charAt(l) - 'a'] < k) {
            l++;
        }
        while (l < r && cnt[s.charAt(r) - 'a'] < k) {
            r--;
        }
        if (r - l + 1 < k) {
            // 如果此时的l-r还不够k个字符，代表区间里有0个字符符合要求
            return 0;
        }
        for (int i = l + 1; i < r; i++) {
            if (cnt[s.charAt(i) - 'a'] < k) {
                // 以l-r中的分隔点 分别计算两个区间的longestSubstring值
                return Math.max(dfs(s, l, i - 1, k), dfs(s, i + 1, r, k));
            }
        }
        return r - l + 1;
    }
}
