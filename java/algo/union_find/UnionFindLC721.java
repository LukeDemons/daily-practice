package algo.union_find;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/accounts-merge/
 *
 * 想清楚如何使用并查集
 */
public class UnionFindLC721 {

    public static void main(String[] args) {
        UnionFindLC721 instance = new UnionFindLC721();

        List<List<String>> param = new ArrayList<>();
        List<String> l1 = new ArrayList<>();
        l1.add("John");
        l1.add("johnsmith@mail.com");
        l1.add("john_newyork@mail.com");
        param.add(l1);
        List<String> l2 = new ArrayList<>();
        l2.add("John");
        l2.add("johnsmith@mail.com");
        l2.add("john00@mail.com");
        param.add(l2);
        List<String> l3 = new ArrayList<>();
        l3.add("Mary");
        l3.add("mary@mail.com");
        param.add(l3);
        List<String> l4 = new ArrayList<>();
        l4.add("John");
        l4.add("johnnybravo@mail.com");
        param.add(l4);

        List<List<String>> result = instance.accountsMerge(param);

        System.out.println(result);
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // 键是邮箱，值是下标 不同的邮箱下标自增即可
        Map<String, Integer> emailToIndex = new HashMap<>();
        // 键是邮箱，值是用户名
        Map<String, String> emailToName = new HashMap<>();
        int emailsCount = 0;
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if (!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email, emailsCount++);
                    emailToName.put(email, name);
                }
            }
        }

        // 构造成并查集场景，开始构建、合并
        int[] parent = new int[emailsCount];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);
            for (int i = 2; i < account.size(); i++) {
                // 将第一个邮箱和后面的邮箱连到一个连通分量
                union(parent, emailToIndex.get(firstEmail), emailToIndex.get(account.get(i)));
            }
        }
        // 键是下标，值是邮箱集合
        Map<Integer, List<String>> indexToEmails = new HashMap<>();
        for (String email : emailToIndex.keySet()) {
            // 找到邮箱对应的「根下标」
            int index = find(parent, emailToIndex.get(email));
            List<String> account = indexToEmails.getOrDefault(index, new ArrayList<>());
            account.add(email);
            indexToEmails.put(index, account);
        }
        List<List<String>> merged = new ArrayList<>();
        for (List<String> emails : indexToEmails.values()) {
            Collections.sort(emails);
            List<String> account = new ArrayList<>();
            // 第一个元素 根据任意邮箱拿到用户名
            account.add(emailToName.get(emails.get(0)));
            account.addAll(emails);
            merged.add(account);
        }
        return merged;
    }

    public void union(int[] parent, int i, int j) {
        int x = find(parent, i);
        int y = find(parent, j);

        if (x < y) {
            parent[x] = y;
        } else {
            parent[y] = x;
        }
    }

    public int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }

        return parent[i];
    }
}
