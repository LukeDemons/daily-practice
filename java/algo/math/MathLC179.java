package algo.math;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/largest-number/
 * <p>
 * 2021-04-12 每日一题
 * 结果导向，更容易比较两个数字的位置。另外还要注意一些边界情况。
 */
public class MathLC179 {

    public static void main(String[] args) {
        MathLC179 instance = new MathLC179();

//        String result = instance.largestNumber(new int[]{3, 30, 34, 5, 9});
//        String result = instance.largestNumber(new int[]{999999991, 9});
        String result = instance.largestNumber(new int[]{0, 0});

        System.out.println(result);
    }

    public String largestNumber(int[] nums) {
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        // 结果导向，更容易比较两个数字的位置
        numList.sort((o1, o2) -> (int) (Long.parseLong(o2 + "" + o1) - Long.parseLong(o1 + "" + o2)));
        // 如果第一个最大的数字是0，就已经有结果了
        if (numList.get(0) == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int num : numList) {
            sb.append(num);
        }
        return sb.toString();
    }
}
