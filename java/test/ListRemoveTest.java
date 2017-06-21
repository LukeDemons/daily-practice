package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 移除列表数据测试
 * Created by yan on 2017/6/21.
 */
public class ListRemoveTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
//        wrongRemoveListTest(list);
//        removeListTest(list);
        newRemoveListTest(list);

    }

    /**
     * 使用 foreach 移除列表中的数据
     * 错误。执行到 temp 为 "2" 时移除，则 a 中只有 "1"，再进来判断会 ConcurrentModificationException
     * @param list 列表参数
     */
    @Deprecated
    private static void wrongRemoveListTest(List<String> list) {
        for (String temp : list) {
            if ("2".equals(temp)) {
                list.remove(temp);
            }
        }

        for (String temp : list) {
            System.out.println(temp);
        }
    }

    /**
     * 使用 Iterator 进行移除列表中的数据
     * 建议使用 lambda 表达式
     * @param list 列表参数
     */
    @Deprecated
    private static void removeListTest(List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String temp = it.next();
            if ("2".equals(temp)) {
                it.remove();
            }
        }

        for (String temp : list) {
            System.out.println(temp);
        }
    }

    /**
     * 使用 lambda 表达式移除列表中的数据
     * TODO 建议使用方法引用，目前不知道怎么搞。。
     * @param list 列表参数
     */
    private static void newRemoveListTest(List<String> list) {
        list.removeIf((String temp) -> "1".equals(temp));
        list.forEach(System.out::print);
    }

}
