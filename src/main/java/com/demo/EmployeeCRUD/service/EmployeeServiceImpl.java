package com.demo.EmployeeCRUD.service;

import com.demo.EmployeeCRUD.model.Employee;
import com.demo.EmployeeCRUD.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository repo;

    @Override
    public List<Employee> getAllEmployee() {
        return repo.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public void saveEmployee(Employee employee) {
        repo.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        repo.deleteById(id);
    }

	/*
	 * @Override public void updateEmployee(Long id, Employee employee) { Employee
	 * employeeFromDb = repo.findById(id).get();
	 * System.out.println(employeeFromDb.toString());
	 * employeeFromDb.setFirstName(employee.getFirstName());
	 * employeeFromDb.setLastName(employee.getLastName());
	 * employeeFromDb.setAge(employee.getAge()); repo.save(employeeFromDb); }
	 */
}
