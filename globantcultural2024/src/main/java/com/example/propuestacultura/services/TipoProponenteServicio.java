package com.example.propuestacultura.services;

import com.example.propuestacultura.DTO.TipoProponenteDTO;
import com.example.propuestacultura.models.TipoProponente;

import java.util.List;

public interface TipoProponenteServicio {

    TipoProponenteDTO agregarTipoProponente(TipoProponente datosTipoDocumento)throws Exception;

    TipoProponenteDTO buscarTipoProponentePorId(Integer id) throws Exception;

    List<TipoProponenteDTO> buscarTodosTipoProponente() throws Exception;

    TipoProponenteDTO modificarTipoproponente(Integer id, TipoProponente tipoProponente) throws Exception;

    Boolean eliminaTipoProponente(Integer id);
}
