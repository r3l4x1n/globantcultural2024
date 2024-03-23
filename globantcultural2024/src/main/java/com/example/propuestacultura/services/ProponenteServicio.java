package com.example.propuestacultura.services;

import com.example.propuestacultura.DTO.ProponenteDTO;
import com.example.propuestacultura.models.Proponente;

import java.util.List;

public interface ProponenteServicio {
    ProponenteDTO agregarProponente(Proponente datosProponente) throws Exception;

    ProponenteDTO buscarProponentePorId(Integer id) throws Exception;

    List<ProponenteDTO> buscarTodosProponente() throws Exception;

    ProponenteDTO modificarProponente(Integer id, Proponente Proponente) throws Exception;

    Boolean eliminaProponente(Integer id);
}
