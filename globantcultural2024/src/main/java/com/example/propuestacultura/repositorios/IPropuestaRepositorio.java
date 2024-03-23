package com.example.propuestacultura.repositorios;

import com.example.propuestacultura.models.Propuesta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPropuestaRepositorio extends JpaRepository <Propuesta, Integer> {
}
