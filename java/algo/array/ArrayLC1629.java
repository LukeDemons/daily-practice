package algo.array;

/**
 * https://leetcode-cn.com/problems/slowest-key/
 * <p>
 * 2022-01-09 每日一题
 * 本是在一起5周年，却也是她姥爷去世30周年
 */
public class ArrayLC1629 {

    public static void main(String[] args) {
        ArrayLC1629 instance = new ArrayLC1629();

        char result = instance.slowestKey(new int[]{9, 29, 49, 50}, "cbcd");

        System.out.println(result);
    }

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char result = keysPressed.charAt(0);
        int maxTime = releaseTimes[0];
        for (int i = 1; i < releaseTimes.length; i++) {
            int time = releaseTimes[i] - releaseTimes[i - 1];
            char key = keysPressed.charAt(i);
            // 值大必换，值等且key大才换
            if (time > maxTime || (time == maxTime && key > result)) {
                maxTime = time;
                result = key;
            }
        }
        return result;
    }
}
