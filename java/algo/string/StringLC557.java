package algo.string;

/**
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 */
public class StringLC557 {

    public static void main(String[] args) {
        StringLC557 instance = new StringLC557();
        String res = instance.reverseWords("");
        System.out.println(res);
    }

    public String reverseWords(String s) {
        if (s == null || s.equals("")) return s;
        int lastIndex = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                for (int j = i - 1; j >= lastIndex; j--) {
                    sb.append(s.charAt(j));
                }
                if (s.charAt(lastIndex) != ' ') {
                    sb.append(" ");
                }
                lastIndex = i;
            }
        }

        for (int i = s.length() - 1; i > lastIndex; i--) {
            sb.append(s.charAt(i));
        }
        if (s.charAt(lastIndex) != ' ') {
            sb.append(s.charAt(lastIndex));
        }

        return sb.toString();
    }
}
