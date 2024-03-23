package com.example.propuestacultura.DTO.errorDTO;

public class TipoDocumentoErrorDTO {

    private String mensajeError;

    public TipoDocumentoErrorDTO() {
    }

    public TipoDocumentoErrorDTO(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }
}
