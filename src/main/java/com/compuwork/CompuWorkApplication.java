package com.compuwork; 
 
import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication; 
 
@SpringBootApplication 
public class CompuWorkApplication { 
    public static void main(String[] args) { 
        SpringApplication.run(CompuWorkApplication.class, args); 
        System.out.println("========================================"); 
        System.out.println("=== CompuWork - Sistema de Recursos Humanos ==="); 
        System.out.println("Aplicacion iniciada correctamente"); 
        System.out.println("Accede en: http://localhost:8080/compuwork"); 
        System.out.println("========================================"); 
    } 
} 
