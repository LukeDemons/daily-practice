package algo.main;

/**
 * https://leetcode.cn/problems/strong-password-checker-ii/
 * <p>
 * 2023-01-19 每日一题
 * 非常简单
 */
public class MainLC2299 {

    public static void main(String[] args) {
        MainLC2299 instance = new MainLC2299();

//        boolean result = instance.strongPasswordCheckerII("IloveLe3tcode!");
        boolean result = instance.strongPasswordCheckerII("a1A!A!A!");

        System.out.println(result);
    }

    /**
     * 至少8字符；至少包含一个小写英文；至少包含一个大写英文；至少包含一个数字；至少包含一个特殊字符；不包含两个连续字符
     */
    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) {
            return false;
        }
        char[] arr = password.toCharArray();

        boolean hasLowerCase = false;
        boolean hasUpperCase = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        Character lastOne = null;
        for (char c : arr) {
            if (lastOne != null && c == lastOne) {
                return false;
            } else {
                lastOne = c;
            }

            if (c >= 'a' && c <= 'z') {
                hasLowerCase = true;
            }

            if (c >= 'A' && c <= 'Z') {
                hasUpperCase = true;
            }

            if (c >= '0' && c <= '9') {
                hasDigit = true;
            }

            if (c == '!' || c == '@' || c == '#' || c == '$' || c == '%' || c == '^'
                    || c == '&' || c == '*' || c == '(' || c == ')' || c == '-' || c == '+') {
                hasSpecial = true;
            }
        }

        return hasLowerCase && hasUpperCase && hasDigit && hasSpecial;
    }

}
