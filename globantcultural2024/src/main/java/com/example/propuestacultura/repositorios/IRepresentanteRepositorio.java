package com.example.propuestacultura.repositorios;

import com.example.propuestacultura.models.Representante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface IRepresentanteRepositorio extends JpaRepository <Representante, Integer> {
    Representante findByCorreo(String correo);



}
