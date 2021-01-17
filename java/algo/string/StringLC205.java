package algo.string;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/isomorphic-strings/
 */
public class StringLC205 {

    public static void main(String[] args) {
        StringLC205 instance = new StringLC205();

        boolean result = instance.isIsomorphic("aba", "cdc");

        System.out.println(result);
    }

    public boolean isIsomorphic(String s, String t) {
        int length = s.length();
        Map<Character, Character> sMap = new HashMap<>(length);
        Map<Character, Character> tMap = new HashMap<>(length);

        for (int i = 0; i < length; i++) {
            char sCur = s.charAt(i);
            char tCur = t.charAt(i);
            if ((sMap.containsKey(sCur) && sMap.get(sCur) != tCur)
                    || (tMap.containsKey(tCur) && tMap.get(tCur) != sCur)) {
                return false;
            }

            sMap.put(sCur, tCur);
            tMap.put(tCur, sCur);
        }

        return true;
    }


}
