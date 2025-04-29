package com.recrutamento.app.Repository;

import com.recrutamento.app.domain.Candidatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CandidaturaRepository extends JpaRepository<Candidatura, Long> {

    Optional<Candidatura> findByUsuarioIdAndVagaId(Long usuarioId, Long vagaId);

    @Query("SELECT c FROM Candidatura c WHERE c.usuario.id = :idUsuario")
    List<Candidatura> findCandidaturasByIdUser(Long idUsuario);

    @Query("SELECT c FROM Candidatura c WHERE c.vaga.id = :idVaga and c.usuario.id = :idUser")
    Candidatura findCandidaduraByVagaIdAndIdUser(Long idVaga, Long idUser);

    @Query("SELECT c FROM Candidatura c WHERE c.vaga.id = :idVaga")
    List<Candidatura> findAllCandidaduraByVagaId(Long idVaga);
}
