package com.compuwork.model; 
 
import jakarta.persistence.*; 
 
@Entity 
@DiscriminatorValue("PERMANENTE") 
public class PermanentEmployee extends Employee { 
    private Double salarioBase; 
    private String fechaContratacion; 
    private String beneficios; 
 
    public Double getSalarioBase() { return salarioBase; } 
    public void setSalarioBase(Double salarioBase) { this.salarioBase = salarioBase; } 
    public String getFechaContratacion() { return fechaContratacion; } 
    public void setFechaContratacion(String fechaContratacion) { this.fechaContratacion = fechaContratacion; } 
    public String getBeneficios() { return beneficios; } 
    public void setBeneficios(String beneficios) { this.beneficios = beneficios; } 
} 
