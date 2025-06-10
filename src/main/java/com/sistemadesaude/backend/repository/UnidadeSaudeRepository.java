package com.sistemadesaude.backend.repository;

import com.sistemadesaude.backend.model.UnidadeSaude;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UnidadeSaudeRepository extends JpaRepository<UnidadeSaude, Long> {
    Optional<UnidadeSaude> findByCodigoCnes(String codigoCnes);
    boolean existsByCodigoCnes(String codigoCnes);
}
