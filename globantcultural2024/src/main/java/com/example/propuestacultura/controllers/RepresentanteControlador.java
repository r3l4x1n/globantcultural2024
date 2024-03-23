package com.example.propuestacultura.controllers;

import com.example.propuestacultura.DTO.errorDTO.RepresentanteErrorDTO;
import com.example.propuestacultura.constants.Constants;
import com.example.propuestacultura.models.Representante;
import com.example.propuestacultura.services.impl.RepresentanteServicioImpl;
import com.example.propuestacultura.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v7/representante")
public class RepresentanteControlador {

    @Autowired
    RepresentanteServicioImpl representanteServicio;

    @PostMapping("/save")
    public ResponseEntity<?> agregarRepresentante(@RequestBody Representante datosRecibidos){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.representanteServicio.agregarRepresentante(datosRecibidos));
        } catch (Exception e) {
            RepresentanteErrorDTO errorPersonalizado = new RepresentanteErrorDTO();
            errorPersonalizado.setMensajeError(e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorPersonalizado.getMensajeError());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?>BuscarRepresentantePorId(@PathVariable Integer id){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.representanteServicio.buscarRepresentantePorId(id));
        }catch( Exception error){

            RepresentanteErrorDTO errorPersonalizado=new RepresentanteErrorDTO();
            errorPersonalizado.setMensajeError(error.getMessage());

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(errorPersonalizado.getMensajeError());
        }

    }
    @GetMapping("/seach")
    public ResponseEntity<?>buscarRepresentante(){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.representanteServicio.buscarTodosLosRepresentantes());
        }catch( Exception error){

            RepresentanteErrorDTO errorPersonalizado=new RepresentanteErrorDTO();
            errorPersonalizado.setMensajeError(error.getMessage());

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(errorPersonalizado.getMensajeError());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> modificarRepresentante(@RequestBody Representante datosRecibidos, @PathVariable Integer id){
        try{
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(this.representanteServicio.modificarRepresentante(id, datosRecibidos));
        }catch( Exception error){

            RepresentanteErrorDTO errorPersonalizado=new RepresentanteErrorDTO();
            errorPersonalizado.setMensajeError(error.getMessage());

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorPersonalizado.getMensajeError());
        }
    }
    @DeleteMapping(value = "/representante/{id}")
    public Optional<ResponseEntity<?>> eliminar(@PathVariable int id){

        Boolean result = representanteServicio.eliminaRepresentante(id);

        if(result){
            return Optional.of(ResponseEntity.noContent().build());
        }
        return Optional.of(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> requestMap){
        try {
            return representanteServicio.login(requestMap);
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return Utils.getResponseEntity(Constants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
