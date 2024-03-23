package com.example.propuestacultura.services.impl;

import com.example.propuestacultura.DTO.TipoDocumentoDTO;
import com.example.propuestacultura.mapa.ITipoDocumentoMapa;
import com.example.propuestacultura.models.TipoDocumento;
import com.example.propuestacultura.repositorios.ITipODocumentoRepositorio;
import com.example.propuestacultura.services.TipoDocumentoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDocumentoServicioImpl implements TipoDocumentoServicio {

    @Autowired
    ITipODocumentoRepositorio iTipODocumentoRepositorio;

    @Autowired
    ITipoDocumentoMapa iTipoDocumentoMapa;

    //Rutina para guardar en BD un tipoDocumento
    @Override
    public TipoDocumentoDTO agregarTipODocumento(TipoDocumento datosTipoDocumento) throws Exception{
        try{
            //validar primero

            //llamar al repo para ejecutar la consulta
            return this.iTipoDocumentoMapa.tipoDocumentoToDTO(this.iTipODocumentoRepositorio.save(datosTipoDocumento));


        }catch(Exception error){
            throw new Exception(error.getMessage());

        }

    }


    //RUTINA PARA BUSCAR UN ELEMENTO DENTRO BD POR ID
    @Override
    public TipoDocumentoDTO buscarTipoDocumentoPorId(Integer id) throws Exception {
        Optional<TipoDocumento> tipoDocumentoOptional = this.iTipODocumentoRepositorio.findById(id);
        if (tipoDocumentoOptional.isPresent()) {
            return this.iTipoDocumentoMapa.tipoDocumentoToDTO(tipoDocumentoOptional.get());
        } else {
            throw new Exception("Tipo de documento no encontrado con el ID proporcionado: " + id);
        }
    }

    @Override
    public List<TipoDocumentoDTO> buscarTodosTiposDocumentos() throws Exception{
        try{
            return this.iTipoDocumentoMapa.toDtoList(iTipODocumentoRepositorio.findAll());

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    @Override
    public TipoDocumentoDTO modificarTipoDocumento(Integer id, TipoDocumento tipoDocumento) throws Exception{
        try{
            if(this.iTipODocumentoRepositorio.findById(id).isPresent()){
                //cambielo
                TipoDocumento objetoEncontrado=this.iTipODocumentoRepositorio.findById(id).get();
                objetoEncontrado.setTipo_documento(tipoDocumento.getTipo_documento());
                return this.iTipoDocumentoMapa.tipoDocumentoToDTO(iTipODocumentoRepositorio.save(objetoEncontrado));
            }else{
                //diga que no esta
                throw new Exception("Tipo Documento no encontrado");
            }

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }
    @Override
    public Boolean eliminaTipoDocumento(Integer id){
        Optional<TipoDocumento> eliminarTipoDocumento = iTipODocumentoRepositorio.findById(id);

        if (eliminarTipoDocumento.isEmpty())
            return false;

        iTipODocumentoRepositorio.deleteById(id);

        return true;
    }

}
