package com.example.propuestacultura.services.impl;

import com.example.propuestacultura.DTO.RepresentanteDTO;
import com.example.propuestacultura.mapa.IRepresentanteMapa;
import com.example.propuestacultura.models.Representante;
import com.example.propuestacultura.repositorios.IRepresentanteRepositorio;
import com.example.propuestacultura.security.CustomerDetailsService;
import com.example.propuestacultura.security.jwt.JwtUtil;
import com.example.propuestacultura.services.RepresentanteServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class RepresentanteServicioImpl implements RepresentanteServicio {

    private static final Logger logger = LoggerFactory.getLogger(CustomerDetailsService.class);

    @Autowired
    IRepresentanteRepositorio iRepresentanteRepositorio;

    @Autowired
    IRepresentanteMapa iRepresentanteMapa;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomerDetailsService customerDetailsService;

    @Override
    public RepresentanteDTO agregarRepresentante(Representante datosRepresentante) throws Exception{
        try{
            //validar primero

            //llamar al repo para ejecutar la consulta
            return this.iRepresentanteMapa.representanteToDTO(this.iRepresentanteRepositorio.save(datosRepresentante));


        }catch(Exception error){
            throw new Exception(error.getMessage());

        }

    }

    @Override
    public RepresentanteDTO buscarRepresentantePorId(Integer id) throws Exception {
        Optional<Representante> representanteOptional = this.iRepresentanteRepositorio.findById(id);
        if (representanteOptional.isPresent()) {
            return this.iRepresentanteMapa.representanteToDTO(representanteOptional.get());
        } else {
            throw new Exception("Representante no encontrado con el ID proporcionado: " + id);
        }
    }
    @Override
    public List<RepresentanteDTO> buscarTodosLosRepresentantes() throws Exception{
        try{
            return this.iRepresentanteMapa.toDTOList(iRepresentanteRepositorio.findAll());

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }
    @Override
    public RepresentanteDTO modificarRepresentante(Integer id, Representante representante) throws Exception{
        try{
            if(this.iRepresentanteRepositorio.findById(id).isPresent()){
                //cambielo
                Representante objetoEncontrado=this.iRepresentanteRepositorio.findById(id).get();
                objetoEncontrado.setId_representante(representante.getId_representante());
                objetoEncontrado.setTipoDocumento(representante.getTipoDocumento());
                objetoEncontrado.setCorreo(representante.getCorreo());
                objetoEncontrado.setPrimer_nombre(representante.getPrimer_nombre());
                objetoEncontrado.setPrimer_apellido(representante.getPrimer_apellido());
                objetoEncontrado.setTelefono_celular(representante.getTelefono_celular());
                objetoEncontrado.setTelefono_fijo(representante.getTelefono_fijo());
                objetoEncontrado.setNumero_documento(representante.getNumero_documento());

                return this.iRepresentanteMapa.representanteToDTO(iRepresentanteRepositorio.save(objetoEncontrado));
            }else{
                //diga que no esta
                throw new Exception("Representante no encontrado");
            }

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }
    @Override
    public Boolean eliminaRepresentante(Integer id){
        Optional<Representante> eliminarRepresentante = iRepresentanteRepositorio.findById(id);

        if (eliminarRepresentante.isEmpty())
            return false;

        iRepresentanteRepositorio.deleteById(id);

        return true;
    }
    @Override
    public ResponseEntity<String> login(Map<String, String> requestMap) {
        logger.info("Dentro de login");
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(requestMap.get("correo_electronico"), requestMap.get("password"))
            );
            if (authentication.isAuthenticated()) {
                if (customerDetailsService.getRepresentanteDetail().getStatus()) {
                    String token = jwtUtil.generateToken(customerDetailsService.getRepresentanteDetail().getCorreo(),
                            String.valueOf(customerDetailsService.getRepresentanteDetail().getId_representante()));
                    return ResponseEntity.ok("{\"token\":\"" + token + "\"}");
                } else {
                    return ResponseEntity.badRequest().body("{\"mensaje\":\"Espere la aprobacion del administrador\"}");
                }
            }
        } catch (Exception exception) {
            logger.error("{}", exception);
        }
        return ResponseEntity.badRequest().body("{\"mensaje\":\"credenciales incorrectas\"}");
    }


}
