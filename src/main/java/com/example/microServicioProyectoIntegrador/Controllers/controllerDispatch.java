package com.example.microServicioProyectoIntegrador.Controllers;

import com.example.microServicioProyectoIntegrador.DTO.DispatchDTO;
import com.example.microServicioProyectoIntegrador.Exception.ChangeState;
import com.example.microServicioProyectoIntegrador.Exception.DispatchNoValidoException;
import com.example.microServicioProyectoIntegrador.Exception.NotFoundException;
import com.example.microServicioProyectoIntegrador.Exception.RepositorioException;
import com.example.microServicioProyectoIntegrador.Models.*;
import com.example.microServicioProyectoIntegrador.Repository.CustomerRepository;
import com.example.microServicioProyectoIntegrador.Services.ServiceDispatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class controllerDispatch {




    private ServiceDispatch serviceDispatch;
    private CustomerRepository customerRepository;
    private DispatchDTO dispatchDTO;

    private ResponseDispatch responseDispatch;
    @Autowired
    public controllerDispatch(ServiceDispatch serviceDispatch, DispatchDTO dispatchDTO, CustomerRepository customerRepository) {
        this.serviceDispatch = serviceDispatch;
        this.customerRepository = customerRepository;
    }



    @PostMapping("/dispatch")
    public ResponseEntity<Object> addDispatch(@RequestBody Dispatch dispatch){
        try {
            dispatchDTO = this.serviceDispatch.addDispatch(dispatch);
            return new ResponseEntity<>(dispatchDTO, HttpStatus.CREATED);
        } catch (DispatchNoValidoException | RepositorioException e) {
            return new ResponseEntity<>("Mensaje: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/dispatch/{numberGuia}")
    public Dispatch getDispatchGuian(@PathVariable (name="numberGuia") String numberGuia){
        return this.serviceDispatch.getDispatchGuia(numberGuia);
    }


    @PutMapping("/dispatch")
    public ResponseEntity<Object> updateDispatch(@RequestBody UpdateDispatch updateDispatch) {

        try {
            ResponseDispatch dispatch = this.serviceDispatch.updateDispatch(updateDispatch);
            return new ResponseEntity<>(dispatch, HttpStatus.CREATED);
        } catch (ChangeState | NotFoundException e) {
            return new ResponseEntity<>("Mensaje: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }



    }

    @GetMapping("/dispatch")
    public ResponseEntity<Object> getFilterDispatch(@RequestParam String stateEnvio, @RequestParam int cedula){
        try {
            List<Dispatch> ListDispatch = this.serviceDispatch.getFilterDispatch(stateEnvio, cedula);;
            return new ResponseEntity<>(ListDispatch, HttpStatus.CREATED);
        } catch (NotFoundException e) {
            return new ResponseEntity<>("Mensaje: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
