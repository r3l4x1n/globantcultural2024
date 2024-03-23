package com.example.propuestacultura.services;

import com.example.propuestacultura.DTO.DocumentoAdjuntoPropuestaDTO;
import com.example.propuestacultura.models.DocumentoAdjuntoPropuesta;

import java.util.List;

public interface DocumentoAdjuntoPropuestaServicio {
    DocumentoAdjuntoPropuestaDTO agregarDocumentoAdjuntoPropuesta(DocumentoAdjuntoPropuesta datosDocumentoAdjuntoPropuesta) throws Exception;

    DocumentoAdjuntoPropuestaDTO buscarDocumentoAdjuntoPropuestaPorId(Integer id) throws Exception;

    List<DocumentoAdjuntoPropuestaDTO> buscarTodosDocumentoAdjuntoPropuesta()throws Exception;

    DocumentoAdjuntoPropuestaDTO modificarDocumentoAdjuntoPropuesta(Integer id, DocumentoAdjuntoPropuesta documentoAdjuntoPropuesta)throws Exception;

    Boolean eliminaDocumentoAdjuntoPropuesta(Integer id);
}
