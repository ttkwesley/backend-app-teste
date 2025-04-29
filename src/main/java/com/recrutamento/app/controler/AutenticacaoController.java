package com.recrutamento.app.controler;

import com.recrutamento.app.config.TokenService;
import com.recrutamento.app.domain.CadastroUsuario;
import com.recrutamento.app.domain.UserAuthDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login (@RequestBody UserAuthDto data){
        var emailPassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var auth = this.authenticationManager.authenticate(emailPassword);

        var token = tokenService.geraToken((CadastroUsuario) auth.getPrincipal());

        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        response.put("role", ((CadastroUsuario) auth.getPrincipal()).getRole().getRole());
        response.put("idUsuario", ((CadastroUsuario) auth.getPrincipal()).getId().toString());
        response.put("nomeUsuario", ((CadastroUsuario) auth.getPrincipal()).getNomeUsuario());

        return ResponseEntity.ok(response);
    }

}
