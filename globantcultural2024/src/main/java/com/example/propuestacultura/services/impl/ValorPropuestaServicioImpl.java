package com.example.propuestacultura.services.impl;

import com.example.propuestacultura.DTO.ValorPropuestaDTO;
import com.example.propuestacultura.mapa.IValorPropuestaMapa;
import com.example.propuestacultura.models.ValorPropuesta;
import com.example.propuestacultura.repositorios.IValorPropuestaRepositorio;
import com.example.propuestacultura.services.ValorPropuestaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ValorPropuestaServicioImpl implements ValorPropuestaServicio {

    @Autowired
    IValorPropuestaRepositorio iValorPropuestaRepositorio;

    @Autowired
    IValorPropuestaMapa iValorPropuestaMapa;

    @Override
    public ValorPropuestaDTO agregarValorPropuesta(ValorPropuesta datosTipoDocumento) throws Exception {
        try {
            //validar primero
            System.out.println("oeoeoeoeoeoeoeoeoe");
            System.out.println(datosTipoDocumento.getPropuesta().getId_propuesta());

            //llamar al repo para ejecutar la consulta
            return this.iValorPropuestaMapa.valorToDTO(this.iValorPropuestaRepositorio.save(datosTipoDocumento));


        } catch (Exception error) {
            throw new Exception(error.getMessage());

        }
    }

    @Override
    public ValorPropuestaDTO buscarValorPropuestaPorId(Integer id) throws Exception {
        Optional<ValorPropuesta> valorPropuestaOptional = this.iValorPropuestaRepositorio.findById(id);
        if (valorPropuestaOptional.isPresent()) {
            return this.iValorPropuestaMapa.valorToDTO(valorPropuestaOptional.get());
        } else {
            throw new Exception("Valor propuesta no encontrado con el ID proporcionado: " + id);
        }
    }
    @Override
    public List<ValorPropuestaDTO> buscarTodosValorPropuesta() throws Exception {
        try {
            return this.iValorPropuestaMapa.toDTOList(iValorPropuestaRepositorio.findAll());

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public ValorPropuestaDTO modificarValorPropuesta(Integer id, ValorPropuesta valorPropuesta) throws Exception {
        try {
            if (this.iValorPropuestaRepositorio.findById(id).isPresent()) {
                //cambielo
               ValorPropuesta objetoEncontrado = this.iValorPropuestaRepositorio.findById(id).get();
                objetoEncontrado.setPropuesta(valorPropuesta.getPropuesta());
                objetoEncontrado.setId(valorPropuesta.getId());
                objetoEncontrado.setAporte_comfama(valorPropuesta.getAporte_comfama());
                objetoEncontrado.setMonto_total_propuesta(valorPropuesta.getMonto_total_propuesta());
                return this.iValorPropuestaMapa.valorToDTO(iValorPropuestaRepositorio.save(objetoEncontrado));
            } else {
                //diga que no esta
                throw new Exception("Valor Propuesta no encontrado");
            }


        }catch(Exception error) {
            throw new Exception(error.getMessage());
        }
    }
    @Override
    public Boolean eliminarValorPropuesta(Integer id){
        Optional<ValorPropuesta> eliminarValorPropuesta = iValorPropuestaRepositorio.findById(id);

        if (eliminarValorPropuesta.isEmpty())
            return false;

        iValorPropuestaRepositorio.deleteById(id);

        return true;
    }

}
