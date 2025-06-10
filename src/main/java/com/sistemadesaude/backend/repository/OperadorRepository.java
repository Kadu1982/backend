package com.sistemadesaude.backend.repository;

import com.sistemadesaude.backend.model.Operador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OperadorRepository extends JpaRepository<Operador, Long> {
    Optional<Operador> findByLogin(String login);
    Optional<Operador> findByCpf(String cpf);
    Optional<Operador> findByTemplateId(String templateId);

    boolean existsByLogin(String login);

}
