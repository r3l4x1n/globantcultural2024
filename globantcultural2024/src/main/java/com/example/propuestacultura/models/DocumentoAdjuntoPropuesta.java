package com.example.propuestacultura.models;

import jakarta.persistence.*;


@Entity
@Table(name = "propuesta_documento")
public class DocumentoAdjuntoPropuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer propuesta;

    @Column(name = "id_documentoAdjunto")
    private Integer documentosAdjuntos;

    public DocumentoAdjuntoPropuesta() {
    }

    public DocumentoAdjuntoPropuesta(Integer propuesta, Integer documentosAdjuntos) {
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
