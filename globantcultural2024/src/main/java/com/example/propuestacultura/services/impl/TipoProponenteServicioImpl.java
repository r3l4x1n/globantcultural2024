package com.example.propuestacultura.services.impl;

import com.example.propuestacultura.DTO.TipoProponenteDTO;
import com.example.propuestacultura.mapa.ITipoProponenteMapa;
import com.example.propuestacultura.models.TipoProponente;
import com.example.propuestacultura.repositorios.ITipoProponenteRepositorio;
import com.example.propuestacultura.services.TipoProponenteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoProponenteServicioImpl implements TipoProponenteServicio {

    @Autowired
    ITipoProponenteRepositorio iTipoProponenteRepositorio;

    @Autowired
    ITipoProponenteMapa iTipoProponenteMapa;


    @Override
    public TipoProponenteDTO agregarTipoProponente(TipoProponente datosTipoDocumento) throws Exception {
        try {
            //validar primero

            //llamar al repo para ejecutar la consulta
            return this.iTipoProponenteMapa.tipoproponenteToDTO(this.iTipoProponenteRepositorio.save(datosTipoDocumento));


        } catch (Exception error) {
            throw new Exception(error.getMessage());

        }

    }

    @Override
    public TipoProponenteDTO buscarTipoProponentePorId(Integer id) throws Exception {
        Optional<TipoProponente> tipoProponenteOptional = this.iTipoProponenteRepositorio.findById(id);
        if (tipoProponenteOptional.isPresent()) {
            return this.iTipoProponenteMapa.tipoproponenteToDTO(tipoProponenteOptional.get());
        } else {
            throw new Exception("Tipo de proponente no encontrado con el ID proporcionado: " + id);
        }
    }

    @Override
    public List<TipoProponenteDTO> buscarTodosTipoProponente() throws Exception {
        try {
            return this.iTipoProponenteMapa.toDTOList(iTipoProponenteRepositorio.findAll());

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public TipoProponenteDTO modificarTipoproponente(Integer id, TipoProponente tipoProponente) throws Exception {
        try {
            if (this.iTipoProponenteRepositorio.findById(id).isPresent()) {
                //cambielo
                TipoProponente objetoEncontrado = this.iTipoProponenteRepositorio.findById(id).get();
                objetoEncontrado.setTipo_proponente(tipoProponente.getTipo_proponente());
                return this.iTipoProponenteMapa.tipoproponenteToDTO(iTipoProponenteRepositorio.save(objetoEncontrado));
            } else {
                //diga que no esta
                throw new Exception("Tipo Documento no encontrado");
            }


        }catch(Exception error) {
            throw new Exception(error.getMessage());
        }
    }
    @Override
    public Boolean eliminaTipoProponente(Integer id){
        Optional<TipoProponente> eliminarTipoProponente = iTipoProponenteRepositorio.findById(id);

        if (eliminarTipoProponente.isEmpty())
            return false;

        iTipoProponenteRepositorio.deleteById(id);

        return true;
    }

}