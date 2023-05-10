package com.example.microServicioProyectoIntegrador.Services;


import com.example.microServicioProyectoIntegrador.DTO.DispatchDTO;
import com.example.microServicioProyectoIntegrador.DTO.DispatcinDTO;
import com.example.microServicioProyectoIntegrador.Exception.ChangeState;
import com.example.microServicioProyectoIntegrador.Exception.DispatchNoValidoException;
import com.example.microServicioProyectoIntegrador.Exception.NotFoundException;
import com.example.microServicioProyectoIntegrador.Exception.RepositorioException;
import com.example.microServicioProyectoIntegrador.Models.*;
import com.example.microServicioProyectoIntegrador.Repository.CustomerRepository;
import com.example.microServicioProyectoIntegrador.Repository.DispatchRepository;
import com.example.microServicioProyectoIntegrador.Repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Service
public class ServiceDispatch {

    @PersistenceContext
    private EntityManager em;
    private DispatchRepository dispatchRepository;

    private CustomerRepository customerRepository;

    private EmployeesRepository employeesRepository;


    @Autowired
    public ServiceDispatch(DispatchRepository dispatchRepository, CustomerRepository customerRepository, EmployeesRepository employeesRepository) {
        this.dispatchRepository = dispatchRepository;
        this.customerRepository = customerRepository;
        this.employeesRepository = employeesRepository;
    }
    public boolean validarCedula(Long cedula) {
        String jpql = "SELECT c FROM Customer c WHERE c.cedula = :cedula";
        TypedQuery<Customer> query = em.createQuery(jpql, Customer.class);
        query.setParameter("cedula", cedula);
        List<Customer> clientes = query.getResultList();
        return !clientes.isEmpty();
    }

    public static String generarCodigo() {
        int longitud = 10;
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder(longitud);
        Random random = new Random();
        for (int i = 0; i < longitud; i++) {
            int index = random.nextInt(caracteres.length());
            sb.append(caracteres.charAt(index));
        }
        return sb.toString();
    }

    public DispatchDTO addDispatch (DispatcinDTO dispatch) throws DispatchNoValidoException, RepositorioException{
        String typePackage="";
        Integer priceDispatch=0;

      //      PackageType packageType = new PackageType(dispatch.);
                if(dispatch.getWeight()<=2){
                    typePackage = "LIVIANO";
                    priceDispatch = 30000;
                } else if (dispatch.getWeight()>2 && dispatch.getWeight()<=5) {
                    typePackage = "MEDIANO";
                    priceDispatch = 40000;
                } else if (dispatch.getWeight() > 5) {
                    typePackage = "GRANDE";
                    priceDispatch = 50000;
                }

        Dispatch dispatch1 = new Dispatch(generarCodigo(),dispatch.getCedulaCliente(), dispatch.getCityOrigin(), dispatch.getCityDestination(), dispatch.getAddressDestination(), dispatch.getNameRecive(), dispatch.getPhoneRecive(), LocalDate.now(), "RECIBIDO", priceDispatch,typePackage, dispatch.getInsuredvalue(),dispatch.getWeight());

                if (dispatch1.getCedulaCliente() == 0 || dispatch1.getCityOrigin().isEmpty() || dispatch1.getCityDestination().isEmpty() || dispatch1.getAddressDestination().isEmpty() || dispatch1.getNameRecive().isEmpty() || dispatch1.getPhoneRecive()==0) {
                    throw new DispatchNoValidoException("Hay campos vacios");
                }
            if (!validarCedula(dispatch1.getCedulaCliente())) {
                throw new DispatchNoValidoException("El cliente con cedula "+ dispatch.getCedulaCliente() + " debe de estar registrado para\n" +
                        "poder enviar un paquete");
            }
        try {
            this.dispatchRepository.save(dispatch1);
            return new DispatchDTO(dispatch1.getNumberGuia(), dispatch1.getStateDispatch());
        } catch (Exception e) {
            throw new RepositorioException("Mensaje:" + e.getMessage());
        }

    }
//
    public Dispatch getDispatchGuia(String numberGuia) {
        Dispatch dispatch = this.dispatchRepository.findByNumberGuia(numberGuia);
        return dispatch;
    }

    public  ResponseDispatch updateDispatch (UpdateDispatch updateDispatch)throws NotFoundException, ChangeState {
        Employee employee = this.employeesRepository.findByCedula(updateDispatch.getCedulaEmpleado());
        Dispatch dispatch = getDispatchGuia(updateDispatch.getNumeroGuia());
        if (employee == null) {
            throw new NotFoundException( "El empleado con cedula "+ updateDispatch.getCedulaEmpleado()+" no existe en nuestra compania"  );
        }
        if (employee.getTipoEmpleado().equals("REPARTIDOR") || employee.getTipoEmpleado().equals("COORDINADOR")){
            if(dispatch.getStateDispatch().equals("RECIBIDO") && updateDispatch.getEstadoEnvio().equals("EN RUTA")){
                dispatch.setStateDispatch(updateDispatch.getEstadoEnvio());
            }
            if(dispatch.getStateDispatch().equals("EN RUTA") && updateDispatch.getEstadoEnvio().equals("ENTREGADO")){
                dispatch.setStateDispatch(updateDispatch.getEstadoEnvio());
            }
            if(dispatch.getStateDispatch().equals("RECIBIDO") && updateDispatch.getEstadoEnvio().equals("ENTREGADO") || dispatch.getStateDispatch().equals("EN RUTA") && updateDispatch.getEstadoEnvio().equals("RECIBIDO")){
                throw new ChangeState(": \"el cambio de estado no cumple\n" +
                        "con las validaciones");
            }
            this.dispatchRepository.save(dispatch);
        }
        return new ResponseDispatch(dispatch.getNumberGuia(),dispatch.getStateDispatch());
    }

    public List<Dispatch> getFilterDispatch (String stateEnvio,Integer cedula) throws NotFoundException{
        Employee employee = this.employeesRepository.findByCedula(cedula);
        if (employee == null) {
            throw new NotFoundException( "El empleado con cedula "+ cedula +" no existe en nuestra compania"  );
        }

        return this.dispatchRepository.findByStateDispatch(stateEnvio);
    }

    public List<Dispatch> getDispatch(){
        return  this.dispatchRepository.findAll();
    }

}

