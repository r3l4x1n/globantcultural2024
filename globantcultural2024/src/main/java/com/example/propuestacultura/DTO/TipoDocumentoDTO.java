package com.example.propuestacultura.DTO;

public class TipoDocumentoDTO {

    private Integer id;
    private String tipoDocumento;

    public TipoDocumentoDTO() {
    }

    public TipoDocumentoDTO(Integer id, String tipoDocumento) {
        this.id = id;
        this.tipoDocumento = tipoDocumento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
}
