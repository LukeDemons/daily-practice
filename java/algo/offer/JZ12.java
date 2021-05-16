package algo.offer;

/**
 * https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 * <p>
 * 2021-05-16 每日一题考察的太偏僻了，还是应试教育一波
 */
public class JZ12 {

    public static void main(String[] args) {
        JZ12 instance = new JZ12();

        boolean result = instance.exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCDEE");

        System.out.println(result);
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int k) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word.charAt(k)) {
            return false;
        }
        if (k == word.length() - 1) {
            return true;
        }
        // 选择走这个点
        board[i][j] = '#';
        boolean res = dfs(board, word, i + 1, j, k + 1)
                || dfs(board, word, i - 1, j, k + 1)
                || dfs(board, word, i, j + 1, k + 1)
                || dfs(board, word, i, j - 1, k + 1);
        // 走完记得把值赋回去
        board[i][j] = word.charAt(k);
        return res;
    }
}
