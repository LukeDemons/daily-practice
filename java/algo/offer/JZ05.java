package algo.offer;

/**
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * <p>
 * 2021-04-24 白饶一个easy，但感觉没啥意思，，高不成低不就，，，，
 */
public class JZ05 {

    public static void main(String[] args) {
        JZ05 instance = new JZ05();

        String result = instance.replaceSpace("We are happy.");

        System.out.println(result);
    }

    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c == ' ' ? "%20" : c);
        }
        return sb.toString();
    }
}
