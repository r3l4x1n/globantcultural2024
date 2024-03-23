package com.example.propuestacultura.mapa;

import com.example.propuestacultura.DTO.ProponenteDTO;
import com.example.propuestacultura.models.Proponente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IProponenteMapa {
    @Mappings({
            @Mapping(source = "proponente_id", target = "proponente_id"),
            @Mapping(source = "nombre_proponente", target = "nombre_proponente"),
            @Mapping(source = "tipoProponente", target = "tipoProponente"),
            @Mapping(source = "representante", target = "representante"),
            @Mapping(source = "trayectoria", target = "trayectoria"),
    })
    ProponenteDTO proponenteToDTO(Proponente proponente);

    List<ProponenteDTO> toDTOList(List<Proponente> proponenteList);
}
