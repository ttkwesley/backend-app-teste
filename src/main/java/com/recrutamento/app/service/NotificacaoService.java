package com.recrutamento.app.service;

import com.recrutamento.app.domain.Notificacao;

import javax.management.Notification;
import java.util.List;

public interface NotificacaoService {

    public void enviarNotificacao(String usuarioDestinoId, String mensagem);

    public List<Notificacao> buscarNotificacao(Long idDestino);
}