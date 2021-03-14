package algo.struct;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/design-hashmap/
 * <p>
 * 2021-03-14 每日一题
 * 和昨天基本一样，只不过在结果里面多存一个实际的key
 */
public class StructLC706 {

    public static void main(String[] args) {
        MyHashMap obj = new MyHashMap();

        obj.put(1, 2);
        obj.put(1, 3);
        System.out.println(obj.get(1));
        obj.put(2, 3);
        System.out.println(obj.get(2));
        obj.remove(2);
        System.out.println(obj.get(2));
    }
}


/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
class MyHashMap {

    LinkedList<int[]>[] arr;
    int BASE = 1024;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        arr = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            arr[i] = new LinkedList<>();
        }
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        LinkedList<int[]> nodeList = arr[key % 1024];
        boolean containFlag = false;
        for (int[] node : nodeList) {
            if (node[0] == key) {
                node[1] = value;
                containFlag = true;
                break;
            }
        }
        if (!containFlag) {
            nodeList.add(new int[]{key, value});
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        LinkedList<int[]> nodeList = arr[key % 1024];
        for (int[] node : nodeList) {
            if (node[0] == key) {
                return node[1];
            }
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        LinkedList<int[]> nodeList = arr[key % 1024];
        Iterator<int[]> iterator = nodeList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next()[0] == key) {
                iterator.remove();
            }
        }
    }
}