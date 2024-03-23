package com.example.propuestacultura.DTO.errorDTO;

public class PropuestaErrorDTO {
    private String mensajeError;

    public PropuestaErrorDTO() {
    }

    public PropuestaErrorDTO(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }
}
