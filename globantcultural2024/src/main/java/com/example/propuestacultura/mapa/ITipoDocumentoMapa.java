package com.example.propuestacultura.mapa;

import com.example.propuestacultura.DTO.TipoDocumentoDTO;
import com.example.propuestacultura.models.TipoDocumento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ITipoDocumentoMapa {

    @Mappings({
            @Mapping(source = "id_tipo_documento", target = "id"),
            @Mapping(source = "tipo_documento", target = "tipoDocumento")
    })
    TipoDocumentoDTO tipoDocumentoToDTO(TipoDocumento tipoDocumento);

    List<TipoDocumentoDTO> toDtoList(List<TipoDocumento> tipoDocumentoList);

}