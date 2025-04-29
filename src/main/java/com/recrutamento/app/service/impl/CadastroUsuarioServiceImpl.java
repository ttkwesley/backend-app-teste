package com.recrutamento.app.service.impl;

import com.recrutamento.app.domain.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.recrutamento.app.Repository.CadastroUsuarioRepository;
import com.recrutamento.app.domain.CadastroUsuario;
import com.recrutamento.app.service.CadastroUsuarioService;

@Service
public class CadastroUsuarioServiceImpl implements CadastroUsuarioService {

    @Autowired
    private final CadastroUsuarioRepository cadastroUsuarioRepository;

    public CadastroUsuarioServiceImpl(CadastroUsuarioRepository cadastroUsuarioRepository) {
        this.cadastroUsuarioRepository = cadastroUsuarioRepository;
    }

    @Override
    public CadastroUsuario cadastrarUsuario(CadastroUsuario cadastroUsuario) {
        UserDetails usuarioExistente = this.cadastroUsuarioRepository.findByUsername(cadastroUsuario.getUsername());
        if (usuarioExistente != null) {
            throw new IllegalArgumentException("Email já cadastrado");
        }

        cadastroUsuario.setStatus(true);
        cadastroUsuario.setRole(UserRole.USER);
        return this.cadastroUsuarioRepository.save(cadastroUsuario);
    }
}
