package com.example.propuestacultura.mapa;

import com.example.propuestacultura.DTO.TipoProponenteDTO;
import com.example.propuestacultura.models.TipoProponente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ITipoProponenteMapa {

    @Mappings({
            @Mapping(source = "id_tipo_proponente", target = "id_tipo_proponente"),
            @Mapping(source="tipo_proponente",target="tipo_proponente")
    })
    TipoProponenteDTO tipoproponenteToDTO(TipoProponente tipoProponente);

    List<TipoProponenteDTO> toDTOList(List<TipoProponente> tipoProponenteList);
}
