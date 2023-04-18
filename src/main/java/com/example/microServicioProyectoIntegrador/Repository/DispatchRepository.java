package com.example.microServicioProyectoIntegrador.Repository;

import com.example.microServicioProyectoIntegrador.Models.Dispatch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface DispatchRepository extends JpaRepository<Dispatch, String> {
   Dispatch findByNumberGuia(String numeroGuia);
   List<Dispatch> findByStateDispatch(String stateDispatch);

}
