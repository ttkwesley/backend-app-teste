package com.recrutamento.app.controler;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.recrutamento.app.domain.CadastroVaga;
import com.recrutamento.app.service.CadastroVagaService;

@RestController
@Controller
@RequestMapping("vagas")
public class CadastroVagaController {

    private final CadastroVagaService cadastroVagaService;

    public CadastroVagaController(CadastroVagaService cadastroVagaService){
        this.cadastroVagaService = cadastroVagaService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<CadastroVaga> cadastrarVaga(@RequestBody CadastroVaga cadastroVaga) {
        CadastroVaga vagaCadastrada =  cadastroVagaService.cadastrarVaga(cadastroVaga);
        return ResponseEntity.status(HttpStatus.CREATED).body(vagaCadastrada);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<CadastroVaga>> listarVagas () {
        List<CadastroVaga> listaDeVagas = cadastroVagaService.listarVagas();

        return ResponseEntity.ok(listaDeVagas);
    }

    @PostMapping("/editar/{id}")
    public ResponseEntity<String> editarVaga(@PathVariable("id") String idVaga, @RequestBody CadastroVaga vagaAtualizada) {
        try {
            this.cadastroVagaService.editarVaga(idVaga, vagaAtualizada);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/remover/{id}")
    public ResponseEntity<String> removerVaga(@PathVariable("id") String idVaga) {
        this.cadastroVagaService.removerVaga(idVaga);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
