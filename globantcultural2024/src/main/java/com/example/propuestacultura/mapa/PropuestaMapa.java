package com.example.propuestacultura.mapa;

import com.example.propuestacultura.DTO.PropuestaDTO;
import com.example.propuestacultura.models.Propuesta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PropuestaMapa {
    @Mappings({
            @Mapping(source = "id_propuesta", target = "id_propuesta"),
            @Mapping(source = "proponente", target = "proponente"),
            @Mapping(source = "nombre_propuesta", target = "nombre_propuesta"),
            @Mapping(source = "descripcion_actividades", target = "descripcion_actividades"),
            @Mapping(source = "descripcion_propuesta", target = "descripcion_propuesta"),
            @Mapping(source = "fecha_presentacion", target = "fecha_presentacion"),
            @Mapping(source = "publico_beneficiado", target = "publico_beneficiado"),
            @Mapping(source = "empresas_aliadas", target = "empresas_aliadas"),
            @Mapping(source = "estado_propuesta", target = "estado_propuesta"),
            @Mapping(source = "fecha_inicio_evento", target = "fecha_inicio_evento")
    })
    PropuestaDTO propuestaToDTO(Propuesta documentoAdjuntoPropuesta);

    List<PropuestaDTO> toDtoList(List<Propuesta> propuestaList);
}
