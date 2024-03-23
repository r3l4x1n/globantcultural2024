package com.example.propuestacultura.DTO;

import com.example.propuestacultura.models.Representante;
import com.example.propuestacultura.models.TipoProponente;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class ProponenteDTO {
    private Integer proponente_id;

    private String nombre_proponente;

    private String trayectoria;

    private Representante representante;

    private TipoProponente tipoProponente;

    public ProponenteDTO() {
    }

    public ProponenteDTO(Integer proponente_id, String nombre_proponente, String trayectoria, Representante representante, TipoProponente tipoProponente) {
        this.proponente_id = proponente_id;
        this.nombre_proponente = nombre_proponente;
        this.trayectoria = trayectoria;
        this.representante = representante;
        this.tipoProponente = tipoProponente;
    }

    public Integer getProponente_id() {
        return proponente_id;
    }

    public void setProponente_id(Integer proponente_id) {
        this.proponente_id = proponente_id;
    }

    public String getNombre_proponente() {
        return nombre_proponente;
    }

    public void setNombre_proponente(String nombre_proponente) {
        this.nombre_proponente = nombre_proponente;
    }

    public String getTrayectoria() {
        return trayectoria;
    }

    public void setTrayectoria(String trayectoria) {
        this.trayectoria = trayectoria;
    }

    public Representante getRepresentante() {
        return representante;
    }

    public void setRepresentante(Representante representante) {
        this.representante = representante;
    }

    public TipoProponente getTipoProponente() {
        return tipoProponente;
    }

    public void setTipoProponente(TipoProponente tipoProponente) {
        this.tipoProponente = tipoProponente;
    }
}
