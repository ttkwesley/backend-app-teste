package com.recrutamento.app.controler;

import com.recrutamento.app.domain.Candidatura;
import com.recrutamento.app.domain.FeedbackDto;
import com.recrutamento.app.service.CandidaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/candidaturas")
public class CandidaturaController {

    @Autowired
    private CandidaturaService candidaturaService;

    @PostMapping("/candidatar")
    public ResponseEntity<String> candidatar(@RequestParam Long usuarioId, @RequestParam Long vagaId){
        try {
            Candidatura candidatura = candidaturaService.candidatar(usuarioId, vagaId);
            return ResponseEntity.status(HttpStatus.CREATED).body("Candidatura registrada com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/listar/{idUsuario}")
    public ResponseEntity<List<Candidatura>> visualizar(@PathVariable Long idUsuario) {
        List<Candidatura> candidaturas = this.candidaturaService.buscarCandidaturas(idUsuario);
        return ResponseEntity.ok(candidaturas);
    }

    @PostMapping("/feedback")
    public ResponseEntity<Map<String, String>> atualizarCandidatura(@RequestBody FeedbackDto feedbackDTO){
        Candidatura candidatura = this.candidaturaService.buscarPorIdVaga(feedbackDTO.idVaga(), feedbackDTO.feedback(), feedbackDTO.novoStatus(), feedbackDTO.idUser());
        Map<String, String> response = new HashMap<>();
        response.put("message", "Feedback enviado");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/candidatos/{idVaga}")
    public ResponseEntity<List<Candidatura>> visualizarCandidatos(@PathVariable Long idVaga) {
        List<Candidatura> candidaturas = this.candidaturaService.buscarCandidaturasPorIdVaga(idVaga);
        return ResponseEntity.ok(candidaturas);
    }
}
