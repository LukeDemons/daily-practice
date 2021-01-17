package algo.others;

import java.util.LinkedHashMap;

/**
 * @author yanchuang
 * @date 2020/7/29
 */
public class LRU {

    public static LinkedHashMap<String, Integer> mem = new LinkedHashMap<>();

    public static void main(String[] args) {

        mem.put("a", 1);
        mem.put("b", 2);
        mem.put("c", 3);
        mem.put("d", 4);
        mem.put("e", 5);

        LRU lru = new LRU();
        lru.get("b");
        lru.put("c", 6);

        System.out.println(mem);

    }

    public int get(String key) {
        if (!mem.containsKey(key)) {
            return -1;
        }

        makeRecent(key);

        return mem.get(key);
    }

    public void put(String key, Integer val) {
        if (mem.containsKey(key)) {
            mem.put(key, val);
            makeRecent(key);
            return;
        }

        if (mem.size() >= 5) {
            // 链表头部就是最久未使用的 key
            String oldestKey = mem.keySet().iterator().next();
            mem.remove(oldestKey);
        }

        mem.put(key, val);
        makeRecent(key);
    }

    public void makeRecent(String key) {
        int val = mem.get(key);
        // 删除 key，重新插入到队尾
        mem.remove(key);
        mem.put(key, val);
    }
}
