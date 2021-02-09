package algo.sliding_window;

public class Template {

    /**
     * 滑动窗口模版，目的是获取符合要求的窗口最大值，再根据题意找窗口最大值与其关系
     */
    public int maxWindowLength(int[] arr) {
        int n = arr.length;                     // 数组/字符串长度
        int left = 0, right = 0;                // 双指针，表示当前遍历的区间[left, right]，闭区间
        int[] map = new int[n + 1];             // 用于统计 子数组/子区间 是否有效
        int result = 0;                         // 保存最大的满足题目要求的 子数组/子串 长度
        while (right < n) {                     // 当右边的指针没有搜索到 数组/字符串 的结尾
            map[arr[right]]++;                  // 增加当前右边指针的数字 / 字符的计数
            while (windowIllegal(left, right)) {// 此时需要一直移动左指针，直至找到一个符合题意的区间
                map[map[left]]--;               // 移动左指针前需要从map中减少left位置字符的计数
                left++;                         // 真正的移动左指针，注意不能跟上面一行代码写反
            }                                   // 到 while 结束时，我们找到了一个符合题意要求的 子数组/子串
            result = Math.max(result, right - left + 1); // 需要更新结果
            right++;                            // 移动右指针，去探索新的区间
        }
        return result;
    }

    private boolean windowIllegal(int left, int right) {
        System.out.println("区间[left, right]不符合题意");
        return false;
    }

}
