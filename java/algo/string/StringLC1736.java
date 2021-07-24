package algo.string;

/**
 * https://leetcode-cn.com/problems/latest-time-by-replacing-hidden-digits/
 * <p>
 * 2021-07-24 每日一题
 * easy 重拳出击，全是if-else也可以用好三目运算符，还可以直接本地修改
 */
public class StringLC1736 {

    public static void main(String[] args) {
        StringLC1736 instance = new StringLC1736();

        String result = instance.maximumTime("2?:?0");

        System.out.println(result);
    }

    public String maximumTime(String time) {
        char[] result = new char[5];
        char first = time.split(":")[0].charAt(0);
        char second = time.split(":")[0].charAt(1);
        char third = time.split(":")[1].charAt(0);
        char fourth = time.split(":")[1].charAt(1);
        if (first != '?') {
            result[0] = first;
        } else {
            if (second > '3' && second < '9') {
                result[0] = '1';
            } else {
                result[0] = '2';
            }
        }
        if (second != '?') {
            result[1] = second;
        } else {
            if (first == '0' || first == '1') {
                result[1] = '9';
            } else {
                result[1] = '3';
            }
        }
        result[2] = ':';
        result[3] = third == '?' ? '5' : third;
        result[4] = fourth == '?' ? '9' : fourth;
        return new String(result);
    }
}
