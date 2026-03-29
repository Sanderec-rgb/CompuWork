package com.compuwork.controller;

import com.compuwork.model.Employee;
import com.compuwork.service.EmployeeService;
import com.compuwork.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private EmployeeService employeeService;
    
    @Autowired
    private ReportService reportService;
    
    @GetMapping
    public String showReports(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        List<Map<String, Object>> reports = new ArrayList<>();
        
        for (Employee emp : employees) {
            Map<String, Object> report = reportService.generateIndividualReport(emp);
            reports.add(report);
        }
        
        model.addAttribute("reports", reports);
        model.addAttribute("totalEmpleados", employees.size());
        
        // Calcular promedio de puntuaciones
        double promedio = employees.stream()
            .mapToDouble(e -> e.getPuntuacionDesempeno() != null ? e.getPuntuacionDesempeno() : 0.0)
            .average()
            .orElse(0.0);
        model.addAttribute("promedioGeneral", promedio);
        
        return "reports";
    }
}