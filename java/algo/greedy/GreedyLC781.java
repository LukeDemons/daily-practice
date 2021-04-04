package algo.greedy;

/**
 * https://leetcode-cn.com/problems/rabbits-in-forest/
 * <p>
 * 2021-04-04 每日一题
 * 完全没思路，看了题解之后都不太容易理解
 */
public class GreedyLC781 {

    public static void main(String[] args) {
        GreedyLC781 instance = new GreedyLC781();

        int result = instance.numRabbits(new int[]{1,1,2});

        System.out.println(result);
    }

    /**
     * 如果有兔子回答过了，容量减一；
     * 如果第一次遇到回答answer的兔子或者上次回答兔子的容量用完了，就计数(answer个别的颜色和自己)并还允许answer个兔子这么回答
     */
    public int numRabbits(int[] answers) {
        int[] counts = new int[1000]; // 回答计数数组
        int result = 0;
        for (int answer : answers) {
            if (counts[answer] > 0) {
                // 无效回答：该回答有兔子答过了，重复回答，抵消1个计数
                counts[answer]--;
            } else {
                // 有效回答：目前该回答没有答过（或者虽然答过，但已全部抵消），计数，并累加兔子数量
                result += (answer + 1); // 累加answer+1只
                counts[answer] = answer; // 记录answer，表明还可以允许多少只兔子给出相同的answer
            }
        }
        return result;
    }
}
