package algo.string;

/**
 * https://leetcode-cn.com/problems/robot-return-to-origin/
 */
public class StringLC657 {

    public boolean judgeCircle(String moves) {
        if (moves == null || "".equals(moves)) {
            return true;
        }

        int lc = 0;
        int rc = 0;
        int uc = 0;
        int dc = 0;
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);

            if ('L' == c) {
                lc++;
            } else if ('R' == c) {
                rc++;
            } else if ('U' == c) {
                uc++;
            } else if ('D' == c) {
                dc++;
            }
        }

        return lc == rc && dc == uc;
    }
}
