package com.example.propuestacultura.models;

import jakarta.persistence.*;

@Entity
@Table(name="tiposDocumento")
public class TipoDocumento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tipo_documento;


    @Column(name="tipo_documento")
    private String tipo_documento;

    public TipoDocumento() {
    }

    public TipoDocumento(Integer id_tipo_documento, String tipo_documento) {
        this.id_tipo_documento = id_tipo_documento;
        this.tipo_documento = tipo_documento;
    }

    public Integer getId_tipo_documento() {
        return id_tipo_documento;
    }

    public void setId_tipo_documento(Integer id_tipo_documento) {
        this.id_tipo_documento = id_tipo_documento;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }
}
