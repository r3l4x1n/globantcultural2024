package com.example.propuestacultura.services.impl;

import com.example.propuestacultura.DTO.ProponenteDTO;
import com.example.propuestacultura.mapa.IProponenteMapa;
import com.example.propuestacultura.models.Proponente;
import com.example.propuestacultura.repositorios.IProponenteRepositorio;
import com.example.propuestacultura.services.ProponenteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProponenteServicioImpl implements ProponenteServicio {

    @Autowired
    IProponenteMapa iProponenteMapa;

    @Autowired
    IProponenteRepositorio iProponenteRepositorio;

    @Override
    public ProponenteDTO agregarProponente(Proponente datosProponente) throws Exception {
        try {
            //validar primero

            //llamar al repo para ejecutar la consulta
            return this.iProponenteMapa.proponenteToDTO(this.iProponenteRepositorio.save(datosProponente));


        } catch (Exception error) {
            throw new Exception(error.getMessage());

        }
    }

    @Override
    public ProponenteDTO buscarProponentePorId(Integer id) throws Exception {
        Optional<Proponente> proponenteOptional = this.iProponenteRepositorio.findById(id);
        if (proponenteOptional.isPresent()) {
            return this.iProponenteMapa.proponenteToDTO(proponenteOptional.get());
        } else {
            throw new Exception(" proponente no encontrado con el ID proporcionado: " + id);
        }
    }

    @Override
    public List<ProponenteDTO> buscarTodosProponente() throws Exception {
        try {
            return this.iProponenteMapa.toDTOList(iProponenteRepositorio.findAll());

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public ProponenteDTO modificarProponente(Integer id, Proponente Proponente) throws Exception {
        try {
            if (this.iProponenteRepositorio.findById(id).isPresent()) {
                //cambielo
                Proponente objetoEncontrado = this.iProponenteRepositorio.findById(id).get();
                objetoEncontrado.setProponente_id(Proponente.getProponente_id());
                objetoEncontrado.setNombre_proponente(Proponente.getNombre_proponente());
                objetoEncontrado.setTrayectoria(Proponente.getTrayectoria());
                objetoEncontrado.setRepresentante(Proponente.getRepresentante());
                objetoEncontrado.setTipoProponente(Proponente.getTipoProponente());

                return this.iProponenteMapa.proponenteToDTO(iProponenteRepositorio.save(objetoEncontrado));
            } else {
                //diga que no esta
                throw new Exception("Tipo Documento no encontrado");
            }

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
    @Override
    public Boolean eliminaProponente(Integer id){
        Optional<Proponente> eliminarProponente = iProponenteRepositorio.findById(id);

        if (eliminarProponente.isEmpty())
            return false;

        iProponenteRepositorio.deleteById(id);

        return true;
    }

}
