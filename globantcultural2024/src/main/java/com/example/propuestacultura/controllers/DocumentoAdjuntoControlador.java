package com.example.propuestacultura.controllers;

import com.example.propuestacultura.DTO.errorDTO.DocumentosAdjuntosErrorDTO;
import com.example.propuestacultura.models.DocumentosAdjuntos;
import com.example.propuestacultura.services.DocumentosAdjuntosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v3/documentoA")
public class DocumentoAdjuntoControlador {

    @Autowired
    DocumentosAdjuntosServicio documentosAdjuntosServicio;

    @PostMapping("/save")
    public ResponseEntity<?> agregarDocumentoAdjunto(@RequestBody DocumentosAdjuntos datosRecibidos){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.documentosAdjuntosServicio.guardarDocumentosAdjuntos(datosRecibidos));
        } catch (Exception e) {
            DocumentosAdjuntosErrorDTO errorPersonalizado = new DocumentosAdjuntosErrorDTO();
            errorPersonalizado.setMensajeError(e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorPersonalizado.getMensajeError());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarDocumentoAdjuntoPorId(@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.documentosAdjuntosServicio.buscarDocumentoAdjunto(id));
        } catch (Exception e) {
            DocumentosAdjuntosErrorDTO errorPersonalizado = new DocumentosAdjuntosErrorDTO();
            errorPersonalizado.setMensajeError(e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(errorPersonalizado.getMensajeError());
        }
    }
    @GetMapping("/seach")
    public ResponseEntity<?>buscarDocumentoAdjunto(){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.documentosAdjuntosServicio.buscarTodosDocumentoAdjunto());
        }catch (Exception e){
            DocumentosAdjuntosErrorDTO errorPersonalizado = new DocumentosAdjuntosErrorDTO();
            errorPersonalizado.setMensajeError(e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(errorPersonalizado.getMensajeError());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> modificarDocumentoAdjunto(@RequestBody DocumentosAdjuntos datosRecibidos, @PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(this.documentosAdjuntosServicio.modificarDocumentoAdjunto(id, datosRecibidos));
        }catch (Exception error){
            DocumentosAdjuntosErrorDTO errorPersonalizado = new DocumentosAdjuntosErrorDTO();
            errorPersonalizado.setMensajeError(error.getMessage());

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorPersonalizado.getMensajeError());
        }
    }
    @DeleteMapping(value = "/documentoA/{id}")
    public Optional<ResponseEntity<?>> eliminar(@PathVariable int id){

        Boolean result = documentosAdjuntosServicio.eliminaDocumentoAdjunto(id);

        if (result){
            return Optional.of(ResponseEntity.noContent().build());
        }
        return Optional.of(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }
}
