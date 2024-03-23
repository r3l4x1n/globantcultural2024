package com.example.propuestacultura.mapa;

import com.example.propuestacultura.DTO.RepresentanteDTO;
import com.example.propuestacultura.models.Representante;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IRepresentanteMapa {

    @Mappings({
            @Mapping(source="tipoDocumento", target="tipoDocumento"),
            @Mapping(source = "id_representante", target = "id_representante"),
            @Mapping(source = "numero_documento", target = "numero_documento"),
            @Mapping(source = "primer_nombre", target = "primer_nombre"),
            @Mapping(source = "primer_apellido", target = "primer_apellido"),
            @Mapping(source = "telefono_fijo", target = "telefono_fijo"),
            @Mapping(source = "telefono_celular", target = "telefono_celular"),
            @Mapping(source = "correo", target = "correo"),
            @Mapping(source = "password", target = "password"),
            @Mapping(source = "status", target = "status")
    })

   RepresentanteDTO representanteToDTO(Representante representante);

    List<RepresentanteDTO> toDTOList(List<Representante> representanteList);
}
