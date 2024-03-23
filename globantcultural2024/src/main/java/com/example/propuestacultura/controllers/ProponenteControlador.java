package com.example.propuestacultura.controllers;

import com.example.propuestacultura.DTO.errorDTO.ProponenteErrorDTO;
import com.example.propuestacultura.models.Proponente;
import com.example.propuestacultura.services.impl.ProponenteServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v6/proponente")
public class ProponenteControlador {

    @Autowired
    ProponenteServicioImpl proponenteServicio;

    @PostMapping("/save")
    public ResponseEntity<?> agregarProponente(@RequestBody Proponente datosRecibidos) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.proponenteServicio.agregarProponente(datosRecibidos));
        } catch (Exception e) {
            ProponenteErrorDTO errorPersonalizado = new ProponenteErrorDTO();
            errorPersonalizado.setMensajeError(e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorPersonalizado.getMensajeError());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?>BuscarUnProponentePorId(@PathVariable Integer id){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.proponenteServicio.buscarProponentePorId(id));
        }catch( Exception error){

            ProponenteErrorDTO errorPersonalizado=new ProponenteErrorDTO();
            errorPersonalizado.setMensajeError(error.getMessage());

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(errorPersonalizado.getMensajeError());
        }

    }
    @GetMapping("/seach")
    public ResponseEntity<?>buscarProponente(){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.proponenteServicio.buscarTodosProponente());
        }catch( Exception error){

            ProponenteErrorDTO errorPersonalizado=new ProponenteErrorDTO();
            errorPersonalizado.setMensajeError(error.getMessage());

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(errorPersonalizado.getMensajeError());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> modificarProponente(@RequestBody Proponente datosRecibidos, @PathVariable Integer id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(this.proponenteServicio.modificarProponente(id, datosRecibidos));
        } catch (Exception error) {

            ProponenteErrorDTO errorPersonalizado = new ProponenteErrorDTO();
            errorPersonalizado.setMensajeError(error.getMessage());

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorPersonalizado.getMensajeError());
        }
    }
    @DeleteMapping(value = "/proponente/{id}")
    public Optional<ResponseEntity<?>> eliminar(@PathVariable int id){

        Boolean result = proponenteServicio.eliminaProponente(id);

        if(result){
            return Optional.of(ResponseEntity.noContent().build());
        }
        return Optional.of(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }
}
