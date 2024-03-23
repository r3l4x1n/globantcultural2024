package com.example.propuestacultura.repositorios;

import com.example.propuestacultura.models.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITipODocumentoRepositorio extends JpaRepository<TipoDocumento, Integer> {
}
