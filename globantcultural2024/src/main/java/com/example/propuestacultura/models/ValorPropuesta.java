package com.example.propuestacultura.models;

import jakarta.persistence.*;

@Entity
@Table(name = "valor_propuesta")
public class ValorPropuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_propuesta")
    private Propuesta propuesta;

    @Column(name="monto_total_propuesta")
    private Double monto_total_propuesta;

    @Column(name="aporte_comfama")
    private Double aporte_comfama;

    public ValorPropuesta() {
    }

    public ValorPropuesta(Integer id, Propuesta propuesta, Double monto_total_propuesta, Double aporte_comfama) {
        this.id = id;
        this.propuesta = propuesta;
        this.monto_total_propuesta = monto_total_propuesta;
        this.aporte_comfama = aporte_comfama;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Propuesta getPropuesta() {
        return propuesta;
    }

    public void setPropuesta(Propuesta propuesta) {
        this.propuesta = propuesta;
    }

    public Double getMonto_total_propuesta() {
        return monto_total_propuesta;
    }

    public void setMonto_total_propuesta(Double monto_total_propuesta) {
        this.monto_total_propuesta = monto_total_propuesta;
    }

    public Double getAporte_comfama() {
        return aporte_comfama;
    }

    public void setAporte_comfama(Double aporte_comfama) {
        this.aporte_comfama = aporte_comfama;
    }
}
