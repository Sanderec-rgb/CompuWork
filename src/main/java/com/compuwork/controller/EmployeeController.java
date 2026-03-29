package com.compuwork.controller;

import com.compuwork.model.PermanentEmployee;
import com.compuwork.model.Employee;
import com.compuwork.service.EmployeeService;
import com.compuwork.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;
    
    @Autowired
    private ReportService reportService;
    
    @GetMapping
    public String listEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employees";
    }
    
    @GetMapping("/new")
    public String showCreateForm() {
        return "employee-form";
    }
    
    @PostMapping
    public String createEmployee(
            @RequestParam String nombre,
            @RequestParam String apellido,
            @RequestParam String email,
            @RequestParam(required = false) String telefono,
            @RequestParam(required = false) Double puntuacionDesempeno) {
        
        PermanentEmployee employee = new PermanentEmployee();
        employee.setNombre(nombre);
        employee.setApellido(apellido);
        employee.setEmail(email);
        employee.setTelefono(telefono);
        employee.setPuntuacionDesempeno(puntuacionDesempeno);
        
        employeeService.createEmployee(employee);
        return "redirect:/employees";
    }
    
    @GetMapping("/report/{id}")
    public String viewReport(@PathVariable Long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            Map<String, Object> report = reportService.generateIndividualReport(employee);
            model.addAttribute("report", report);
        }
        return "employee-report";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }
}