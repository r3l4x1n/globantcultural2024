package com.example.propuestacultura.services;

import com.example.propuestacultura.DTO.TipoDocumentoDTO;
import com.example.propuestacultura.models.TipoDocumento;

import java.util.List;

public interface TipoDocumentoServicio {
    //Rutina para guardar en BD un tipoDocumento
    TipoDocumentoDTO agregarTipODocumento(TipoDocumento datosTipoDocumento) throws Exception;

    //RUTINA PARA BUSCAR UN ELEMENTO DENTRO BD POR ID
    TipoDocumentoDTO buscarTipoDocumentoPorId(Integer id) throws Exception;

    List<TipoDocumentoDTO> buscarTodosTiposDocumentos() throws Exception;

    TipoDocumentoDTO modificarTipoDocumento(Integer id, TipoDocumento tipoDocumento) throws Exception;

    Boolean eliminaTipoDocumento(Integer id);
}
