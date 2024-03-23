package com.example.propuestacultura.controllers;

import com.example.propuestacultura.DTO.errorDTO.DocumentoAdjuntoPropuestaErrorDTO;
import com.example.propuestacultura.models.DocumentoAdjuntoPropuesta;
import com.example.propuestacultura.services.impl.DocumentoAdjuntoPropuestaServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v2/documentoPropuesta")
public class DocumentoAdjuntoPropuestaControlador {

    @Autowired
    DocumentoAdjuntoPropuestaServicioImpl documentoAdjuntoPropuestaServicio;

    @PostMapping("/save")
    public ResponseEntity<?> agregarDocumentoAdjuntoPropuesta(@RequestBody DocumentoAdjuntoPropuesta datosRecibidos){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.documentoAdjuntoPropuestaServicio.agregarDocumentoAdjuntoPropuesta(datosRecibidos));
        } catch (Exception e) {
            DocumentoAdjuntoPropuestaErrorDTO errorPersonalizado = new DocumentoAdjuntoPropuestaErrorDTO();
            errorPersonalizado.setMensajeError(e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorPersonalizado.getMensajeError());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarDocumentoAdjuntoPropuestaPorId(@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.documentoAdjuntoPropuestaServicio.buscarDocumentoAdjuntoPropuestaPorId(id));
        } catch (Exception e) {
            DocumentoAdjuntoPropuestaErrorDTO errorPersonalizado = new DocumentoAdjuntoPropuestaErrorDTO();
            errorPersonalizado.setMensajeError(e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(errorPersonalizado.getMensajeError());
        }
    }
    @GetMapping("/seach")
    public ResponseEntity<?>buscarDocumentoAdjuntoPropuesta(){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.documentoAdjuntoPropuestaServicio.buscarTodosDocumentoAdjuntoPropuesta());
        } catch (Exception e) {

            DocumentoAdjuntoPropuestaErrorDTO errorPersonalizado = new DocumentoAdjuntoPropuestaErrorDTO();
            errorPersonalizado.setMensajeError(e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(errorPersonalizado.getMensajeError());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> modificarDocumentoAdjuntoPropuesta(@RequestBody DocumentoAdjuntoPropuesta datosRecibidos, @PathVariable Integer id){
        try{
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(this.documentoAdjuntoPropuestaServicio.modificarDocumentoAdjuntoPropuesta(id, datosRecibidos));
        }catch (Exception error){
            DocumentoAdjuntoPropuestaErrorDTO errorPersonalizado = new DocumentoAdjuntoPropuestaErrorDTO();
            errorPersonalizado.setMensajeError(error.getMessage());

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorPersonalizado.getMensajeError());
        }
    }
    @DeleteMapping(value = "/documentoP/{id}")
    public Optional<ResponseEntity<?>> eliminar(@PathVariable int id){

        Boolean result = documentoAdjuntoPropuestaServicio.eliminaDocumentoAdjuntoPropuesta(id);

        if (result){
            return Optional.of(ResponseEntity.noContent().build());
        }
        return Optional.of(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }
}
