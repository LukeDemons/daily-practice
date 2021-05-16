package algo.dfs;

/**
 * https://leetcode-cn.com/problems/word-search/
 *
 * @see algo.offer.JZ12
 */
public class DfsLC79 {

    public static void main(String[] args) {
        DfsLC79 instance = new DfsLC79();

        boolean result = instance.exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCCEE");

        System.out.println(result);
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word.toCharArray(), i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] words, int i, int j, int k) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != words[k]) {
            return false;
        }
        if (words.length - 1 == k) {
            return true;
        }
        board[i][j] = '#';
        boolean result = dfs(board, words, i, j + 1, k + 1)
                || dfs(board, words, i, j - 1, k + 1)
                || dfs(board, words, i + 1, j, k + 1)
                || dfs(board, words, i - 1, j, k + 1);
        board[i][j] = words[k];
        return result;
    }
}
