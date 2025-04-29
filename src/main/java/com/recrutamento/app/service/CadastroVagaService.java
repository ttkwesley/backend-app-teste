package com.recrutamento.app.service;

import java.util.List;

import com.recrutamento.app.domain.CadastroVaga;

public interface  CadastroVagaService {
    
    CadastroVaga cadastrarVaga(CadastroVaga cadastroVaga);

    void editarVaga(String idVaga, CadastroVaga vagaAtualizada);

    List<CadastroVaga> listarVagas();

    void removerVaga(String idVaga);
}
