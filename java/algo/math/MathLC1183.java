package algo.math;

/**
 * https://leetcode-cn.com/problems/day-of-the-week/
 *
 * 2022-01-03 每日一题
 * 四年一润 百年不润 四百年再润
 */
public class MathLC1183 {

    public static void main(String[] args) {
        MathLC1183 instance = new MathLC1183();

//        String result = instance.dayOfTheWeek(1, 1, 1970);
        String result = instance.dayOfTheWeek(3, 1, 2022);

        System.out.println(result);
    }

    public String dayOfTheWeek(int day, int month, int year) {
        String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
        // 因为1970.1.1是星期四，所以初始值从4 - 1开始
        int days = 3;
        for (int i = 1971; i < year; i++) {
            boolean isLeap = (i % 4 == 0 && i % 100 != 0) || i % 400 == 0;
            days += isLeap ? 366 : 365;
        }
        for (int i = 1; i < month; i++) {
            days += monthDays[i - 1];
            if (i == 2 && ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)) {
                days++;
            }
        }
        days += day;
        return week[days % 7];
    }
}
