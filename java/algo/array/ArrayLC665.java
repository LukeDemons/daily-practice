package algo.array;

/**
 * https://leetcode-cn.com/problems/non-decreasing-array/
 * <p>
 * 2021-02-07 每日一题
 * 看似easy实则不好想全，首先是不能只考虑相邻两个点，其次是不能数组值简单覆盖，要整体 非递减
 */
public class ArrayLC665 {

    public static void main(String[] args) {
        ArrayLC665 instance = new ArrayLC665();

//        boolean result = instance.checkPossibility(new int[]{4, 2, 1});
//        boolean result = instance.checkPossibility(new int[]{3, 4, 2, 3});
//        boolean result = instance.checkPossibility(new int[]{5, 7, 1, 8});
        boolean result = instance.checkPossibility(new int[]{5, 7, 6, 8});

        System.out.println(result);
    }

    public boolean checkPossibility(int[] nums) {
        int errCnt = 0;
        for (int i = 1; i < nums.length; i++) {
            // 不能只考虑相邻的两个点，否则两个单调递增就绕过去了
            if (nums[i] < nums[i - 1]) {
                errCnt++;
                if (errCnt > 1) {
                    return false;
                }
                if (i == 1) {
                    continue;
                }
                // 调整i或者调整i-1，都可能能满足整体 非递减；当i<i-2时说明i太小了调大i为i-1；当i>i-2时说明i还行，调小i-1为i-2
                if (nums[i] < nums[i - 2]) {
                    nums[i] = nums[i - 1];
                } else {
                    nums[i - 1] = nums[i - 2];
                }
            }
        }
        return true;
    }
}
