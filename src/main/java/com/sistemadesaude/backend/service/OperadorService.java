package com.sistemadesaude.backend.service;

import com.sistemadesaude.backend.dto.OperadorDTO;
import com.sistemadesaude.backend.model.Operador;
import com.sistemadesaude.backend.repository.OperadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OperadorService {

    @Autowired
    private OperadorRepository operadorRepository;

    public Optional<Operador> buscarPorLogin(String login) {
        return operadorRepository.findByLogin(login);
    }

    public Operador salvar(Operador operador) {
        return operadorRepository.save(operador);
    }

    public OperadorDTO converterParaDTO(Operador operador) {
        OperadorDTO dto = new OperadorDTO();
        dto.setId(operador.getId());
        dto.setNome(operador.getNome());
        dto.setLogin(operador.getLogin());
        dto.setCargo(operador.getCargo());
        dto.setUnidadeAtual(operador.getUnidadeAtual());

        if (operador.getUnidadeSaude() != null) {
            dto.setUnidadeId(operador.getUnidadeSaude().getId());
        }

        dto.setEmail(operador.getEmail());
        dto.setCpf(operador.getCpf());
        dto.setPerfil(operador.getPerfil());
        dto.setPerfis(operador.getPerfis());
        dto.setPermissoes(operador.getPermissoes());
        dto.setTemplateId(operador.getTemplateId());

        return dto;
    }
}
