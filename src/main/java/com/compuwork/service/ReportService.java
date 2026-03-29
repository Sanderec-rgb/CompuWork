package com.compuwork.service;

import com.compuwork.model.Employee;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ReportService {

    public Map<String, Object> generateIndividualReport(Employee employee) {
        Map<String, Object> report = new HashMap<>();
        
        if (employee != null) {
            report.put("id", employee.getId());
            report.put("empleado", employee.getNombre() + " " + employee.getApellido());
            
            Double puntuacion = employee.getPuntuacionDesempeno();
            report.put("puntuacion", puntuacion != null ? puntuacion : 0.0);
            
            String evaluacion;
            if (puntuacion == null) {
                evaluacion = "No evaluado";
            } else if (puntuacion >= 9.0) {
                evaluacion = "Excelente";
            } else if (puntuacion >= 7.0) {
                evaluacion = "Bueno";
            } else if (puntuacion >= 5.0) {
                evaluacion = "Regular";
            } else {
                evaluacion = "Necesita mejora";
            }
            report.put("evaluacion", evaluacion);
        }
        
        return report;
    }
}