package algo.array;

/**
 * https://leetcode-cn.com/problems/longest-turbulent-subarray/
 * <p>
 * 2021-02-08 每日一题
 * 也可以算作滑动窗口，这题是完全看的答案，其实和前一天的瞻前顾后比较类似，要想清楚左右指针碰撞时怎么处理
 */
public class ArrayLC978 {

    public static void main(String[] args) {
        ArrayLC978 instance = new ArrayLC978();

//        int result = instance.maxTurbulenceSize(new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9});
//        int result = instance.maxTurbulenceSize(new int[]{9, 9, 9, 9});
        int result = instance.maxTurbulenceSize(new int[]{0, 1, 1, 0, 1, 0, 1, 1, 0, 0});

        System.out.println(result);
    }

    public int maxTurbulenceSize(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int left = 0, right = 0, result = 1;
        while (right < arr.length - 1) {
            if (left == right) {
                // 当左右指针相同时，右指针右移，左指针重复也右移
                right++;
                if (arr[left] == arr[left + 1]) {
                    left++;
                }
            } else {
                if ((arr[right - 1] < arr[right] && arr[right] > arr[right + 1])
                        || (arr[right - 1] > arr[right] && arr[right] < arr[right + 1])) {
                    // 湍流时 右指针右移
                    right++;
                } else {
                    // 不湍流时 窗口重来
                    left = right;
                }
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
