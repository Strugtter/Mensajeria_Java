package com.example.microServicioProyectoIntegrador.Repository;

import com.example.microServicioProyectoIntegrador.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<Employee, Integer> {


    Employee findByCedula (Integer cedula);
}
