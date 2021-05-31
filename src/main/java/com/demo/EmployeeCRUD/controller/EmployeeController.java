package com.demo.EmployeeCRUD.controller;

import com.demo.EmployeeCRUD.model.Employee;
import com.demo.EmployeeCRUD.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    // home page
    @GetMapping("/")
    public String viewHomePage(){

        return "index";
    }
    
    // get all the list of employees
    @GetMapping("/getAllEmployee")
    public String getAllEMployee(Model model){
    	model.addAttribute("listEmployees", service.getAllEmployee());
        return "list_employee";
    }
    
    
    @GetMapping("/createEmployee")
    public String showNewEmployeeForm(Model model) {
        // create model attribute to bind form data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_employee";
    }
    
    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        // save employee to database
        service.saveEmployee(employee);
        return "redirect:/";
    }
    
    
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {

        // call delete employee method
        this.service.deleteEmployee(id);
        return "redirect:/";
    }
    
    
    @GetMapping("/updateEmployee/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get employee from the service
        Employee employee = service.getEmployeeById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("employee", employee);
        return "update_employee";
    }
}
