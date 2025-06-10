package com.sistemadesaude.backend.mapper;

import com.sistemadesaude.backend.dto.UnidadeSaudeDTO;
import com.sistemadesaude.backend.model.UnidadeSaude;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UnidadeSaudeMapper {

    public UnidadeSaudeDTO toDTO(UnidadeSaude entity) {
        UnidadeSaudeDTO dto = new UnidadeSaudeDTO();
        dto.setId(entity.getId());
        dto.setNomeCnes(entity.getNomeCnes());
        dto.setCodigoCnes(entity.getCodigoCnes());

        if (entity.getOperadores() != null) {
            dto.setOperadoresIds(entity.getOperadores()
                    .stream()
                    .map(op -> op.getId())
                    .collect(Collectors.toList()));
        }

        return dto;
    }

    public UnidadeSaude toEntity(UnidadeSaudeDTO dto) {
        UnidadeSaude entity = new UnidadeSaude();
        entity.setId(dto.getId());
        entity.setNomeCnes(dto.getNomeCnes());
        entity.setCodigoCnes(dto.getCodigoCnes());
        return entity;
    }
}
