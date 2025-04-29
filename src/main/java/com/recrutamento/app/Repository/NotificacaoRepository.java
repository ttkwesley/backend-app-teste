package com.recrutamento.app.Repository;

import com.recrutamento.app.domain.Notificacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotificacaoRepository extends JpaRepository<Notificacao, Long> {

    @Query("SELECT n FROM Notificacao n WHERE n.usuarioDestino.id = :usuarioId AND n.lido = false ORDER BY n.id DESC")
    List<Notificacao> findByUsuarioDestinoIdAndLidoFalse(Long usuarioId);
}
