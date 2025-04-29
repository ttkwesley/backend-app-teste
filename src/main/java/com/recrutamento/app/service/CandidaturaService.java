package com.recrutamento.app.service;

import com.recrutamento.app.domain.Candidatura;

import java.util.List;

public interface CandidaturaService {

    Candidatura candidatar(Long usuarioId, Long vagaId);

    List<Candidatura> buscarCandidaturas(Long idUsuario);

    List<Candidatura> buscarCandidaturasPorIdVaga(Long idVaga);

    Candidatura buscarPorIdVaga(Long idVaga, String feedback , String novoStatus, Long idUser);
}
