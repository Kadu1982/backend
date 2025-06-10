package com.sistemadesaude.backend.controller;

import com.sistemadesaude.backend.dto.LoginRequest;
import com.sistemadesaude.backend.dto.OperadorDTO;
import com.sistemadesaude.backend.model.Operador;
import com.sistemadesaude.backend.service.OperadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/operadores")
public class OperadorController {

    @Autowired
    private OperadorService operadorService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        return operadorService.buscarPorLogin(loginRequest.getLogin())
                .map(operador -> {
                    if (operador.getSenha().equals(loginRequest.getSenha())) {
                        OperadorDTO dto = operadorService.converterParaDTO(operador);
                        return ResponseEntity.ok(dto);
                    } else {
                        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                                .body("Senha incorreta");
                    }
                })
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body("Usuário não encontrado"));
    }

    @PostMapping
    public ResponseEntity<Operador> salvar(@RequestBody Operador operador) {
        Operador salvo = operadorService.salvar(operador);
        return ResponseEntity.ok(salvo);
    }
}
