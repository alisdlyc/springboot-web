package com.alisdlyc;

import com.alisdlyc.dao.DepartmentDao;
import com.alisdlyc.dao.EmployeeDao;
import com.alisdlyc.pojo.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WebApplicationTests {
    @Autowired
    DepartmentDao departmentDao;

    @Autowired
    EmployeeDao employeeDao;

    @Test
    void contextLoads() {
        System.out.println(departmentDao.getDepartments());
        System.out.println(departmentDao.getDepartments());
        System.out.println(employeeDao.getAll().toString());
        System.out.println(employeeDao.getEmployeeById(1001).toString());
    }

}
