package com.example.propuestacultura.DTO;

import com.example.propuestacultura.helpers.Estados;
import com.example.propuestacultura.models.Proponente;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

public class PropuestaDTO {

        private Integer id_propuesta;

        private Proponente proponente;

        private String nombre_propuesta;

        private String descripcion_actividades;


        private String descripcion_propuesta;

        private LocalDate fecha_presentacion;

        private String publico_beneficiado;

        private String empresas_aliadas;

        private Estados estado_propuesta=Estados.INICIAL;
        private LocalDate fecha_inicio_evento;

    public PropuestaDTO() {
    }

    public PropuestaDTO(Integer id_propuesta, Proponente proponente, String nombre_propuesta, String descripcion_actividades, String descripcion_propuesta, LocalDate fecha_presentacion, String publico_beneficiado, String empresas_aliadas, Estados estado_propuesta, LocalDate fecha_inicio_evento) {
        this.id_propuesta = id_propuesta;
        this.proponente = proponente;
        this.nombre_propuesta = nombre_propuesta;
        this.descripcion_actividades = descripcion_actividades;
        this.descripcion_propuesta = descripcion_propuesta;
        this.fecha_presentacion = fecha_presentacion;
        this.publico_beneficiado = publico_beneficiado;
        this.empresas_aliadas = empresas_aliadas;
        this.estado_propuesta = estado_propuesta;
        this.fecha_inicio_evento = fecha_inicio_evento;
    }

    public Integer getId_propuesta() {
        return id_propuesta;
    }

    public void setId_propuesta(Integer id_propuesta) {
        this.id_propuesta = id_propuesta;
    }

    public Proponente getProponente() {
        return proponente;
    }

    public void setProponente(Proponente proponente) {
        this.proponente = proponente;
    }

    public String getNombre_propuesta() {
        return nombre_propuesta;
    }

    public void setNombre_propuesta(String nombre_propuesta) {
        this.nombre_propuesta = nombre_propuesta;
    }

    public String getDescripcion_actividades() {
        return descripcion_actividades;
    }

    public void setDescripcion_actividades(String descripcion_actividades) {
        this.descripcion_actividades = descripcion_actividades;
    }

    public String getDescripcion_propuesta() {
        return descripcion_propuesta;
    }

    public void setDescripcion_propuesta(String descripcion_propuesta) {
        this.descripcion_propuesta = descripcion_propuesta;
    }

    public LocalDate getFecha_presentacion() {
        return fecha_presentacion;
    }

    public void setFecha_presentacion(LocalDate fecha_presentacion) {
        this.fecha_presentacion = fecha_presentacion;
    }

    public String getPublico_beneficiado() {
        return publico_beneficiado;
    }

    public void setPublico_beneficiado(String publico_beneficiado) {
        this.publico_beneficiado = publico_beneficiado;
    }

    public String getEmpresas_aliadas() {
        return empresas_aliadas;
    }

    public void setEmpresas_aliadas(String empresas_aliadas) {
        this.empresas_aliadas = empresas_aliadas;
    }

    public Estados getEstado_propuesta() {
        return estado_propuesta;
    }

    public void setEstado_propuesta(Estados estado_propuesta) {
        this.estado_propuesta = estado_propuesta;
    }

    public LocalDate getFecha_inicio_evento() {
        return fecha_inicio_evento;
    }

    public void setFecha_inicio_evento(LocalDate fecha_inicio_evento) {
        this.fecha_inicio_evento = fecha_inicio_evento;
    }
}
