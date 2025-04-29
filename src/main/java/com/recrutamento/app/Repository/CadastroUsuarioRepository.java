package com.recrutamento.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.recrutamento.app.domain.CadastroUsuario;

@Repository
public interface CadastroUsuarioRepository extends JpaRepository<CadastroUsuario, Long>{

     UserDetails findByUsername(String username);

}
