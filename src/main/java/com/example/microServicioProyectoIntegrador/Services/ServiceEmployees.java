package com.example.microServicioProyectoIntegrador.Services;

import com.example.microServicioProyectoIntegrador.Models.Customer;
import com.example.microServicioProyectoIntegrador.Models.Employee;
import com.example.microServicioProyectoIntegrador.Repository.CustomerRepository;
import com.example.microServicioProyectoIntegrador.Repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServiceEmployees {

    private EmployeesRepository employeesRepository;


    @Autowired
    public ServiceEmployees(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    public void addEmployee (Employee employee){
        this.employeesRepository.save(employee);
    }

    public void updateEmployee(Employee employee){
        this.employeesRepository.save(employee);
    }

    public void deleteEmployee(Integer cedula){
        this.employeesRepository.deleteById(cedula);
    }

    public Employee getEmployeeCedula(Integer cedula){
        return  this.employeesRepository.getReferenceById(cedula);
    }




}
