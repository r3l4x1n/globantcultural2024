package com.example.propuestacultura.services.impl;

import com.example.propuestacultura.DTO.PropuestaDTO;
import com.example.propuestacultura.mapa.PropuestaMapa;
import com.example.propuestacultura.models.Propuesta;
import com.example.propuestacultura.repositorios.IPropuestaRepositorio;
import com.example.propuestacultura.services.PropuestaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropuestaServicioImpl implements PropuestaServicio {

    @Autowired
    IPropuestaRepositorio iPropuestaRepositorio;

    @Autowired
    PropuestaMapa PropuestaMapa;

    @Override
    public PropuestaDTO guardarPropuesta(Propuesta datosPropuesta)throws Exception{
        try {
            return this.PropuestaMapa.propuestaToDTO(this.iPropuestaRepositorio.save(datosPropuesta));
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    @Override
    public PropuestaDTO buscarPropuesta(Integer id) throws Exception {
        Optional<Propuesta> propuestaOptional = this.iPropuestaRepositorio.findById(id);
        if (propuestaOptional.isPresent()){
            return this.PropuestaMapa.propuestaToDTO(propuestaOptional.get());
        }else {
            throw new Exception("Propuesta no encontrada con el ID proporcionado " + id);
        }
    }
    @Override
    public List<PropuestaDTO> buscarTodasLasPropuestas()throws Exception{
        try {
            return this.PropuestaMapa.toDtoList(iPropuestaRepositorio.findAll());
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    @Override
    public PropuestaDTO modificarPropuesta(Integer id, Propuesta propuesta) throws Exception{
        try {
            if (this.iPropuestaRepositorio.findById(id).isPresent()){
                Propuesta objetosEncontrado = this.iPropuestaRepositorio.findById(id).get();
                objetosEncontrado.setNombre_propuesta(propuesta.getNombre_propuesta());
                objetosEncontrado.setId_propuesta(propuesta.getId_propuesta());
                objetosEncontrado.setDescripcion_propuesta(propuesta.getDescripcion_propuesta());
                objetosEncontrado.setDescripcion_actividades(propuesta.getDescripcion_actividades());
                objetosEncontrado.setFecha_presentacion(propuesta.getFecha_presentacion());
                objetosEncontrado.setFecha_inicio_evento(propuesta.getFecha_inicio_evento());
                objetosEncontrado.setEmpresas_aliadas(propuesta.getEmpresas_aliadas());
                objetosEncontrado.setPublico_beneficiado(propuesta.getPublico_beneficiado());

                return this.PropuestaMapa.propuestaToDTO(iPropuestaRepositorio.save(objetosEncontrado));
            }else {
                throw new Exception("Propuesta no encontrada");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    @Override
    public Boolean eliminarPropuesta(Integer id){
        Optional<Propuesta> eliminarPropuesta = iPropuestaRepositorio.findById(id);

        if (eliminarPropuesta.isEmpty())
            return false;

        iPropuestaRepositorio.deleteById(id);

        return true;
    }
}
