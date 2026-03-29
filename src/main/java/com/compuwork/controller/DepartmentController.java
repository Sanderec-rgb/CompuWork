package com.compuwork.controller; 
 
import com.compuwork.model.Department; 
import com.compuwork.service.DepartmentService; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.*; 
import java.util.List; 
 
@Controller 
@RequestMapping("/departments") 
public class DepartmentController { 
    @Autowired 
    private DepartmentService departmentService; 
 
    @GetMapping 
    public String listDepartments(Model model) { 
        List<Department> departments = departmentService.getAllDepartments(); 
        model.addAttribute("departments", departments); 
        return "departments"; 
    } 
} 
