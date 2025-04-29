package com.recrutamento.app.controler;

import com.recrutamento.app.domain.Notificacao;
import com.recrutamento.app.service.NotificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("alert")
public class NotificacaoControler {

    @Autowired
    private NotificacaoService notificacaoService;

    @PostMapping("/send")
    public ResponseEntity<?> sendNotification(@RequestParam String idUsuario, @RequestParam String mensagem) {
        notificacaoService.enviarNotificacao(idUsuario, mensagem);
        return ResponseEntity.ok("Notificacao enviada");
    }

    @GetMapping("/get/{usuarioId}")
    public ResponseEntity<List<Notificacao>> buscarNotificacao(@PathVariable Long usuarioId) {
        try {
            List<Notificacao> notificacao = notificacaoService.buscarNotificacao(usuarioId);
            return ResponseEntity.ok(notificacao);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
