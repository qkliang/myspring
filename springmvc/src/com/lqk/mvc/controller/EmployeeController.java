package com.lqk.mvc.controller;

import com.lqk.mvc.dao.DepartmentDao;
import com.lqk.mvc.dao.EmployeeDao;
import com.lqk.mvc.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Map;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @ModelAttribute
    public void getEmployee(@RequestParam(value = "id",required = false) Integer id,Map<String,Object> map){
        if (id !=null){
            map.put("employee",employeeDao.get(id));
        }
    }

    @RequestMapping(value = "/emp",method = RequestMethod.PUT)
    public String update(Employee employee){
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    @RequestMapping(value = "/emp/{id}",method = RequestMethod.GET)
    public String input(@PathVariable("id") Integer id,Map<String,Object> map){
        map.put("employee",employeeDao.get(id));
        map.put("departments",departmentDao.getDepartments());
        return "input";
    }
    @RequestMapping(value="/emp/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id){
        System.out.println(id);
        employeeDao.delete(id);
        return "redirect:/emps";
    }

    @RequestMapping(value = "/emp",method = RequestMethod.POST)
    public String save(@Valid Employee employee, BindingResult result){
        System.out.println(employee);
        if (result.getErrorCount() > 0){
            System.out.println("出错了");
            for (FieldError error : result.getFieldErrors()){
                System.out.println(error.getField() + ":" + error.getDefaultMessage());
            }
        }else {
            employeeDao.save(employee);
        }
        return "redirect:/emps";
    }

    @RequestMapping(value = "/emp",method = RequestMethod.GET)
    public String input(Map<String,Object> map){
        map.put("departments",departmentDao.getDepartments());
        map.put("employee",new Employee());
        return "input";
    }
    @RequestMapping("/emps")
    public String list(Map<String,Object> map){
        Collection<Employee> all = employeeDao.getAll();
        map.put("employees",all);
        return "list";
    }
}
