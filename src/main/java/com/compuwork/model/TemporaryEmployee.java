package com.compuwork.model; 
 
import jakarta.persistence.*; 
 
@Entity 
@DiscriminatorValue("TEMPORAL") 
public class TemporaryEmployee extends Employee { 
    private Integer duracionContrato; 
    private Double tarifaPorHora; 
    private String agenciaContratante; 
 
    public Integer getDuracionContrato() { return duracionContrato; } 
    public void setDuracionContrato(Integer duracionContrato) { this.duracionContrato = duracionContrato; } 
    public Double getTarifaPorHora() { return tarifaPorHora; } 
    public void setTarifaPorHora(Double tarifaPorHora) { this.tarifaPorHora = tarifaPorHora; } 
    public String getAgenciaContratante() { return agenciaContratante; } 
    public void setAgenciaContratante(String agenciaContratante) { this.agenciaContratante = agenciaContratante; } 
} 
