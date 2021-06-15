package algo.binary_search;

/**
 * https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/
 * <p>
 * 2021-06-15 每日一题
 * 3年前做过，简单二分，但是要注意边界情况
 */
public class BinarySearchLC852 {

    public static void main(String[] args) {
        BinarySearchLC852 instance = new BinarySearchLC852();

//        int result = instance.peakIndexInMountainArray(new int[]{24, 69, 100, 99, 79, 78, 67, 36, 26, 19});
        int result = instance.peakIndexInMountainArray(new int[]{18, 29, 38, 59, 98, 100, 99, 98, 90});

        System.out.println(result);
    }

    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + right >>> 1;
            if (thirdPoint(arr, mid) == 0) {
                return mid;
            } else if (thirdPoint(arr, mid) == 1) {
                // 这里必须加1，因为thirdPoint方法可以判断出来mid一定不是峰顶
                left = mid + 1;
            } else if (thirdPoint(arr, mid) == -1) {
                right = mid - 1;
            }
        }
        return left;
    }

    /**
     * 递增返回1；递减返回-1；中间返回0
     */
    private int thirdPoint(int[] arr, int index) {
        if (index < 0 || index > arr.length) {
            return -2;
        }
        if (index == 0 || (arr[index - 1] < arr[index] && arr[index] < arr[index + 1])) {
            return 1;
        }
        if (index == arr.length - 1 || (arr[index - 1] > arr[index] && arr[index] > arr[index + 1])) {
            return -1;
        }
        if (arr[index - 1] < arr[index] && arr[index] > arr[index + 1]) {
            return 0;
        }
        return -2;
    }
}
