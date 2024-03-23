package com.example.propuestacultura.services;

import com.example.propuestacultura.DTO.DocumentosAdjuntosDTO;
import com.example.propuestacultura.models.DocumentosAdjuntos;

import java.util.List;

public interface DocumentosAdjuntosServicio {
    DocumentosAdjuntosDTO guardarDocumentosAdjuntos(DocumentosAdjuntos datosDocumentosAdjuntos) throws Exception;

    DocumentosAdjuntosDTO buscarDocumentoAdjunto(Integer id) throws Exception;

    List<DocumentosAdjuntosDTO> buscarTodosDocumentoAdjunto() throws Exception;

    DocumentosAdjuntosDTO modificarDocumentoAdjunto(Integer id, DocumentosAdjuntos documentosAdjuntos) throws Exception;

    Boolean eliminaDocumentoAdjunto(Integer id);
}
