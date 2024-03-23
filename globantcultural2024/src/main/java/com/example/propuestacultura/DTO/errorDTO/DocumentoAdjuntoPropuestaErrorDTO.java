package com.example.propuestacultura.DTO.errorDTO;

public class DocumentoAdjuntoPropuestaErrorDTO {
    private String mensajeError;

    public DocumentoAdjuntoPropuestaErrorDTO() {
    }

    public DocumentoAdjuntoPropuestaErrorDTO(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }
}
