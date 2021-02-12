package algo.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/pascals-triangle-ii/
 *
 * 2021-02-12 每日一题
 * 感觉简单但也要调试好多遍才行。熟悉一点之后就好理解了，i代表层数（第i层刚好i+1个数儿），j代表每层的下标，下标为i的刚好是最后一个值
 */
public class ArrayLC119 {

    public static void main(String[] args) {
        ArrayLC119 instance = new ArrayLC119();

//        List<Integer> result = instance.getRow(4);
//        List<Integer> result = instance.getRow1(4);
        List<Integer> result = instance.getRow2(4);

        System.out.println(result);
    }

    /**
     * 感觉一半一半的算，并没有减少多少时间=，=
     */
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> allRows = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i / 2; j++) {
                if (j == 0) {
                    // 第一个值时直接填1
                    row.add(1);
                } else {
                    // 其他值时取肩上两个值的和
                    row.add(allRows.get(i - 1).get(j - 1) + allRows.get(i - 1).get(j));
                }
            }
            // 因为前面只算了一半，这里把后半部分也加一下
            List<Integer> lastHalf = new ArrayList<>(row);
            Collections.reverse(lastHalf);
            if (i % 2 == 0) {
                // 对于偶数层，要把中间重复的一个值减1
                row = row.subList(0, row.size() - 1);
            }
            row.addAll(lastHalf);
            allRows.add(row);
        }

        return allRows.get(rowIndex);
    }

    /**
     * 不记录所有行的值，只用一个集合 谓之「滚动数组」
     */
    public List<Integer> getRow1(int rowIndex) {
        List<Integer> preRow = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> curRow = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    // 第一个值时直接填1
                    curRow.add(1);
                } else {
                    // 其他值时取肩上两个值的和
                    curRow.add(preRow.get(j - 1) + preRow.get(j));
                }
            }
            preRow = curRow;
        }

        return preRow;
    }

    public List<Integer> getRow2(int rowIndex) {
        List<Integer> row = new ArrayList<>();

        // 第0层只有个1
        row.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            row.add(0);
            // 从最后一个值开始拼，前面的值刚好是上一行的值，这样又省了一个集合的空间
            for (int j = i; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }

        return row;
    }
}
