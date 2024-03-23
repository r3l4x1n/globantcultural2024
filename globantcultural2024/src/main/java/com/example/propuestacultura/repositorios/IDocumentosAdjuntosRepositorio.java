package com.example.propuestacultura.repositorios;

import com.example.propuestacultura.models.DocumentosAdjuntos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDocumentosAdjuntosRepositorio extends JpaRepository <DocumentosAdjuntos, Integer> {
}
