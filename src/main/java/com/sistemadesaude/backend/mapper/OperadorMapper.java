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
        // A linha abaixo foi removida pois o DTO não deve expor a senha.
        // dto.setSenha(operador.getSenha());
        dto.setCargo(operador.getCargo());
        dto.setUnidadeAtual(operador.getUnidadeAtual());

        if (operador.getUnidadeSaude() != null) {
            dto.setUnidadeId(operador.getUnidadeSaude().getId());
        }

        dto.setPerfis(operador.getPerfis());
        dto.setPermissoes(operador.getPermissoes());
        return dto;
    }

    public static Operador toEntity(OperadorDTO dto) {
        if (dto == null) return null;

        Operador.OperadorBuilder builder = Operador.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .login(dto.getLogin())
                // A senha não é mapeada aqui. Ela deve ser tratada na camada de serviço (service).
                .cargo(dto.getCargo())
                .unidadeAtual(dto.getUnidadeAtual())
                .perfis(dto.getPerfis())
                .permissoes(dto.getPermissoes());

        // Associa a UnidadeSaude usando o ID do DTO
        if (dto.getUnidadeId() != null) {
            UnidadeSaude unidade = new UnidadeSaude();
            unidade.setId(dto.getUnidadeId());
            builder.unidadeSaude(unidade);
        }

        return builder.build();
    }
}