package com.example.microServicioProyectoIntegrador.Services;


import com.example.microServicioProyectoIntegrador.Models.Customer;
import com.example.microServicioProyectoIntegrador.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCustomer {

    private CustomerRepository customerRepository;


    @Autowired
    public ServiceCustomer(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public void addCustomer (Customer customer){
        this.customerRepository.save(customer);
    }
    public void updateCustomer(Customer customer){
        this.customerRepository.save(customer);
    }

    public void deleteCustomer(long cedula){
        this.customerRepository.deleteById(cedula);
    }
//
    public Customer getCustomerCedula(long cedula){
        return  this.customerRepository.getReferenceById(cedula);
    }

    public List<Customer> getCustomer(){
        return  this.customerRepository.findAll();
    }

}
