package com.alisdlyc.dao;

import com.alisdlyc.pojo.Department;
import com.alisdlyc.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {

    // 模拟数据库 操作员工表
    private static Map<Integer, Employee> employees = null;
    // 获取部门的信息
    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<Integer, Employee>();

        employees.put(1001,new Employee(1001,"AA","a.qwq@qq.com",0,new Department(101,"教学部")));
        employees.put(1002,new Employee(1002,"BB","b.qwq@qq.com",1,new Department(102,"教研部")));
        employees.put(1003,new Employee(1003,"CC","c.qwq@qq.com",1,new Department(103,"运营部")));
        employees.put(1004,new Employee(1004,"DD","d.qwq@qq.com",1,new Department(104,"生活部")));
        employees.put(1005,new Employee(1005,"EE","e.qwq@qq.com",0,new Department(105,"后勤部")));
    }

    // 自增
    private static Integer initId = 1006;
    // 增加一个员工
    public void add(Employee employee){
        if (employee.getId()==null){
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartmentByid(employee.getDepartment().getId()));

        employees.put(employee.getId(),employee);

    }

    // 查询全部员工信息
    public Collection<Employee> getAll(){
        return employees.values();
    }

    // 通过id查询员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    // 通过id删除员工
    public void delete(Integer id){
        employees.remove(id);
    }
}
