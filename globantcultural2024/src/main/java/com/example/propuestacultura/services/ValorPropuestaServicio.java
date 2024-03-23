package com.example.propuestacultura.services;

import com.example.propuestacultura.DTO.ValorPropuestaDTO;
import com.example.propuestacultura.models.ValorPropuesta;

import java.util.List;

public interface ValorPropuestaServicio {
    ValorPropuestaDTO agregarValorPropuesta(ValorPropuesta datosTipoDocumento) throws Exception;

    ValorPropuestaDTO buscarValorPropuestaPorId(Integer id) throws Exception;

    List<ValorPropuestaDTO> buscarTodosValorPropuesta() throws Exception;

    ValorPropuestaDTO modificarValorPropuesta(Integer id, ValorPropuesta valorPropuesta) throws Exception;

    Boolean eliminarValorPropuesta(Integer id);
}
