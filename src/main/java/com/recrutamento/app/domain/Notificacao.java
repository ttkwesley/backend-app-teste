package com.recrutamento.app.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private CadastroUsuario usuarioDestino;

    private String mensagem;

    private boolean lido = false;

    @CreationTimestamp
    private LocalDateTime dataCriacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public boolean isLido() {
        return lido;
    }

    public void setLido(boolean lido) {
        this.lido = lido;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public CadastroUsuario getUsuarioDestino() {
        return usuarioDestino;
    }

    public void setUsuarioDestino(CadastroUsuario usuarioDestino) {
        this.usuarioDestino = usuarioDestino;
    }
}
