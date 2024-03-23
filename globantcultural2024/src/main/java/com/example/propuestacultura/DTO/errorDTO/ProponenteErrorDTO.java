package com.example.propuestacultura.DTO.errorDTO;

public class ProponenteErrorDTO {
    private String mensajeError;

    public ProponenteErrorDTO() {
    }

    public ProponenteErrorDTO(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }
}
