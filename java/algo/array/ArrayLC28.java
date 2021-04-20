package algo.array;

/**
 * https://leetcode-cn.com/problems/implement-strstr/
 *
 * 2021-04-20 每日一题
 * 暴力容易，KMP直接略过了，，，，
 */
public class ArrayLC28 {

    public static void main(String[] args) {
        ArrayLC28 instance = new ArrayLC28();

//        int result = instance.strStr("abcdefg", "cde");
        int result = instance.strStr("", "");

        System.out.println(result);
    }

    public int strStr(String haystack, String needle) {
        // 对于暴力解而言，外层判断的循环跳出逻辑是难点
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            boolean flag = true;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }

        return -1;
    }
}
