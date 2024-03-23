package com.example.propuestacultura.services;

import com.example.propuestacultura.DTO.PropuestaDTO;
import com.example.propuestacultura.models.Propuesta;

import java.util.List;

public interface PropuestaServicio {
    PropuestaDTO guardarPropuesta(Propuesta datosPropuesta)throws Exception;

    PropuestaDTO buscarPropuesta(Integer id) throws Exception;

    List<PropuestaDTO> buscarTodasLasPropuestas()throws Exception;

    PropuestaDTO modificarPropuesta(Integer id, Propuesta propuesta) throws Exception;

    Boolean eliminarPropuesta(Integer id);
}
