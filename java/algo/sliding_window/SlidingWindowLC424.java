package algo.sliding_window;

/**
 * https://leetcode-cn.com/problems/longest-repeating-character-replacement/
 * <p>
 * 2021-02-02 每日一题
 * 并查集没思路，学习一下滑动窗口。重点需要思考，什么时候扩张窗口（left不变，right++）什么时候滑动窗口（left++，right++）
 */
public class SlidingWindowLC424 {

    public static void main(String[] args) {
        SlidingWindowLC424 instance = new SlidingWindowLC424();

        int result = instance.characterReplacement("AABABBA", 1);

        System.out.println(result);
    }

    public int characterReplacement(String s, int k) {
        int maxSameSize = 0, left = 0, right = 0;
        // 数组模拟hashmap，默认初始化都是0。下标对应字母，值对应个数
        int[] map = new int[26];
        while (right < s.length()) {
            // 右指针右移的时候，将加过的字母个数与当前最大取最大值
            maxSameSize = Math.max(maxSameSize, ++map[s.charAt(right) - 'A']);
            if (maxSameSize + k < right - left + 1) {
                // 如果窗口过大，就把左指针右移，同时该字母个数减一
                map[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }

        return right - left;
    }
}
