package algo.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-watch/
 * <p>
 * 2021-06-21 每日一题
 * 可以简单打表枚举，static只加载一次；也可以回溯，决定走哪步然后什么程度退出
 */
public class DfsLC401 {

    public static void main(String[] args) {
        DfsLC401 instance = new DfsLC401();

        List<String> result = instance.readBinaryWatch(8);

        System.out.println(result);
    }

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        if (turnedOn >= 9) {
            return result;
        }

        int[] nums = {8, 4, 2, 1, 32, 16, 8, 4, 2, 1};
        dfs(turnedOn, 0, nums, 0, 0, result);
        return result;
    }

    private void dfs(int turnedOn, int start, int[] nums, int hours, int minutes, List<String> result) {
        if (turnedOn == 0) {
            StringBuilder tmp = new StringBuilder();
            tmp.append(hours);
            tmp.append(":");
            if (minutes < 10) {
                tmp.append("0");
            }
            tmp.append(minutes);
            result.add(tmp.toString());
            return;
        }

        for (int i = start; i < nums.length; i++) {
            int tmpHours = i < 4 ? hours + nums[i] : hours;
            int tmpMinutes = i < 4 ? minutes : minutes + nums[i];
            if ((i < 4 && tmpHours > 11) || (i >= 4 && tmpMinutes > 59)) {
                // 剪枝
                continue;
            }

            dfs(turnedOn - 1, i + 1, nums, tmpHours, tmpMinutes, result);
        }
    }
}
