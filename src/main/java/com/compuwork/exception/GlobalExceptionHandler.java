package com.compuwork.exception; 
 
import org.springframework.http.HttpStatus; 
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.ControllerAdvice; 
import org.springframework.web.bind.annotation.ExceptionHandler; 
import org.springframework.web.bind.annotation.ResponseStatus; 
 
@ControllerAdvice 
public class GlobalExceptionHandler { 
 
    @ExceptionHandler(EmployeeNotFoundException.class) 
    @ResponseStatus(HttpStatus.NOT_FOUND) 
    public String handleEmployeeNotFound(EmployeeNotFoundException ex, Model model) { 
        model.addAttribute("error", ex.getMessage()); 
        model.addAttribute("titulo", "Empleado no encontrado"); 
        return "error"; 
    } 
 
    @ExceptionHandler(DepartmentNotFoundException.class) 
    @ResponseStatus(HttpStatus.NOT_FOUND) 
    public String handleDepartmentNotFound(DepartmentNotFoundException ex, Model model) { 
        model.addAttribute("error", ex.getMessage()); 
        model.addAttribute("titulo", "Departamento no encontrado"); 
        return "error"; 
    } 
 
    @ExceptionHandler(Exception.class) 
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) 
    public String handleGenericException(Exception ex, Model model) { 
        model.addAttribute("error", "Ha ocurrido un error inesperado: " + ex.getMessage()); 
        model.addAttribute("titulo", "Error del sistema"); 
        return "error"; 
    } 
} 
