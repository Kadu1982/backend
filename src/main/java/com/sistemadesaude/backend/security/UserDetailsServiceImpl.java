package com.sistemadesaude.backend.security;

import com.sistemadesaude.backend.model.Operador;
import com.sistemadesaude.backend.repository.OperadorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final OperadorRepository operadorRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Operador operador = operadorRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("Operador não encontrado"));

        return User.builder()
                .username(operador.getLogin())
                .password(operador.getSenha())
                .authorities(Collections.emptyList()) // Substituir por roles/perfis no futuro
                .build();
    }
}
