package com.alisdlyc.dao;

import com.alisdlyc.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
// 部门dao
public class DepartmentDao {

    // 模拟数据库
    // 主键为一个整数，数据为Department
    private static Map<Integer, Department> departments = null;

    static {
        departments = new HashMap<Integer, Department>();//创建一个部门表

        departments.put(101,new Department(101,"教学部"));
        departments.put(102,new Department(102,"教研部"));
        departments.put(103,new Department(103,"运营部"));
        departments.put(104,new Department(104,"生活部"));
        departments.put(105,new Department(105,"后勤部"));
    }

    // 数据库操作
    // 获取所有部门信息
    public Collection<Department> getDepartments(){
        return departments.values();
    }

    // 通过id得到部门
    public Department getDepartmentByid(Integer id){
        return departments.get(id);
    }
}
