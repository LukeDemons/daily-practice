package algo.array;

/**
 * https://leetcode-cn.com/problems/sum-of-unique-elements/
 * <p>
 * 2022-02-06 每日一题
 * 心血来潮 大年初六 明天上班
 */
public class ArrayLC1748 {

    public static void main(String[] args) {
        ArrayLC1748 instance = new ArrayLC1748();

        int result = instance.sumOfUnique(new int[]{1, 2, 3, 2});
//        int result = instance.sumOfUnique(new int[]{1, 1, 1});

        System.out.println(result);
    }

    public int sumOfUnique(int[] nums) {
        int result = 0;
        int[] map = new int[101];
        for (int n : nums) {
            if (map[n] == 1) {
                result -= n;
                map[n] = -1;
            }
            if (map[n] != 1 && map[n] != -1) {
                result += n;
                map[n]++;
            }
        }

        return result;
    }
}
