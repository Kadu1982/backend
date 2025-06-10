package com.sistemadesaude.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "operadores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Operador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usunome", nullable = false)
    private String nome;

    @Column(name = "usuemail", nullable = false, unique = true)
    @Email
    private String email;

    @Column(name = "usucpf", nullable = false, unique = true, length = 11)
    @NotBlank
    @Size(min = 11, max = 11)
    private String cpf;

    @Column(name = "usulogin", nullable = false, unique = true, length = 12)
    @Size(min = 7, max = 12)
    @Pattern(
            regexp = "^[a-zA-Z]+\\.[a-zA-Z]+$",
            message = "O login deve conter duas palavras separadas por ponto (ex: nome.sobrenome)"
    )
    private String login;

    @Column(name = "ususenha", nullable = false)
    @Size(min = 8, max = 32)
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{8,32}$",
            message = "A senha deve conter ao menos uma letra maiúscula, um número e um caractere especial"
    )
    private String senha;

    @Column(name = "perfil", nullable = false)
    private String perfil;

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "unidade_atual")
    private String unidadeAtual;

    @ManyToOne
    @JoinColumn(name = "unidade_id")
    private UnidadeSaude unidadeSaude;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "operador_perfis", joinColumns = @JoinColumn(name = "operador_id"))
    @Column(name = "perfil")
    private List<String> perfis;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "operador_permissoes", joinColumns = @JoinColumn(name = "operador_id"))
    @Column(name = "permissao")
    private List<String> permissoes;

    @Column(name = "template_id", unique = true)
    private String templateId;

    // ✅ Método adicional necessário para lógica de serviço
    public Long getUnidadeId() {
        return this.unidadeSaude != null ? this.unidadeSaude.getId() : null;
    }
}
