package algo.string;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 */
public class StringLC387 {

    public static void main(String[] args) {
        StringLC387 instance = new StringLC387();

        System.out.println(instance.firstUniqChar("leetcode"));
        System.out.println(instance.firstUniqChar("loveleetcode"));
    }

    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        Map<Character, Integer> cntMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            Integer cnt = cntMap.get(c);
            if (cnt == null) {
                cnt = 0;
            }
            cntMap.put(c, cnt + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (cntMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return 0;
    }
}
