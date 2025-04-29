package com.recrutamento.app.service.impl;

import com.recrutamento.app.Repository.CadastroUsuarioRepository;
import com.recrutamento.app.Repository.NotificacaoRepository;
import com.recrutamento.app.domain.CadastroUsuario;
import com.recrutamento.app.domain.Notificacao;
import com.recrutamento.app.service.NotificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class NotificacaoServiceImpl implements NotificacaoService {

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    @Autowired
    private CadastroUsuarioRepository cadastroUsuarioRepository;

    public void enviarNotificacao(String usuarioDestinoId, String mensagem) {
        CadastroUsuario usuario = (CadastroUsuario) this.cadastroUsuarioRepository.findByUsername(usuarioDestinoId);
        String mensagemNotify = "Uma nova candidatura para a vaga: " + mensagem;
        Notificacao notificacao = new Notificacao();
        notificacao.setUsuarioDestino(usuario);
        notificacao.setMensagem(mensagemNotify);
        notificacao.setDataCriacao(LocalDateTime.now());
        notificacaoRepository.save(notificacao);
    }

    @Override
    public List<Notificacao> buscarNotificacao(Long idDestino) {
        List<Notificacao> notificacoes = this.notificacaoRepository.findByUsuarioDestinoIdAndLidoFalse(idDestino);
        if (notificacoes == null || notificacoes.isEmpty()) {
            return Collections.emptyList();
        }
        return notificacoes;
    }
}


