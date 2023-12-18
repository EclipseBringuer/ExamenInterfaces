package com.example.exameninterfaces.entities;

import java.time.LocalDate;
import java.util.HashMap;

public class Coche {
    private String matricula;
    private String modelo;
    private Integer tarifa;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private Integer costeTotal;
    private Cliente cliente;

    public Coche(String matricula, String modelo, Integer tarifa, LocalDate fechaEntrada, LocalDate fechaSalida, Integer costeTotal, Cliente cliente) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.tarifa = tarifa;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.costeTotal = costeTotal;
        this.cliente = cliente;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getTarifa() {
        return tarifa;
    }

    public void setTarifa(Integer tarifa) {
        this.tarifa = tarifa;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Integer getCosteTotal() {
        return costeTotal;
    }

    public void setCosteTotal(Integer costeTotal) {
        this.costeTotal = costeTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Coche(){}
}
