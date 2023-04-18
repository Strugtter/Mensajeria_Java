package com.example.microServicioProyectoIntegrador.Controllers;


import com.example.microServicioProyectoIntegrador.Models.Employee;
import com.example.microServicioProyectoIntegrador.Services.ServiceEmployees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class controllerEmployees {

    @Autowired
    private ServiceEmployees serviceEmployess;


    @PostMapping("/employees")
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee){
        this.serviceEmployess.addEmployee(employee);
        return new ResponseEntity<>("Empleado creado con éxito", HttpStatus.CREATED);
    }

    @PutMapping("/employees")
    public ResponseEntity<String> updateEmployee(@RequestBody Employee employee){
        this.serviceEmployess.updateEmployee(employee);
        return new ResponseEntity<>("Empleado Actualizado con éxito", HttpStatus.CREATED);
    }

    @DeleteMapping("/employees/{cedula}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("cedula") int cedula){
        this.serviceEmployess.deleteEmployee(cedula);
        return new ResponseEntity<>("El Empleado con cedula "+ cedula + " fue eliminado con éxito", HttpStatus.CREATED);
    }

    @GetMapping("/employees/{cedula}")
    public Employee getEmployeeCedula(@PathVariable("cedula") int cedula){
        return serviceEmployess.getEmployeeCedula(cedula);
    }
}
