package com.example.propuestacultura.DTO.errorDTO;

public class RepresentanteErrorDTO {
    private String mensajeError;

    public RepresentanteErrorDTO() {
    }

    public RepresentanteErrorDTO(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }
}
