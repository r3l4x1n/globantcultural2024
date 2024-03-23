package com.example.propuestacultura.repositorios;

import com.example.propuestacultura.models.Proponente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProponenteRepositorio extends JpaRepository<Proponente, Integer> {
}
