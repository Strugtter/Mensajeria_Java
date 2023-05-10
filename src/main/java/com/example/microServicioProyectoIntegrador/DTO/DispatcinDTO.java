package com.example.microServicioProyectoIntegrador.DTO;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.time.LocalDate;

@Service
public class DispatcinDTO{



    private Long cedulaCliente;
    private String cityOrigin;
    private String cityDestination;
    private String addressDestination;
    private String nameRecive;
    private long phoneRecive;
    private int insuredvalue;
    private int weight;

    public DispatcinDTO (){

    }

    public DispatcinDTO(Long cedulaCliente, String cityOrigin, String cityDestination, String addressDestination, String nameRecive, long phoneRecive, int insuredvalue, int weight) {
        this.cedulaCliente = cedulaCliente;
        this.cityOrigin = cityOrigin;
        this.cityDestination = cityDestination;
        this.addressDestination = addressDestination;
        this.nameRecive = nameRecive;
        this.phoneRecive = phoneRecive;
        this.insuredvalue = insuredvalue;
        this.weight = weight;
    }

    public Long getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(Long cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public String getCityOrigin() {
        return cityOrigin;
    }

    public void setCityOrigin(String cityOrigin) {
        this.cityOrigin = cityOrigin;
    }

    public String getCityDestination() {
        return cityDestination;
    }

    public void setCityDestination(String cityDestination) {
        this.cityDestination = cityDestination;
    }

    public String getAddressDestination() {
        return addressDestination;
    }

    public void setAddressDestination(String addressDestination) {
        this.addressDestination = addressDestination;
    }

    public String getNameRecive() {
        return nameRecive;
    }

    public void setNameRecive(String nameRecive) {
        this.nameRecive = nameRecive;
    }

    public long getPhoneRecive() {
        return phoneRecive;
    }

    public void setPhoneRecive(long phoneRecive) {
        this.phoneRecive = phoneRecive;
    }

    public int getInsuredvalue() {
        return insuredvalue;
    }

    public void setInsuredvalue(int insuredvalue) {
        this.insuredvalue = insuredvalue;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}