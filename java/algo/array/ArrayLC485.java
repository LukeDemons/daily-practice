package algo.array;

/**
 * https://leetcode-cn.com/problems/max-consecutive-ones/
 * <p>
 * 2021-02-15 每日一题
 * 一次遍历，简单的不像easy。。。。
 */
public class ArrayLC485 {

    public static void main(String[] args) {
        ArrayLC485 instance = new ArrayLC485();

        int result = instance.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1});

        System.out.println(result);
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int maxCnt = 0;
        int curCnt = 0;
        for (int num : nums) {
            if (num == 1) {
                curCnt++;
            } else {
                maxCnt = Math.max(maxCnt, curCnt);
                curCnt = 0;
            }
        }
        // 如果最长连续的1在最后一个，还得比一下
        maxCnt = Math.max(maxCnt, curCnt);

        return maxCnt;
    }
}
