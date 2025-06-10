package com.sistemadesaude.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperadorDTO {

    private Long id;
    private String nome;
    private String login;
    private String cargo;
    private String unidadeAtual;
    private Long unidadeId;
    private String email;
    private String cpf;
    private String perfil;
    private List<String> perfis;
    private List<String> permissoes;
    private String templateId;

}