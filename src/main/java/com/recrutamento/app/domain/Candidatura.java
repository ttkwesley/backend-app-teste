package com.recrutamento.app.domain;

import jakarta.persistence.*;

@Entity
public class Candidatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private CadastroUsuario usuario;

    @ManyToOne
    @JoinColumn(name = "vaga_id", referencedColumnName = "id")
    private CadastroVaga vaga;

    @Column(columnDefinition = "TEXT")
    private String feedback;

    private String statusCandidatura;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getStatusCandidatura() {
        return statusCandidatura;
    }

    public void setStatusCandidatura(String statusCandidatura) {
        this.statusCandidatura = statusCandidatura;
    }

    public CadastroUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(CadastroUsuario usuario) {
        this.usuario = usuario;
    }

    public CadastroVaga getVaga() {
        return vaga;
    }

    public void setVaga(CadastroVaga vaga) {
        this.vaga = vaga;
    }

    public String getStatus() {
        return statusCandidatura;
    }

    public void setStatus(String status) {
        this.statusCandidatura = status;
    }
}
