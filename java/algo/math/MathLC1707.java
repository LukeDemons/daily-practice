package algo.math;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode-cn.com/problems/maximum-xor-with-an-element-from-array/
 * <p>
 * 2021-05-23 每日一题
 * @see algo.struct.StructLC421
 */
public class MathLC1707 {

    public static void main(String[] args) {
        MathLC1707 instance = new MathLC1707();

//        int[] result = instance.maximizeXor(new int[]{0, 1, 2, 3, 4}, new int[][]{{3, 1}, {1, 3}, {5, 6}});
        int[] result = instance.maximizeXor(new int[]{5, 2, 4, 6, 6, 3}, new int[][]{{12, 4}, {8, 1}, {6, 3}});

        System.out.println(Arrays.toString(result));
    }

    /**
     * 暴力解直接超时
     */
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int one = -1;
            for (int num : nums) {
                if (num > queries[i][1]) {
                    break;
                }
                one = Math.max(one, num ^ queries[i][0]);
            }
            result[i] = one;
        }
        return result;
    }

    public int[] maximizeXor1(int[] nums, int[][] queries) {
        // 使用第三位数字记录原数组的位置
        int[][] queries1 = new int[queries.length][3];
        for (int i = 0; i < queries.length; i++) {
            queries1[i][0] = queries[i][0];
            queries1[i][1] = queries[i][1];
            queries1[i][2] = i;
        }
        Arrays.sort(nums);
        // 根据第二个值排序
        Arrays.sort(queries1, Comparator.comparingInt(q -> q[1]));
        int[] result = new int[queries.length];
        Trie1707 root = new Trie1707();
        // nums中共有startIndex个值满足条件
        int startIndex = 0;
        for (int[] query : queries1) {
            while (startIndex < nums.length && nums[startIndex] <= query[1]) {
                // 将所有满足条件的值加入trie树
                root.add(nums[startIndex++]);
            }
            if (startIndex == 0) {
                result[query[2]] = -1;
            } else {
                result[query[2]] = root.findMax(query[0]);
            }
        }
        return result;
    }
}

class Trie1707 {
    Trie1707[] next = new Trie1707[2];

    public void add(int num) {
        Trie1707 root = this;
        for (int i = 30; i >= 0; i--) {
            int val = (num >> i) & 1;
            if (root.next[val] == null) {
                root.next[val] = new Trie1707();
            }
            root = root.next[val];
        }
    }

    public int findMax(int num) {
        Trie1707 root = this;
        int result = 0;
        for (int i = 30; i >= 0; i--) {
            int val = (num >> i) & 1;
            if (root.next[val ^ 1] != null) {
                result += (1 << i);
                root = root.next[val ^ 1];
            } else {
                root = root.next[val];
            }
        }
        return result;
    }
}
