package com.example.microServicioProyectoIntegrador.Models;

public class ResponseDispatch {

    private String numberGuia;
    private String ultimoEstado;

    public ResponseDispatch(String numberGuia, String ultimoEstado) {
        this.numberGuia = numberGuia;
        this.ultimoEstado = ultimoEstado;
    }

    public String getNumberGuia() {
        return numberGuia;
    }

    public String getultimoEstado() {
        return ultimoEstado;
    }
}
