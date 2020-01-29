package com.luv2code.springboot.thymleafdemo.controller;

import com.luv2code.springboot.thymleafdemo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.ArrayList;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private List<Employee> theEmployees;

    @PostConstruct
    private void loadData() {
        Employee empl = new Employee(1, "Leslie", "Andrews", "sadfdsf.@dfgo.com");
        Employee empl2 = new Employee(2, "Leslie2", "Andrews2", "sadfdsf.@dfgo.com");
        Employee empl3 = new Employee(3, "Leslie3", "Andrews3", "sadfdsf.@dfgo.com");
        theEmployees = new ArrayList<>();
        theEmployees.add(empl);
        theEmployees.add(empl2);
        theEmployees.add(empl3);
    }

    @GetMapping("/list")
    public String listEmployees(Model model){
        model.addAttribute("employees", theEmployees);
        return "list-employees";
    }
}
