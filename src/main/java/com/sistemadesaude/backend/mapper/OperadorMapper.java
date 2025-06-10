package com.sistemadesaude.backend.mapper;

import com.sistemadesaude.backend.dto.OperadorDTO;
import com.sistemadesaude.backend.model.Operador;
import com.sistemadesaude.backend.model.UnidadeSaude;

public class OperadorMapper {

    public static OperadorDTO toDTO(Operador operador) {
        if (operador == null) return null;

        OperadorDTO dto = new OperadorDTO();
        dto.setId(operador.getId());
        dto.setNome(operador.getNome());
        dto.setLogin(operador.getLogin());
        dto.setSenha(operador.getSenha());
        dto.setCargo(operador.getCargo());
        dto.setUnidadeAtual(operador.getUnidadeAtual());

        if (operador.getUnidadeSaude() != null) {
            dto.setUnidadeId(operador.getUnidadeSaude().getId());
        }

        dto.setPerfis(operador.getPerfis());
        dto.setPermissoes(operador.getPermissoes());
        return dto;
    }

    public static Operador toEntity(OperadorDTO dto, UnidadeSaude unidade) {
        if (dto == null) return null;

        return Operador.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .login(dto.getLogin())
                .senha(dto.getSenha())
                .cargo(dto.getCargo())
                .unidadeAtual(dto.getUnidadeAtual())
                .unidadeSaude(unidade)
                .perfis(dto.getPerfis())
                .permissoes(dto.getPermissoes())
                .build();
    }
}
