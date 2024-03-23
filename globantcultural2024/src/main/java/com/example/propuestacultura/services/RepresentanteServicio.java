package com.example.propuestacultura.services;

import com.example.propuestacultura.DTO.RepresentanteDTO;
import com.example.propuestacultura.models.Representante;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface RepresentanteServicio {
    RepresentanteDTO agregarRepresentante(Representante datosRepresentante) throws Exception;

    RepresentanteDTO buscarRepresentantePorId(Integer id) throws Exception;

    List<RepresentanteDTO> buscarTodosLosRepresentantes() throws Exception;

    RepresentanteDTO modificarRepresentante(Integer id, Representante representante) throws Exception;

    Boolean eliminaRepresentante(Integer id);

    ResponseEntity<String> login(Map<String, String> requestMap);
}
