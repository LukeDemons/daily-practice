package algo.array;

/**
 * https://leetcode-cn.com/problems/range-sum-query-immutable/
 * <p>
 * 2021-03-01 每日一题
 * 简单的不像easy，看了题解才发现是我太天真，前缀和是dp的开始。因为一次含参构造多次计算，所以把前缀和都存起来方便后续检索
 */
public class ArrayLC303 {

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});

        System.out.println(numArray.sumRange(0, 2));
    }
}


class NumArray {
    int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        int result = 0;
        for (int x = i; x <= j; x++) {
            result += nums[x];
        }
        return result;
    }
}


class NumArray1 {
    // 前缀和
    int[] sums;

    public NumArray1(int[] nums) {
        int n = nums.length;
        sums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        // 前j项的和（含j）减去前i-1项的和（不含i），就得到了i到j都包含的情况
        return sums[j + 1] - sums[i];
    }
}