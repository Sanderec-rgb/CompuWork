package com.compuwork.dto; 
 
import java.time.LocalDateTime; 
 
public class ReportDTO { 
    private String titulo; 
    private LocalDateTime fechaGeneracion; 
 
    public ReportDTO() { 
        this.fechaGeneracion = LocalDateTime.now(); 
    } 
 
    public String getTitulo() { return titulo; } 
    public void setTitulo(String titulo) { this.titulo = titulo; } 
    public LocalDateTime getFechaGeneracion() { return fechaGeneracion; } 
    public void setFechaGeneracion(LocalDateTime fechaGeneracion) { this.fechaGeneracion = fechaGeneracion; } 
} 
