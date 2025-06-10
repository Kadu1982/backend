package com.sistemadesaude.backend.service;

import com.sistemadesaude.backend.model.Operador;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    /**
     * Extrai informações do operador para uso em autenticação,
     * token JWT ou sessão frontend.
     */
    public Map<String, Object> extrairDadosOperador(Operador operador) {
        Map<String, Object> dados = new HashMap<>();

        dados.put("login", operador.getLogin());
        dados.put("cargo", operador.getCargo());
        dados.put("unidadeAtual", operador.getUnidadeAtual());

        if (operador.getUnidadeSaude() != null) {
            dados.put("unidadeId", operador.getUnidadeSaude().getId());
            dados.put("unidadeNome", operador.getUnidadeSaude().getNomeCnes()); // corrigido aqui
        }

        return dados;
    }
}
