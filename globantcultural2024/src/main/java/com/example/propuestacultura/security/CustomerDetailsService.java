package com.example.propuestacultura.security;
import com.example.propuestacultura.models.Representante;
import com.example.propuestacultura.repositorios.IRepresentanteRepositorio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Objects;

@Service
public class CustomerDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerDetailsService.class);

    @Autowired
    private IRepresentanteRepositorio iRepresentanteRepositorio;

    private Representante representanteDetail;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Dentro de loadUserByUsername {}", username);
        representanteDetail = iRepresentanteRepositorio.findByCorreo(username);

        if (!Objects.isNull(representanteDetail)){
            return new org.springframework.security.core.userdetails.User(representanteDetail.getCorreo(), representanteDetail.getPassword(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
    }
    public Representante getRepresentanteDetail(){
        return representanteDetail;
    }
}

