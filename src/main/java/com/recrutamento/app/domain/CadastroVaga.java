package com.recrutamento.app.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "cadastro_vaga")
public class CadastroVaga {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column(nullable= false)
    private String titulo; 

    @Column(nullable= false, columnDefinition = "TEXT")
    private String descricao; 

    @Column(nullable= false, columnDefinition = "TEXT")
    private String requisitos; 

    @Column(nullable = false)
    private String criadoPor;

    @Column
    public String getCriadoPor() {
        return criadoPor;
    }

    public void setCriadoPor(String criadoPor) {
        this.criadoPor = criadoPor;
    }

    @Column
    private Boolean status;

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    } 
    
}
