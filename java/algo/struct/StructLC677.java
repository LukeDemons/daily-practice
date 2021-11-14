package algo.struct;

import java.util.HashMap;
import java.util.Map;

/**
 * 2021-11-14 每日一题
 * 标准trie树 class TrieNode { int val = 0; TrieNode[] next = new TrieNode[26]; }
 * <p>
 * https://leetcode-cn.com/problems/map-sum-pairs/
 */
public class StructLC677 {

    public static void main(String[] args) {

        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap"));           // return 3 (apple = 3)
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap"));           // return 5 (apple + app = 3 + 2 = 5)
    }

}


/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
class MapSum {

    class TrieNode {
        int val = 0;
        TrieNode[] next = new TrieNode[26];
    }

    TrieNode root;
    Map<String, Integer> map;

    public MapSum() {
        root = new TrieNode();
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        // 加差值而不是替换的原因：apple:3 apple:5 前面的node已经加了3，需要再加的是差值2
        int delta = val - map.getOrDefault(key, 0);
        map.put(key, val);
        TrieNode node = root;
        for (char c : key.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new TrieNode();
            }
            node = node.next[c - 'a'];
            // 每个节点的值都需要加上delta
            node.val += delta;
        }
    }

    public int sum(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                return 0;
            }
            node = node.next[c - 'a'];
        }

        return node.val;
    }
}