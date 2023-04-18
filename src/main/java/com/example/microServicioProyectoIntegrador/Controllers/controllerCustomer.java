package com.example.microServicioProyectoIntegrador.Controllers;

import com.example.microServicioProyectoIntegrador.Models.Customer;
import com.example.microServicioProyectoIntegrador.Services.ServiceCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class controllerCustomer {


    private ServiceCustomer serviceCustomer;

    @Autowired
    public controllerCustomer(ServiceCustomer serviceCustomer) {
        this.serviceCustomer = serviceCustomer;
    }


    @PostMapping("/customer")
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer){
        this.serviceCustomer.addCustomer(customer);
        return new ResponseEntity<>("Cliente creado con éxito", HttpStatus.CREATED);
    }

    @PutMapping("/customer")
    public ResponseEntity<String> updateCustomer(@RequestBody Customer customer){
        this.serviceCustomer.updateCustomer(customer);
        return new ResponseEntity<>("Cliente Actualizado con éxito", HttpStatus.CREATED);

    }

    @DeleteMapping("/customer/{cedula}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("cedula") int cedula ){
       this.serviceCustomer.deleteCustomer(cedula);
       return new ResponseEntity<>("El Cliente con cedula "+ cedula + " fue eliminado con éxito", HttpStatus.CREATED);
    }

    @GetMapping("/customer/{cedula}")
    public Customer getCustomerCedula(@PathVariable ("cedula") int cedula){
        return this.serviceCustomer.getCustomerCedula(cedula);
    }

}
