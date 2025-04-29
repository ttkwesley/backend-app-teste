package com.recrutamento.app.service;

import com.recrutamento.app.Repository.CadastroUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetailsService   implements UserDetailsService {

    @Autowired
    CadastroUsuarioRepository cadastroUsuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      return cadastroUsuarioRepository.findByUsername(username);
    }
}
