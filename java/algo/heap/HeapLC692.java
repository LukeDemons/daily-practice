package algo.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-words/
 * <p>
 * 2021-05-20 每日一题
 * topK一看就是堆排序，或者直接排序
 */
public class HeapLC692 {

    public static void main(String[] args) {
        HeapLC692 instance = new HeapLC692();

        List<String> result = instance.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2);
//        List<String> result = instance.topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4);

        System.out.println(result);
    }

    /**
     * 用小根堆的方式反倒要慢一点
     */
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordCnt = new HashMap<>();
        // 小根堆才能移除堆顶元素，所以最后要翻一下
        PriorityQueue<String> heap = new PriorityQueue<>(k, (a, b) -> {
            if (wordCnt.get(a).equals(wordCnt.get(b))) {
                return b.compareTo(a);
            } else {
                return wordCnt.get(a) - wordCnt.get(b);
            }
        });
        for (String word : words) {
            wordCnt.put(word, wordCnt.get(word) == null ? 1 : wordCnt.get(word) + 1);
        }
        for (String word : wordCnt.keySet()) {
            heap.add(word);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        List<String> result = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            result.add(heap.poll());
        }
        Collections.reverse(result);
        return result;
    }

    public List<String> topKFrequent1(String[] words, int k) {
        Map<String, Integer> wordCnt = new HashMap<>(words.length);
        for (String word : words) {
            wordCnt.put(word, wordCnt.getOrDefault(word, 0) + 1);
        }
        List<String> result = new ArrayList<>(wordCnt.keySet());
        result.sort((a, b) -> {
            if (wordCnt.get(a).equals(wordCnt.get(b))) {
                // 相等时大的排前面
                return a.compareTo(b);
            } else {
                // 从大到小排序
                return wordCnt.get(b) - wordCnt.get(a);
            }
        });
        return result.subList(0, k);
    }
}
