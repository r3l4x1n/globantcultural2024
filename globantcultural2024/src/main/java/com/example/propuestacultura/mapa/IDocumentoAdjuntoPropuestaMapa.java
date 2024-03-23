package com.example.propuestacultura.mapa;

import com.example.propuestacultura.DTO.DocumentoAdjuntoPropuestaDTO;
import com.example.propuestacultura.models.DocumentoAdjuntoPropuesta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IDocumentoAdjuntoPropuestaMapa {
    @Mappings({
            @Mapping(source = "propuesta", target = "propuesta"),
            @Mapping(source = "documentosAdjuntos", target = "documentosAdjuntos")

    })
     DocumentoAdjuntoPropuestaDTO documentoAdjuntoPropuestaToDTO(DocumentoAdjuntoPropuesta documentoAdjuntoPropuesta);

    List<DocumentoAdjuntoPropuestaDTO> toDtoList(List<DocumentoAdjuntoPropuesta> documentoAdjuntoPropuestaList);

}
