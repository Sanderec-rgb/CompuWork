package com.compuwork.service;

import com.compuwork.model.Employee;
import com.compuwork.model.PermanentEmployee;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class EmployeeService {
    private List<Employee> employees = new ArrayList<>();
    private Long nextId = 1L;
    
    public List<Employee> getAllEmployees() {
        return employees;
    }
    
    public Employee getEmployeeById(Long id) {
        return employees.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
    }
    
    public Employee createEmployee(Employee employee) {
        employee.setId(nextId++);
        employees.add(employee);
        return employee;
    }
    
    public void deleteEmployee(Long id) {
        employees.removeIf(e -> e.getId().equals(id));
    }
}