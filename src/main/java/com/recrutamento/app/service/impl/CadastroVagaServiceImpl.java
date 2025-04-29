package com.recrutamento.app.service.impl;

import java.util.List;
import java.util.Optional;

import com.recrutamento.app.Repository.CadastroUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.recrutamento.app.Repository.CadastroVagasRepository;
import com.recrutamento.app.domain.CadastroVaga;
import com.recrutamento.app.service.CadastroVagaService;

@Service
public class CadastroVagaServiceImpl implements  CadastroVagaService{

    @Autowired
    private CadastroUsuarioRepository cadastroUsuarioRepository;

    private final CadastroVagasRepository cadastroVagasRepository; 

    public CadastroVagaServiceImpl(CadastroVagasRepository cadastroVagasRepository){
        this.cadastroVagasRepository = cadastroVagasRepository; 
    }
    
    @Override
    public CadastroVaga cadastrarVaga(CadastroVaga cadastroVaga){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String usernome = authentication.getName();
        cadastroVaga.setStatus(true);
        cadastroVaga.setCriadoPor(usernome);
        CadastroVaga vagaCadastrada = cadastroVagasRepository.save(cadastroVaga);
        return vagaCadastrada;
    }

    @Override
    public void editarVaga(String idVaga, CadastroVaga vagaAtualizada) {
        Long idConveert = Long.parseLong(idVaga);
        Optional<CadastroVaga> vaga = this.cadastroVagasRepository.findById(idConveert);

        if(vaga.isPresent()){
            CadastroVaga vagaExistente = vaga.get();
            vagaExistente.setDescricao(vagaAtualizada.getDescricao());
            vagaExistente.setRequisitos(vagaAtualizada.getRequisitos());
            vagaExistente.setTitulo(vagaAtualizada.getTitulo());

            this.cadastroVagasRepository.save(vagaExistente);
        }else {
            throw new IllegalArgumentException("Vaga nao encontrada, id da vaga: " + idVaga);
        }
    }

    @Override
    public List<CadastroVaga> listarVagas(){
        List<CadastroVaga> listaDeVagas = cadastroVagasRepository.findAll(); 
        return listaDeVagas; 
    }

    @Override
    public void removerVaga(String idVaga){
        Long idConveert = Long.parseLong(idVaga);
        Optional<CadastroVaga> vaga = this.cadastroVagasRepository.findById(idConveert);
        vaga.get().setStatus(false);
        this.cadastroVagasRepository.save(vaga.get());
    }
}
