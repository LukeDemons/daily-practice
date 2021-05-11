package algo.offer;

/**
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 * <p>
 * 2021-05-12 竟然和猎头今天给的题目差不多，猎头题目是找最大数的下标
 *
 * @see algo.binary_search.BinarySearchLC154
 */
public class JZ11 {

    public static void main(String[] args) {
        JZ11 instance = new JZ11();

//        int result = instance.maxArray(new int[]{3, 4, 5, 1, 2});
//        int result = instance.maxArray(new int[]{2, 2, 2, 0, 1});
        int result = instance.maxArray(new int[]{3, 3, 1});

        System.out.println(result);
    }

    /**
     * numbers[right]即为target
     */
    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;

        while (left < right) {
            int mid = left + right >>> 1;
            if (numbers[mid] < numbers[right]) {
                right = mid;
            } else if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else {
                // numbers[mid]==numbers[right] 时无法判断最小值在哪个区间
                right--;
            }
        }

        return numbers[right];
    }

    /**
     * 扩展，只过了几组数据，不确定逻辑最终正确性
     */
    public int maxArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;

        while (left < right) {
            int mid = left + right >>> 1;
            if (numbers[mid] > numbers[left]) {
                left = mid;
            } else if (numbers[mid] < numbers[left]) {
                right = mid - 1;
            } else {
                return left;
            }
        }

        return left;
    }
}
