package algo.struct;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/design-hashset/
 * <p>
 * 2021-03-13 每日一题
 * 数组加链表，注意一点就是数组中的每个值都初始化成链表就行了，不要考虑数字和链表混合存在的情况
 */
public class StructLC705 {

    public static void main(String[] args) {
        MyHashSet obj = new MyHashSet();
        obj.add(1);
        obj.add(2);
        obj.remove(1);
        System.out.println(obj.contains(1));
        System.out.println(obj.contains(2));
    }
}


/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
class MyHashSet {

    LinkedList<Integer>[] data;
    int BASE = 1024;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            data[i] = new LinkedList<>();
        }
    }

    public void add(int key) {
        int arrKey = key % BASE;
        data[arrKey].add(key);
    }

    public void remove(int key) {
        int arrKey = key % BASE;
        LinkedList<Integer> list = data[arrKey];
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == key) {
                iterator.remove();
            }
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int arrKey = key % BASE;
        return data[arrKey].contains(key);
    }
}