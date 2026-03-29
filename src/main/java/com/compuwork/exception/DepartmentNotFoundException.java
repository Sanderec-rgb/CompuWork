package com.compuwork.exception; 
 
public class DepartmentNotFoundException extends RuntimeException { 
 
    public DepartmentNotFoundException(Long id) { 
        super("Departamento no encontrado con ID: " + id); 
    } 
 
    public DepartmentNotFoundException(String message) { 
        super(message); 
    } 
 
    public DepartmentNotFoundException(String message, Throwable cause) { 
        super(message, cause); 
    } 
} 
