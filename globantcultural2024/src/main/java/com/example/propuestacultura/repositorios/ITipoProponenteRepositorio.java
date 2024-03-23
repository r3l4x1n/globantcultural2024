package com.example.propuestacultura.repositorios;

import com.example.propuestacultura.models.TipoProponente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITipoProponenteRepositorio extends JpaRepository <TipoProponente, Integer> {
}
