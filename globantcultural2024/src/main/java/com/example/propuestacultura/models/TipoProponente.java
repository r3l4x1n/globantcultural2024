package com.example.propuestacultura.models;


import jakarta.persistence.*;

@Entity
@Table(name = "tipos_proponente")
public class TipoProponente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tipo_proponente;

    @Column(name = "tipo_proponente")
    private String tipo_proponente;

    public TipoProponente() {
    }

    public TipoProponente(Integer id_tipo_proponente, String tipo_proponente) {
        this.id_tipo_proponente = id_tipo_proponente;
        this.tipo_proponente = tipo_proponente;
    }

    public Integer getId_tipo_proponente() {
        return id_tipo_proponente;
    }

    public void setId_tipo_proponente(Integer id_tipo_proponente) {
        this.id_tipo_proponente = id_tipo_proponente;
    }

    public String getTipo_proponente() {
        return tipo_proponente;
    }

    public void setTipo_proponente(String tipo_proponente) {
        this.tipo_proponente = tipo_proponente;
    }
}
