package com.example.propuestacultura.DTO.errorDTO;

public class TipoProponenteErrorDTO {
    private String mensajeError;

    public TipoProponenteErrorDTO() {
    }

    public TipoProponenteErrorDTO(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }
}
