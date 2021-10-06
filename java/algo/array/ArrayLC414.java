package algo.array;

/**
 * https://leetcode-cn.com/problems/third-maximum-number/
 * <p>
 * 2021-10-06 每日一题
 * 这题很简单，就注意一下Integer的最小值可能在入参里就行了
 */
public class ArrayLC414 {

    public static void main(String[] args) {
        ArrayLC414 instance = new ArrayLC414();

//        int result = instance.thirdMax(new int[]{2, 2, 3, 1});
//        int result = instance.thirdMax(new int[]{1, 2});
        int result = instance.thirdMax(new int[]{1, 2, -2147483648});

        System.out.println(result);
    }

    public int thirdMax(int[] nums) {
        long m1 = Long.MIN_VALUE, m2 = Long.MIN_VALUE, m3 = Long.MIN_VALUE;

        for (int num : nums) {
            if (num == m1 || num == m2 || num == m3) {
                continue;
            }
            if (num > m3) {
                m3 = num;
                if (m3 > m2) {
                    long tmp = m3;
                    m3 = m2;
                    m2 = tmp;
                }
                if (m2 > m1) {
                    long tmp = m1;
                    m1 = m2;
                    m2 = tmp;
                }
            }
        }

        return (int) (m3 == Long.MIN_VALUE ? m1 : m3);
    }
}
