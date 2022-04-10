package algo.string;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/unique-morse-code-words/
 * <p>
 * 2022-04-10 每日一题
 * 通过率80%的题一击即中也没什么可炫耀的..
 */
public class StringLC804 {

    public static void main(String[] args) {
        StringLC804 instance = new StringLC804();

//        int result = instance.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"});
        int result = instance.uniqueMorseRepresentations(new String[]{"a"});

        System.out.println(result);
    }

    public int uniqueMorseRepresentations(String[] words) {
        String[] mos = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder encodeWord = new StringBuilder();
            for (char c : word.toCharArray()) {
                encodeWord.append(mos[c - 'a']);
            }
            set.add(encodeWord.toString());
        }

        return set.size();
    }
}
