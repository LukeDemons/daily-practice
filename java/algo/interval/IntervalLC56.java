package algo.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/merge-intervals/
 */
public class IntervalLC56 {

    public static void main(String[] args) {
        IntervalLC56 instance = new IntervalLC56();

        int[][] result = instance.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});

        for (int[] arr : result) {
            System.out.println(arr[0] + "," + arr[1]);
        }
    }

    public int[][] merge(int[][] intervals) {

        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        List<int[]> list = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        for (int i = 0; i < intervals.length - 1; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];

            int curLeft = intervals[i + 1][0];
            int curRight = intervals[i + 1][1];

            if (right >= curLeft) {
                list.add(new int[]{left, Math.max(right, curRight)});
                i++;
                continue;
            }
            list.add(intervals[i]);
        }

        if (list.get(list.size() - 1)[1] < intervals[intervals.length - 1][1]) {
            list.add(intervals[intervals.length - 1]);
        }

        return list.toArray(new int[list.size()][]);
    }
}
