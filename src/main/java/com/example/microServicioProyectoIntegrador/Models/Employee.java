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
@Table(name="employee")
public class Employee {

    @Id
    @Column(name="cedula")
    private int cedula;

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellido")
    private String apellido;

    @Column(name="celular")
    private long celular;

    @Column(name = "correoElectronico")
    private String correoElectronico;

    @Column(name="direccionResidencia")
    private String direccionResidencia;

    @Column(name="ciudad")
    private String ciudad;

    @Column(name="antiguedadEmpresa")
    private int antiguedadEmpresa;

    @Column(name="rh")
    private String rh;

    @Column(name="tipoEmpleado")
    private String tipoEmpleado;


    public Employee (){

    }

    public Employee(int cedula, String nombre, String apellido, long celular, String correoElectronico, String direccionResidencia, String ciudad, int antiguedadEmpresa, String rh, String tipoEmpleado) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.correoElectronico = correoElectronico;
        this.direccionResidencia = direccionResidencia;
        this.ciudad = ciudad;
        this.antiguedadEmpresa = antiguedadEmpresa;
        this.rh = rh;
        this.tipoEmpleado = tipoEmpleado;
    }

    public int getCedula() {
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

    public int getAntiguedadEmpresa() {
        return antiguedadEmpresa;
    }

    public String getRh() {
        return rh;
    }

    public String getTipoEmpleado() {
        return tipoEmpleado;
    }
}
