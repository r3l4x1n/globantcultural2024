package com.example.propuestacultura.services.impl;


import com.example.propuestacultura.DTO.DocumentosAdjuntosDTO;
import com.example.propuestacultura.mapa.IDocumentosAdjuntosMapa;
import com.example.propuestacultura.models.DocumentosAdjuntos;
import com.example.propuestacultura.repositorios.IDocumentosAdjuntosRepositorio;
import com.example.propuestacultura.services.DocumentosAdjuntosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentosAdjuntosServicioImpl implements  DocumentosAdjuntosServicio {

    @Autowired
    IDocumentosAdjuntosRepositorio iDocumentosAdjuntosRepositorio;

    @Autowired
    IDocumentosAdjuntosMapa iDocumentosAdjuntosMapa;

    @Override
    public DocumentosAdjuntosDTO guardarDocumentosAdjuntos(DocumentosAdjuntos datosDocumentosAdjuntos)throws Exception {
        try {
            return this.iDocumentosAdjuntosMapa.documentosAdjuntosToDTO(this.iDocumentosAdjuntosRepositorio.save(datosDocumentosAdjuntos));
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
    @Override
    public DocumentosAdjuntosDTO buscarDocumentoAdjunto(Integer id) throws Exception{
        Optional<DocumentosAdjuntos> documentosAdjuntosOptional = this.iDocumentosAdjuntosRepositorio.findById(id);
        if (documentosAdjuntosOptional.isPresent()){
            return this.iDocumentosAdjuntosMapa.documentosAdjuntosToDTO(documentosAdjuntosOptional.get());

        }else {
            throw new Exception("Documento Adjunto no encontrado con el ID proporcionado: " + id);
        }
    }
    @Override
    public List<DocumentosAdjuntosDTO> buscarTodosDocumentoAdjunto()throws Exception {
        try {
            return this.iDocumentosAdjuntosMapa.toDTOList(iDocumentosAdjuntosRepositorio.findAll());
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    @Override
    public DocumentosAdjuntosDTO modificarDocumentoAdjunto(Integer id, DocumentosAdjuntos documentosAdjuntos) throws Exception{
        try{
            if (this.iDocumentosAdjuntosRepositorio.findById(id).isPresent()){
                DocumentosAdjuntos objetosEncontrado = this.iDocumentosAdjuntosRepositorio.findById(id).get();
                objetosEncontrado.setNombre_documento(documentosAdjuntos.getNombre_documento());
                objetosEncontrado.setURL(documentosAdjuntos.getURL());

                return this.iDocumentosAdjuntosMapa.documentosAdjuntosToDTO(iDocumentosAdjuntosRepositorio.save(objetosEncontrado));
            }else {
                throw new Exception("documento Adjunto no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    @Override
    public Boolean eliminaDocumentoAdjunto(Integer id){
        Optional<DocumentosAdjuntos> eliminaDocumentoAdjunto = iDocumentosAdjuntosRepositorio.findById(id);
        if (eliminaDocumentoAdjunto.isEmpty())
            return false;

        iDocumentosAdjuntosRepositorio.deleteById(id);

        return true;
    }
}
