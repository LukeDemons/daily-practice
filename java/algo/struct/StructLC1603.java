package algo.struct;

/**
 * https://leetcode-cn.com/problems/design-parking-system/
 *
 * 2021-03-19 每日一题
 * 简单的不像easy，应该是某次周赛的第一题，没什么可说的，还是多去学一学练一练链表的题吧
 */
public class StructLC1603 {

    public static void main(String[] args) {
        ParkingSystem obj = new ParkingSystem(1, 1, 0);

        System.out.println(obj.addCar(1));
        System.out.println(obj.addCar(2));
        System.out.println(obj.addCar(3));
        System.out.println(obj.addCar(1));
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
class ParkingSystem {

    int big, medium, small;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        switch (carType) {
            case 1:
                return big-- > 0;
            case 2:
                return medium-- > 0;
            case 3:
                return small-- > 0;
        }
        return false;
    }
}
