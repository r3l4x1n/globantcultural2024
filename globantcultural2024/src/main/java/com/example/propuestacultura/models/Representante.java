package com.example.propuestacultura.models;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="representantes")
public class Representante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_representante;

    @ManyToOne
    @JoinColumn(name="id_tipo_documento")
    private TipoDocumento tipoDocumento;

    @Column(name = "numero_documento")
    private String numero_documento;

    @Column(name = "primer_nombre")
    private String primer_nombre;

    @Column(name = "primer_apellido")
    private String primer_apellido;

    @Column(name = "telefono_fijo")
    private String telefono_fijo;

    @Column(name = "telefono_celular")
    private String telefono_celular;

    @Column(name="correo")
    private String correo;

    @Column(name="password")
    private String password;

    @Column(name = "estado", columnDefinition = "TINYINT")
    private Boolean status;

    public Representante() {
    }

    public Representante(Integer id_representante, TipoDocumento tipoDocumento, String numero_documento, String primer_nombre, String primer_apellido, String telefono_fijo, String telefono_celular, String correo, String password, Boolean status) {
        this.id_representante = id_representante;
        this.tipoDocumento = tipoDocumento;
        this.numero_documento = numero_documento;
        this.primer_nombre = primer_nombre;
        this.primer_apellido = primer_apellido;
        this.telefono_fijo = telefono_fijo;
        this.telefono_celular = telefono_celular;
        this.correo = correo;
        this.password = password;
        this.status = status;
    }

    public Integer getId_representante() {
        return id_representante;
    }

    public void setId_representante(Integer id_representante) {
        this.id_representante = id_representante;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(String numero_documento) {
        this.numero_documento = numero_documento;
    }

    public String getPrimer_nombre() {
        return primer_nombre;
    }

    public void setPrimer_nombre(String primer_nombre) {
        this.primer_nombre = primer_nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getTelefono_fijo() {
        return telefono_fijo;
    }

    public void setTelefono_fijo(String telefono_fijo) {
        this.telefono_fijo = telefono_fijo;
    }

    public String getTelefono_celular() {
        return telefono_celular;
    }

    public void setTelefono_celular(String telefono_celular) {
        this.telefono_celular = telefono_celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
