package com.sistemadesaude.backend.controller;

import com.sistemadesaude.backend.dto.LoginRequest;
import com.sistemadesaude.backend.dto.LoginResponse;
import com.sistemadesaude.backend.dto.RegistroRequest;
import com.sistemadesaude.backend.model.Operador;
import com.sistemadesaude.backend.repository.OperadorRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final OperadorRepository operadorRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getLogin(),
                        loginRequest.getSenha()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        Optional<Operador> operadorOptional = operadorRepository.findByLogin(loginRequest.getLogin());
        if (operadorOptional.isEmpty()) {
            return ResponseEntity.status(404).body(new LoginResponse("Operador não encontrado", null));
        }

        Operador operador = operadorOptional.get();

        return ResponseEntity.ok(
                new LoginResponse("Login realizado com sucesso!", operador.getNome())
        );
    }

    @PostMapping("/registrar")
    public ResponseEntity<String> registrar(@RequestBody @Valid RegistroRequest registroRequest) {
        if (operadorRepository.findByLogin(registroRequest.getLogin()).isPresent()) {
            return ResponseEntity.badRequest().body("Login já está em uso.");
        }

        Operador novoOperador = Operador.builder()
                .nome(registroRequest.getNome())
                .email(registroRequest.getEmail())
                .login(registroRequest.getLogin())
                .senha(passwordEncoder.encode(registroRequest.getSenha()))
                .perfil(registroRequest.getPerfil())
                .build();

        operadorRepository.save(novoOperador);
        return ResponseEntity.ok("Operador registrado com sucesso!");
    }
}
