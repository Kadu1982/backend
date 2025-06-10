// === UnidadeSaude.java (Atualizado e compatível com o Mapper e DTO) ===
package com.sistemadesaude.backend.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "unidade_saude")
public class UnidadeSaude {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_cnes", nullable = false)
    private String nomeCnes;

    @Column(name = "codigo_cnes", nullable = false, unique = true)
    private String codigoCnes;

    @OneToMany(mappedBy = "unidadeSaude", cascade = CascadeType.ALL)
    private List<Operador> operadores;

    public UnidadeSaude() {
    }

    public UnidadeSaude(Long id, String nomeCnes, String codigoCnes) {
        this.id = id;
        this.nomeCnes = nomeCnes;
        this.codigoCnes = codigoCnes;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getNomeCnes() {
        return nomeCnes;
    }

    public String getCodigoCnes() {
        return codigoCnes;
    }

    public List<Operador> getOperadores() {
        return operadores;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setNomeCnes(String nomeCnes) {
        this.nomeCnes = nomeCnes;
    }

    public void setCodigoCnes(String codigoCnes) {
        this.codigoCnes = codigoCnes;
    }

    public void setOperadores(List<Operador> operadores) {
        this.operadores = operadores;
    }
}
