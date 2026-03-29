package com.compuwork.exception; 
 
public class EmployeeNotFoundException extends RuntimeException { 
 
    public EmployeeNotFoundException(Long id) { 
        super("Empleado no encontrado con ID: " + id); 
    } 
 
    public EmployeeNotFoundException(String message) { 
        super(message); 
    } 
 
    public EmployeeNotFoundException(String message, Throwable cause) { 
        super(message, cause); 
    } 
} 
