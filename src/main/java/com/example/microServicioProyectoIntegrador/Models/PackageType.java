package com.example.microServicioProyectoIntegrador.Models;


import javax.persistence.*;

@Entity
@Table(name="PackageType")
public class PackageType {


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    private int id;

    @Column(name="typePackage")
    private String typePackage;

    @Column(name="insuredvalue")
    private int insuredvalue;

    @Column(name="weight")
    private int weight;


}
