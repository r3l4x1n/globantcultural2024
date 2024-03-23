package com.example.propuestacultura.DTO.errorDTO;

public class DocumentosAdjuntosErrorDTO {
    private String mensajeError;

    public DocumentosAdjuntosErrorDTO() {
    }

    public DocumentosAdjuntosErrorDTO(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }
}
