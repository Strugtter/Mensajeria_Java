package com.example.microServicioProyectoIntegrador;
import static org.junit.jupiter.api.Assertions.*;

import com.example.microServicioProyectoIntegrador.DTO.DispatchDTO;
import com.example.microServicioProyectoIntegrador.Exception.DispatchNoValidoException;
import com.example.microServicioProyectoIntegrador.Exception.RepositorioException;
import com.example.microServicioProyectoIntegrador.Models.Dispatch;
import com.example.microServicioProyectoIntegrador.Models.ResponseDispatch;
import com.example.microServicioProyectoIntegrador.Models.UpdateDispatch;
import com.example.microServicioProyectoIntegrador.Repository.CustomerRepository;
import com.example.microServicioProyectoIntegrador.Repository.DispatchRepository;
import com.example.microServicioProyectoIntegrador.Repository.EmployeesRepository;
import com.example.microServicioProyectoIntegrador.Services.ServiceDispatch;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TestServiceDispatchh {


    private ServiceDispatch serviceDispatch;

    private DispatchRepository dispatchRepository;

    private CustomerRepository customerRepository;

    private EmployeesRepository employeesRepository;

    @BeforeEach
    public void setUp() {

        customerRepository = mock(CustomerRepository.class);
        dispatchRepository = mock(DispatchRepository.class);
        employeesRepository = mock(EmployeesRepository.class);
        serviceDispatch = new ServiceDispatch(dispatchRepository, customerRepository, employeesRepository);
    }


    @Test
    public void testGetDispatchGuia() {
        Dispatch dispatch = new Dispatch();
        dispatch.setStateDispatch("RECIBIDO");
        when(dispatchRepository.findByNumberGuia("ABC123XYZ")).thenReturn(dispatch); // número de guía válido
        when(dispatchRepository.findByNumberGuia("123XYZ")).thenReturn(null); // número de guía inválido

        // Prueba de número de guía válido
        Dispatch validDispatch = serviceDispatch.getDispatchGuia("ABC123XYZ");
        assertNotNull(validDispatch);
        assertEquals("RECIBIDO", validDispatch.getStateDispatch());

        // Prueba de número de guía inválido
        Dispatch invalidDispatch = serviceDispatch.getDispatchGuia("123XYZ");
        assertNull(invalidDispatch);
    }

/*    @Test
    public void testAddDispatch() throws DispatchNoValidoException, RepositorioException {
        LocalDate fechaEntrega = LocalDate.of(2023, 01, 13);
        Dispatch dispatch = new Dispatch("AZRR4351", 12345, "Bogota", "Medellin", "Calle 123", "Juan Perez", 34512L, fechaEntrega, "RECIBIDO", 10000, 5000, 2, "LIVIANO");
        when(dispatchRepository.save(dispatch)).thenReturn(dispatch);
        DispatchDTO dispatchDTO = serviceDispatch.addDispatch(dispatch);
        verify(dispatchRepository, times(1)).save(dispatch);
        assertEquals(dispatchDTO.getNumeroGuia(), dispatch.getNumberGuia());
    }*/
}










/*    @Test
    public void testValidarCedula() {
        assertTrue(serviceDispatch.validarCedula(12345)); // cédula existe
        assertFalse(serviceDispatch.validarCedula(9876)); // cédula no existe
    }*/




/*    @Test
    public void testGetDispatchGuia() {
        Dispatch dispatch = serviceDispatch.getDispatchGuia("ABC123XYZ"); // número de guía válido
        assertNotNull(dispatch);
        assertEquals("RECIBIDO", dispatch.getStateDispatch());

        dispatch = serviceDispatch.getDispatchGuia("123XYZ"); // número de guía inválido
        assertNull(dispatch);
    }*/

/*    @Test
    public void testUpdateDispatch() {
        // creación de un objeto UpdateDispatch válido
        UpdateDispatch updateDispatch = new UpdateDispatch("ABC123XYZ", "EN RUTA", 1234567890);

        // actualización de un estado de envío válido
        ResponseDispatch response = serviceDispatch.updateDispatch(updateDispatch);
        assertNotNull(response);
        assertEquals("EN RUTA", response.getEstadoEnvio());

        // actualización de un estado de envío inválido
        updateDispatch.setEstadoEnvio("RECIBIDO");
        assertThrows(ChangeStateException.class, () -> {
            serviceDispatch.updateDispatch(updateDispatch);
        });
    }*/



