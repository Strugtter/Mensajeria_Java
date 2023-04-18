package com.example.microServicioProyectoIntegrador.Models;

public class UpdateDispatch {

    private String numeroGuia;
    private String estadoEnvio;
    private int cedulaEmpleado;

    public UpdateDispatch(String numeroGuia, String estadoEnvio, int cedulaEmpleado) {
        this.numeroGuia = numeroGuia;
        this.estadoEnvio = estadoEnvio;
        this.cedulaEmpleado = cedulaEmpleado;
    }

    public String getNumeroGuia() {
        return numeroGuia;
    }

    public String getEstadoEnvio() {
        return estadoEnvio;
    }

    public int getCedulaEmpleado() {
        return cedulaEmpleado;
    }
}
