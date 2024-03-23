package com.example.propuestacultura.mapa;


import com.example.propuestacultura.DTO.DocumentosAdjuntosDTO;
import com.example.propuestacultura.models.DocumentosAdjuntos;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;


@Mapper(componentModel = "spring")
public interface IDocumentosAdjuntosMapa {
    @Mappings({
           @Mapping(source = "id_documentoAdjunto", target = "id_documentoAdjunto"),
           @Mapping(source = "nombre_documento", target = "nombre_documento"),
           @Mapping(source = "URL", target = "URL")
    })
    DocumentosAdjuntosDTO documentosAdjuntosToDTO(DocumentosAdjuntos documentosAdjuntos);
    List<DocumentosAdjuntosDTO> toDTOList( List<DocumentosAdjuntos> documentosAdjuntosList);
}
