package com.recrutamento.app.service.impl;

import com.recrutamento.app.Repository.CadastroUsuarioRepository;
import com.recrutamento.app.Repository.CadastroVagasRepository;
import com.recrutamento.app.Repository.CandidaturaRepository;
import com.recrutamento.app.domain.CadastroUsuario;
import com.recrutamento.app.domain.CadastroVaga;
import com.recrutamento.app.domain.Candidatura;
import com.recrutamento.app.service.CandidaturaService;
import com.recrutamento.app.service.NotificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidaturaServiceImpl implements CandidaturaService {

    @Autowired
    private NotificacaoService notificacaoService;

    @Autowired
    private CandidaturaRepository candidaturaRepository;

    @Autowired
    private CadastroUsuarioRepository cadastroUsuarioRepository;

    @Autowired
    private CadastroVagasRepository cadastroVagasRepository;

    @Override
    public Candidatura candidatar(Long usuarioId, Long vagaId) {
        try {
            Optional<CadastroUsuario> usuario = this.cadastroUsuarioRepository.findById(usuarioId);
            Optional<CadastroVaga> vaga = this.cadastroVagasRepository.findById(vagaId);
            Optional<Candidatura> candidaturaExiste = candidaturaRepository.findByUsuarioIdAndVagaId(usuarioId, vagaId);

            if(candidaturaExiste.isPresent()){
                throw new RuntimeException("Você já se candidatou a essa vaga.");
            }

            String username = vaga.get().getCriadoPor();
            CadastroUsuario criadorVaga = (CadastroUsuario) this.cadastroUsuarioRepository.findByUsername(username);
            notificacaoService.enviarNotificacao(criadorVaga.getUsername(), vaga.get().getTitulo());

            Candidatura candidatura = new Candidatura();
            candidatura.setUsuario(usuario.get());
            candidatura.setVaga(vaga.get());
            candidatura.setStatus("Pendente");

            return  candidaturaRepository.save(candidatura);
        }catch (Exception e){
            throw new RuntimeException("Erro ao tentar registrar a candidatura");
        }
    }

    @Override
    public List<Candidatura> buscarCandidaturas(Long idUsuario) {
        List<Candidatura> candidaturas = this.candidaturaRepository.findCandidaturasByIdUser(idUsuario);
        return candidaturas;
    }

    @Override
    public List<Candidatura> buscarCandidaturasPorIdVaga(Long idVaga) {
        List<Candidatura> candidaturas = this.candidaturaRepository.findAllCandidaduraByVagaId(idVaga);
        return candidaturas;
    }

    @Override
    public Candidatura buscarPorIdVaga(Long idVaga, String feedback, String novoStatus, Long idUser) {
        Candidatura candidatura = this.candidaturaRepository.findCandidaduraByVagaIdAndIdUser(idVaga, idUser);

        if(candidatura.getId() != null){
            candidatura.setFeedback(feedback);
            candidatura.setStatus(novoStatus);

            Optional<CadastroUsuario> usuario = cadastroUsuarioRepository.findById(idUser);
            notificacaoService.enviarNotificacao(usuario.get().getUsername(), "Voce recebeu um feedback");

            this.candidaturaRepository.save(candidatura);
            return candidatura;
        }

        throw new IllegalArgumentException("Nao foi possivel buscar a vaga");
    }
}
