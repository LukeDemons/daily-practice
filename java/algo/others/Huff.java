package algo.others;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 一块金条切成两半，是需要花费和长度数值一样的铜板的。
 * 比如长度为20的金条，不管切成长度多大的两半，都要花费20个铜板。
 * 一群人想整分整块金条，怎么分最省铜板？
 * <p>
 * 例如,给定数组{10,20,30}，代表一共三个人，
 * 整块金条长度为10+20+30=60. 金条要分成10,20,30三个部分。
 * 如果，先把长度60的金条分成10和50，花费60 再把长度50的金条分成20和30，花费50，一共花费110铜板。
 * 但是如果，先把长度60的金条分成30和30，花费60 再把长度30金条分成10和20，花费30，一共花费90铜板。
 * <p>
 * 输入一个数组返回分割的最小值。
 *
 * @author yanchuang
 * @date 2020/6/7
 */
public class Huff {
    // List 集合做法
	public static int cut(int[] arr) {
		int cost  = 0;
		List<Integer> goldList = new ArrayList<>();
        for (int i : arr) {
            goldList.add(i);
        }
		goldList.sort(Comparator.comparingInt(o -> o));
		while(goldList.size() > 1) {
			cost += (goldList.get(0) + goldList.get(1));
			goldList.add(goldList.get(0) + goldList.get(1));
			goldList.remove(0);
			goldList.remove(0);
			goldList.sort(Comparator.comparingInt(o -> o));
		}
		return cost;
	}

    //优先队列做法
    public static int cut1(int[] arr) {
        int res = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : arr) {
            queue.add(i);
        }
        while(queue.size() >= 2) {
            int temp = queue.poll() + queue.poll();
            res += temp;
            queue.add(temp);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] gold = {10, 20, 30};
        System.out.println(cut(gold));
    }

}
