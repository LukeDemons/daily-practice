package algo.interval;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/remove-covered-intervals/
 */
public class IntervalLC1288 {

    public static void main(String[] args) {
        IntervalLC1288 instance = new IntervalLC1288();
        int cnt = instance.removeCoveredIntervals(new int[][]{
                new int[]{1, 4}, new int[]{3, 6}, new int[]{2, 8}
        });

        System.out.println(cnt);
    }

    public int removeCoveredIntervals(int[][] intervals) {

        // 按照起点升序排列，起点相同时降序排列
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        // 记录合并区间的起点和终点
        int left = intervals[0][0];
        int right = intervals[0][1];
        int res = 0;

        for (int i = 1; i < intervals.length; i++) {
            int curLeft = intervals[i][0];
            int curRight = intervals[i][1];

            // 情况一，找到覆盖区间
            if (right >= curRight) {
                res++;
            }
            // 情况二，找到相交区间，合并
            if (right >= curLeft) {
                right = curRight;
            }
            // 情况三，完全不相交，更新起点和终点
            if (right < curLeft) {
                left = curLeft;
                right = curRight;
            }
        }

        return intervals.length - res;
    }
}
