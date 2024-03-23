package com.example.propuestacultura.DTO.errorDTO;

public class ValorPropuestaErrorDTO {
    private String mensajeError;

    public ValorPropuestaErrorDTO() {
    }

    public ValorPropuestaErrorDTO(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }
}
