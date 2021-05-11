package com.demo.EmployeeCRUD.service;

import com.demo.EmployeeCRUD.model.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployee();
    public Employee getEmployeeById(Long id);
    public void saveEmployee(Employee employee);
    public void deleteEmployee(Long id);
    public void updateEmployee(Long id, Employee employee);
}
