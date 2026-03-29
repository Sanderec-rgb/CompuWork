package com.compuwork.service;

import com.compuwork.model.Department;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class DepartmentService {
    private List<Department> departments = new ArrayList<>();
    
    public List<Department> getAllDepartments() {
        return departments;
    }
    
    public Department getDepartmentById(Long id) {
        return departments.stream().filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }
    
    public Department createDepartment(Department department) {
        department.setId((long) (departments.size() + 1));
        departments.add(department);
        return department;
    }
    
    public void deleteDepartment(Long id) {
        departments.removeIf(d -> d.getId().equals(id));
    }
}