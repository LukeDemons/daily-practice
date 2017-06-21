package test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 遍历 Map 测试
 * Created by yan on 2017/6/21.
 */
public class MapForeachTest {
    public static void main(String[] args) {

        // hashmap 初始大小为 initCapacity/loadFactor + 1，默认是 16/0.75+1
        Map<String, String> map = new HashMap<>(16);
        map.put("1", "1q1");
        map.put("2", "2w2");
//        iteratorForeachMap(map);
//        entrySetForeachMap(map);
        lambdaForeachMap(map);
//        keySetForeachMap(map);
//        streamForeachMap(map);
    }

    /**
     * 使用 iterator 遍历 map
     * 5.0 后建议使用 foreach 替换
     * @param map 待遍历参数
     */
    @Deprecated
    private static void iteratorForeachMap(Map<String, String> map) {
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> pair = it.next();
            System.out.println(pair.getKey() + ":" + pair.getValue());
        }
    }

    /**
     * 使用 entrySet 遍历 map
     * @param map 待遍历参数
     */
    private static void entrySetForeachMap(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    /**
     * 使用 lambda 表达式遍历 map
     * @param map 待遍历参数
     */
    private static void lambdaForeachMap(Map<String, String> map) {
        map.forEach((k, v) -> System.out.println(k + ":" + v));
    }

    /**
     * 使用 keySet 遍历 map
     * keySet 其实是遍历了 2 次，一次是转为 Iterator 对象，另一次是从 hashMap 中取出 key 所对应的 value。
     * 而 entrySet 只是遍历了一次就把 key 和 value 都放到了 entry 中，效 率更高
     * @param map 待遍历参数
     */
    @Deprecated
    private static void keySetForeachMap(Map<String, String> map) {
        for (String key : map.keySet()) {
            System.out.println(key + ":" + map.get(key));
        }
    }

    /**
     * 使用 stream api 遍历 map (parallel)
     * 普通遍历建议直接使用 lambda 表达式
     * @param map 待遍历参数
     */
    @Deprecated
    private static void streamForeachMap(Map<String, String> map) {
//        map.entrySet().stream().forEach(m -> System.out.println(m.getKey() + ":" + m.getValue()));
        map.entrySet().stream().parallel().forEach(m -> System.out.println(m.getKey() + ":" + m.getValue()));
    }

}
