package algo.dfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/snakes-and-ladders/
 * <p>
 * 2021-06-27 每日一题
 * 团建回来，收心
 */
public class BfsLC909 {

    public static void main(String[] args) {
        BfsLC909 instance = new BfsLC909();

//        int result = instance.snakesAndLadders(new int[][]{
//                {-1, -1, -1, -1, -1, -1},
//                {-1, -1, -1, -1, -1, -1},
//                {-1, -1, -1, -1, -1, -1},
//                {-1, 35, -1, -1, 13, -1},
//                {-1, -1, -1, -1, -1, -1},
//                {-1, 15, -1, -1, -1, -1},
//        });

        int result = instance.snakesAndLadders(new int[][]{
                {-1, -1, 19, 10, -1},
                {2, -1, -1, 6, -1},
                {-1, 17, -1, 19, -1},
                {25, -1, 20, -1, -1},
                {-1, -1, -1, -1, 15},
        });

        System.out.println(result);
    }

    public int snakesAndLadders(int[][] board) {
        int[] boardArr = buildBoardArr(board);
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> stepMap = new HashMap<>();
        queue.add(1);
        stepMap.put(1, 0);
        while (!queue.isEmpty()) {
            int curIndex = queue.poll();
            int step = stepMap.get(curIndex);
            if (curIndex == board.length * board.length) {
                return step;
            }
            // 分别移动到x+1~x+6的位置
            for (int i = 1; i <= 6; i++) {
                int newPointIndex = curIndex + i;
                if (newPointIndex <= 0 || newPointIndex > board.length * board.length) {
                    continue;
                }
                if (boardArr[newPointIndex] != -1) {
                    newPointIndex = boardArr[newPointIndex];
                }
                if (stepMap.containsKey(newPointIndex)) {
                    continue;
                }
                stepMap.put(newPointIndex, step + 1);
                queue.add(newPointIndex);
            }
        }
        return -1;
    }

    /**
     * 二维board转一维board
     */
    private int[] buildBoardArr(int[][] board) {
        int n = board.length;
        int[] boardArr = new int[n * n + 1];
        int index = 0;
        for (int i = n - 1; i >= 0; i--) {
            // 取最下方为第一行,奇数行正向,偶数行反向
            if ((n - i) % 2 == 1) {
                for (int j = 0; j < n; j++) {
                    boardArr[++index] = board[i][j];
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    boardArr[++index] = board[i][j];
                }
            }
        }
        return boardArr;
    }
}
