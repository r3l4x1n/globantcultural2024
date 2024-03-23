package com.example.propuestacultura.DTO;

import com.example.propuestacultura.models.DocumentosAdjuntos;
import com.example.propuestacultura.models.Propuesta;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


public class DocumentoAdjuntoPropuestaDTO {

    private Integer propuesta;

    private Integer documentosAdjuntos;

    public DocumentoAdjuntoPropuestaDTO() {
    }

    public DocumentoAdjuntoPropuestaDTO(Integer propuesta, Integer documentosAdjuntos) {
        this.propuesta = propuesta;
        this.documentosAdjuntos = documentosAdjuntos;
    }

    public Integer getPropuesta() {
        return propuesta;
    }

    public void setPropuesta(Integer propuesta) {
        this.propuesta = propuesta;
    }

    public Integer getDocumentosAdjuntos() {
        return documentosAdjuntos;
    }

    public void setDocumentosAdjuntos(Integer documentosAdjuntos) {
        this.documentosAdjuntos = documentosAdjuntos;
    }
}
