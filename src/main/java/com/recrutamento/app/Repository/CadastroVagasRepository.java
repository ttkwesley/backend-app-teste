package com.recrutamento.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recrutamento.app.domain.CadastroVaga;

@Repository
public interface  CadastroVagasRepository extends JpaRepository<CadastroVaga, Long> {
    
}
