package com.example.propuestacultura.DTO;

import jakarta.persistence.Column;


public class DocumentosAdjuntosDTO {

    private Integer id_documentoAdjunto;

    private String nombre_documento;

    private String URL;

    public DocumentosAdjuntosDTO() {
    }

    public DocumentosAdjuntosDTO(Integer id_documentoAdjunto, String nombre_documento, String URL) {
        this.id_documentoAdjunto = id_documentoAdjunto;
        this.nombre_documento = nombre_documento;
        this.URL = URL;
    }

    public Integer getId_documentoAdjunto() {
        return id_documentoAdjunto;
    }

    public void setId_documentoAdjunto(Integer id_documentoAdjunto) {
        this.id_documentoAdjunto = id_documentoAdjunto;
    }

    public String getNombre_documento() {
        return nombre_documento;
    }

    public void setNombre_documento(String nombre_documento) {
        this.nombre_documento = nombre_documento;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}
