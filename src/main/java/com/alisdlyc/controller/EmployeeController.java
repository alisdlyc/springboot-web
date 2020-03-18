package com.alisdlyc.controller;

import com.alisdlyc.dao.DepartmentDao;
import com.alisdlyc.dao.EmployeeDao;
import com.alisdlyc.pojo.Department;
import com.alisdlyc.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {


    @Autowired
    DepartmentDao departmentDao;

    @Autowired
    EmployeeDao employeeDao;
    @RequestMapping("/empy")
    public String list(Model model){
        model.addAttribute("empy",employeeDao.getAll());
        return "empy/list";
    }

    @GetMapping("/emp")
    public String toAddpage(Model model){
        // 需要查出部门的信息
        Collection<Department> departments = this.departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "empy/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee){
        // 添加员工的信息
        employeeDao.add(employee);
        return "redirect:/empy";
    }

    // 链接形式为getmapping
    @GetMapping("/update/{id}")
    public String toUpdate(@PathVariable("id")Integer id,Model model){
        // 需要查出原来的数据
//        Integer id = 1001;
        Employee employee =  employeeDao.getEmployeeById(id);
        // 需要查出部门的信息

        Collection<Department> departments = this.departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        model.addAttribute("employee",employeeDao.getEmployeeById(id));
        System.out.println("======================================>>>>>"+employee);
        return "empy/update";
    }

    @PostMapping("/updateEmp")
    public String UpdateEmp(Employee employee){
        employeeDao.add(employee);
        return "redirect:/empy";
    }

    @GetMapping("/delete/{id}")
    public String toDelete(@PathVariable("id")Integer id){
        employeeDao.delete(id);
        return "redirect:/empy";
    }
}
