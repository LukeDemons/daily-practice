-- https://leetcode-cn.com/problems/department-highest-salary/solution/

-- 好题！要选出每个部门最高工资的，先选工资，再通过自查询拿到其他信息
select t2.name as Department, t1.name as Employee, t1.salary as Salary from (
select departmentId, name, salary from employee where (departmentId, salary) in (
select departmentId, max(salary) from employee group by departmentId
)
) t1 inner join department t2 on t1.departmentId=t2.id