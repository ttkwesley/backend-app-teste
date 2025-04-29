package com.recrutamento.app.controler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.recrutamento.app.domain.CadastroUsuario;
import com.recrutamento.app.service.CadastroUsuarioService;
import java.util.HashMap;
import java.util.Map;

@RestController
@Controller
@RequestMapping("user")
public class CadastroUsuarioController {
    
    private final CadastroUsuarioService cadastroUsuarioService;

    public CadastroUsuarioController(CadastroUsuarioService cadastroUsuarioService){
        this.cadastroUsuarioService = cadastroUsuarioService; 
    }

    @PostMapping("/cadastro")
    public ResponseEntity<?> cadastrarUsuario (@RequestBody CadastroUsuario cadastroUsuario) {
        try {
            CadastroUsuario usuarioCadastrado = cadastroUsuarioService.cadastrarUsuario(cadastroUsuario);
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCadastrado);
        }catch (IllegalArgumentException e){
           Map<String, String> errorResponse = new HashMap<>();
           errorResponse.put("message", e.getMessage());
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }
    
}
