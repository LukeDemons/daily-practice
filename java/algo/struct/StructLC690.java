package algo.struct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/employee-importance/
 * <p>
 * 2021-05-01 每日一题
 * 直接暴力解，一击制胜
 */
public class StructLC690 {

    public static void main(String[] args) {
        StructLC690 instance = new StructLC690();

        int result = instance.getImportance(Arrays.asList(
                new Employee(1, 5, Arrays.asList(2, 3)),
                new Employee(2, 3, new ArrayList<>()),
                new Employee(3, 3, new ArrayList<>())),
                1
        );

        System.out.println(result);
    }

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.id, employee);
        }
        return sumImportance(employeeMap, id);
    }

    private int sumImportance(Map<Integer, Employee> employeeMap, int id) {
        int result = employeeMap.get(id).importance;
        for (Integer subordinate : employeeMap.get(id).subordinates) {
            result += sumImportance(employeeMap, subordinate);
        }
        return result;
    }
}

/**
 * Definition for Employee.
 */
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;

    public Employee(int id, int importance, List<Integer> subordinates) {
        this.id = id;
        this.importance = importance;
        this.subordinates = subordinates;
    }
}