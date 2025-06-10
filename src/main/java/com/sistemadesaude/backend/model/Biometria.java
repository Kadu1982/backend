package com.sistemadesaude.backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "biometrias")
public class Biometria {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    private Operador operador;


    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;

    @Column(name = "template_id", nullable = false)
    private String templateId;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "dispositivo_id")
    private String dispositivoId;

    @Column(name = "data_captura")
    private LocalDateTime dataCaptura;

    @Column(name = "ativo")
    private Boolean ativo;

    @Column(name = "criado_em")
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEm;

    @PrePersist
    protected void onCreate() {
        criadoEm = LocalDateTime.now();
        dataCaptura = LocalDateTime.now();
        ativo = true;
    }

    @PreUpdate
    protected void onUpdate() {
        atualizadoEm = LocalDateTime.now();
    }

    // ✅ GETTERS

    public UUID getId() {
        return id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public String getTemplateId() {
        return templateId;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDispositivoId() {
        return dispositivoId;
    }

    public LocalDateTime getDataCaptura() {
        return dataCaptura;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public LocalDateTime getAtualizadoEm() {
        return atualizadoEm;
    }

    // ✅ SETTERS

    public void setId(UUID id) {
        this.id = id;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDispositivoId(String dispositivoId) {
        this.dispositivoId = dispositivoId;
    }

    public void setDataCaptura(LocalDateTime dataCaptura) {
        this.dataCaptura = dataCaptura;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    public void setAtualizadoEm(LocalDateTime atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }
}
