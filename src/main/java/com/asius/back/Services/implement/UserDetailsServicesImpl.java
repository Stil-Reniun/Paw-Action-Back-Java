package com.asius.back.Services.implement;

import com.asius.back.Entity.UsuariosEntity;
import com.asius.back.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServicesImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository userepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuariosEntity userload = userepo.findByUsername(username);
        if (userload ==null){
            throw new UsernameNotFoundException ("Usuario No encontrado");
        }
        return userload;
    }


}
