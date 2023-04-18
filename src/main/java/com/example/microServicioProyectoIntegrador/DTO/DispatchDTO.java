package com.example.microServicioProyectoIntegrador.DTO;

import org.springframework.stereotype.Service;

@Service
public class DispatchDTO {

    private String numeroGuia;
    private String stateRecive;

    public DispatchDTO() {
    }

    public DispatchDTO(String numeroGuia, String stateRecive) {
        this.numeroGuia = numeroGuia;
        this.stateRecive = stateRecive;
    }



    public String getNumeroGuia() {
        return numeroGuia;
    }

    public String getStateRecive() {
        return stateRecive;
    }
}
