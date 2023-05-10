package com.example.microServicioProyectoIntegrador.Models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name="customer")
public class Customer {
    @Id
    @Column(name="cedula")
    private long cedula;

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellido")
    private String apellido;

    @Column(name="celular")
    private long celular;

    @Column(name="correoElectronico")
    private String correoElectronico;

    @Column(name="direccionResidencia")
    private String direccionResidencia;
    @Column(name="ciudad")
    private String ciudad;


    public Customer(){

    }
    public Customer(long cedula, String nombre, String apellido, long celular, String correoElectronico, String direccionResidencia, String ciudad) {

        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.correoElectronico = correoElectronico;
        this.direccionResidencia = direccionResidencia;
        this.ciudad = ciudad;
    }

    public long getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public long getCelular() {
        return celular;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getDireccionResidencia() {
        return direccionResidencia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void setDireccionResidencia(String direccionResidencia) {
        this.direccionResidencia = direccionResidencia;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
