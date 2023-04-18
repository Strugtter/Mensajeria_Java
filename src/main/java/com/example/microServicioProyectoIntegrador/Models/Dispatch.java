package com.example.microServicioProyectoIntegrador.Models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name="dispatch")
public class Dispatch {

    @Id
    @Column(name="numberGuia")
    private String numberGuia;

    @Column(name="cedulaCliente")
    private Integer cedulaCliente;

    @Column(name="cityOrigin")
    private String cityOrigin;

    @Column(name="cityDestination")
    private String cityDestination;

    @Column(name="addressDestination")
    private String addressDestination;

    @Column(name="nameRecive")
    private String nameRecive;

    @Column(name="phone")
    private long phoneRecive;

    @Column(name="deliveryTime")
    private LocalDate deliveryTime;

    @Column(name="stateDispatch")
    private String stateDispatch;



    @Column(name = "priceDispatch")
    private int priceDispatch;

    @Column(name="insuredvalue")
    private int insuredvalue;

    @Column(name="weight")
    private int weight;

    @Column(name="typePackage")
    private String typePackage;

    public Dispatch (){

    }

    public Dispatch(String numberGuia, Integer cedulaCliente, String cityOrigin, String cityDestination, String addressDestination, String nameRecive, long phoneRecive, LocalDate deliveryTime, String stateDispatch, int priceDispatch, int insuredvalue, int weight, String typePackage) {
        this.numberGuia = numberGuia;
        this.cedulaCliente = cedulaCliente;
        this.cityOrigin = cityOrigin;
        this.cityDestination = cityDestination;
        this.addressDestination = addressDestination;
        this.nameRecive = nameRecive;
        this.phoneRecive = phoneRecive;
        this.deliveryTime = deliveryTime;
        this.stateDispatch = stateDispatch;
        this.priceDispatch = priceDispatch;
        this.typePackage = typePackage;
        this.insuredvalue = insuredvalue;
        this.weight = weight;
    }

    public String getTypePackage() {
        return typePackage;
    }

    public String getNumberGuia() {
        return numberGuia;
    }

    public Integer getCedulaCliente() {
        return cedulaCliente;
    }

    public String getCityOrigin() {
        return cityOrigin;
    }

    public String getCityDestination() {
        return cityDestination;
    }

    public String getAddressDestination() {
        return addressDestination;
    }

    public String getNameRecive() {
        return nameRecive;
    }

    public long getPhoneRecive() {
        return phoneRecive;
    }

    public LocalDate getDeliveryTime() {
        return deliveryTime;
    }

    public String getStateDispatch() {
        return stateDispatch;
    }

    public int getPriceDispatch() {
        return priceDispatch;
    }


    public int getInsuredvalue() {
        return insuredvalue;
    }

    public int getWeight() {
        return weight;
    }

    public void setStateDispatch(String stateDispatch) {
        this.stateDispatch = stateDispatch;
    }
}
