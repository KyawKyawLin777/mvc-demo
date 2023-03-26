package com.example.mvcdemo;

import com.example.mvcdemo.dao.EmployeeDao;
import com.example.mvcdemo.ds.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class IndexController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/employee")
    public String employeeForm(Model model) {
        model.addAttribute("employee",new Employee());
        return "employee-form";
    }

    @PostMapping("/employee")
    public String saveEmployee(Employee employee, BindingResult result) {
        if(result.hasErrors()){
            return "employee-form";
        }
        employeeDao.save(employee);
        return "redirect:/list-employees";
    }
    @GetMapping("list-employees")
    public String listEmployee(Model model){
        model.addAttribute("employees",employeeDao.findAll());
        return "list-employee";
    }


    @GetMapping({"/","/home"})
    public String index(){
        return "index";
    }
}
