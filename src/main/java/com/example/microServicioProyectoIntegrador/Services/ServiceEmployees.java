package com.example.microServicioProyectoIntegrador.Services;

import com.example.microServicioProyectoIntegrador.Models.Customer;
import com.example.microServicioProyectoIntegrador.Models.Employee;
import com.example.microServicioProyectoIntegrador.Repository.CustomerRepository;
import com.example.microServicioProyectoIntegrador.Repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


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

    public void updateEmployee(Employee employee) {
        int cedula = employee.getCedula();
        Optional<Employee> existingEmployeeOptional = employeesRepository.findById(cedula);

        if (existingEmployeeOptional.isPresent()) {
            Employee existingEmployee = existingEmployeeOptional.get();
            existingEmployee.setApellido(employee.getApellido());
            existingEmployee.setCedula(employee.getCedula());
            existingEmployee.setCelular(employee.getCelular());
            existingEmployee.setCiudad(employee.getCiudad());
            existingEmployee.setCorreoElectronico(employee.getCorreoElectronico());
            existingEmployee.setDireccionResidencia(employee.getDireccionResidencia());
            existingEmployee.setNombre(employee.getNombre());

            employeesRepository.save(existingEmployee);
        } else {
            // El cliente con la cédula especificada no existe
            throw new NoSuchElementException("El cliente no existe");
        }
    }

    ////////////////////77

    public void deleteEmployee(Integer cedula){
        this.employeesRepository.deleteById(cedula);
    }

    public Employee getEmployeeCedula(Integer cedula){
        return  this.employeesRepository.getReferenceById(cedula);
    }


    public List<Employee> getEmployee(){
        return  this.employeesRepository.findAll();
    }

}
