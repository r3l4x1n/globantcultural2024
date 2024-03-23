package com.example.propuestacultura.services.impl;

import com.example.propuestacultura.DTO.DocumentoAdjuntoPropuestaDTO;
import com.example.propuestacultura.mapa.IDocumentoAdjuntoPropuestaMapa;
import com.example.propuestacultura.models.DocumentoAdjuntoPropuesta;
import com.example.propuestacultura.repositorios.IDocumentoAdjuntoPropuestaRepositorio;
import com.example.propuestacultura.services.DocumentoAdjuntoPropuestaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentoAdjuntoPropuestaServicioImpl implements DocumentoAdjuntoPropuestaServicio {

    @Autowired
    IDocumentoAdjuntoPropuestaRepositorio iDocumentoAdjuntoPropuestaRepositorio;

    @Autowired
    IDocumentoAdjuntoPropuestaMapa iDocumentoAdjuntoPropuestaMapa;


    @Override
    public DocumentoAdjuntoPropuestaDTO agregarDocumentoAdjuntoPropuesta(DocumentoAdjuntoPropuesta datosDocumentoAdjuntoPropuesta) throws Exception{
        try {
            return this.iDocumentoAdjuntoPropuestaMapa.documentoAdjuntoPropuestaToDTO(this.iDocumentoAdjuntoPropuestaRepositorio.save(datosDocumentoAdjuntoPropuesta));
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public DocumentoAdjuntoPropuestaDTO buscarDocumentoAdjuntoPropuestaPorId(Integer id) throws Exception {
        Optional<DocumentoAdjuntoPropuesta> documentoAdjuntoPropuestaOptional = this.iDocumentoAdjuntoPropuestaRepositorio.findById(id);
        if (documentoAdjuntoPropuestaOptional.isPresent()){
            return this.iDocumentoAdjuntoPropuestaMapa.documentoAdjuntoPropuestaToDTO(documentoAdjuntoPropuestaOptional.get());
        }else {
            throw new Exception("Documento Adjunto Propuesto no encontrado con el ID proporcionado: " + id);
        }
    }

    @Override
    public List<DocumentoAdjuntoPropuestaDTO> buscarTodosDocumentoAdjuntoPropuesta() throws Exception {
       try {
           return this.iDocumentoAdjuntoPropuestaMapa.toDtoList(iDocumentoAdjuntoPropuestaRepositorio.findAll());

       }catch (Exception error){
           throw new Exception(error.getMessage());
       }
    }

    @Override
    public DocumentoAdjuntoPropuestaDTO modificarDocumentoAdjuntoPropuesta(Integer id, DocumentoAdjuntoPropuesta documentoAdjuntoPropuesta) throws Exception {
        try {
            if (this.iDocumentoAdjuntoPropuestaRepositorio.findById(id).isPresent()){
                DocumentoAdjuntoPropuesta objetoEncontrado = this.iDocumentoAdjuntoPropuestaRepositorio.findById(id).get();
                objetoEncontrado.setDocumentosAdjuntos(documentoAdjuntoPropuesta.getDocumentosAdjuntos());
              return this.iDocumentoAdjuntoPropuestaMapa.documentoAdjuntoPropuestaToDTO(iDocumentoAdjuntoPropuestaRepositorio.save(objetoEncontrado));
           }else {
              throw new Exception("documento propuesta no encontrado");
         }
      }catch (Exception error){
            throw new Exception(error.getMessage());
      }
    }
    @Override
    public Boolean eliminaDocumentoAdjuntoPropuesta(Integer id){
        Optional<DocumentoAdjuntoPropuesta> eliminaDocumentoAdjuntoPropuesta = iDocumentoAdjuntoPropuestaRepositorio.findById(id);

        if (eliminaDocumentoAdjuntoPropuesta.isEmpty())
            return false;

        iDocumentoAdjuntoPropuestaRepositorio.deleteById(id);

        return true;
    }
}

