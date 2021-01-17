package algo.string;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/count-binary-substrings/
 */
public class StringLC696 {
    public int countBinarySubstrings(String s) {
        List<Integer> counts = new ArrayList<>();

        int cnt = 1;
        for (int i = 1; i < s.length(); i++) {
            char prev = s.charAt(i - 1);
            char curr = s.charAt(i);
            if (prev == curr) {
                cnt++;
            } else {
                counts.add(cnt);
                cnt = 1;
            }
        }
        counts.add(cnt);

        int sum = 0;
        for (int i = 1; i < counts.size(); i++) {
            sum += Math.min(counts.get(i - 1), counts.get(i));
        }
        return sum;
    }

}
