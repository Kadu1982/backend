package com.sistemadesaude.backend.dto;

import java.util.List;

public class UnidadeSaudeDTO {

    private Long id;
    private String nomeCnes;
    private String codigoCnes;
    private List<Long> operadoresIds;

    // Getters e Setters

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNomeCnes() { return nomeCnes; }

    public void setNomeCnes(String nomeCnes) { this.nomeCnes = nomeCnes; }

    public String getCodigoCnes() { return codigoCnes; }

    public void setCodigoCnes(String codigoCnes) { this.codigoCnes = codigoCnes; }

    public List<Long> getOperadoresIds() { return operadoresIds; }

    public void setOperadoresIds(List<Long> operadoresIds) { this.operadoresIds = operadoresIds; }
}
