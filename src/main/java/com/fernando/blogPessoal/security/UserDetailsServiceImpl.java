package com.fernando.blogPessoal.security;


import com.fernando.blogPessoal.model.Usuario;
import com.fernando.blogPessoal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String userName){
        Optional<Usuario> user = repository.findByUsuario(userName);
        user.orElseThrow(() -> new UsernameNotFoundException(userName + "not found."));

        return user.map(UserDetailsImpl::new).get();
    }
}
