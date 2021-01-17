package algo.interval;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode-cn.com/problems/non-overlapping-intervals/
 */
public class IntervalLC435 {

    public static void main(String[] args) {
        IntervalLC435 instance = new IntervalLC435();

        int result = instance.eraseOverlapIntervals(new int[][]{});

        System.out.println(result);
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // 区间题没思路就按左值排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int length = intervals.length;
        int nonOverlap = 1;
        int right = intervals[0][1];

        for (int i = 1; i < length; i++) {
            // 如果后面区间的左节点大于等于right，代表不重叠，并且更新right
            if (intervals[i][0] >= right) {
                nonOverlap++;
                right = intervals[i][1];
            }
        }

        return length - nonOverlap;
    }
}
