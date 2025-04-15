package com.yago_de_lima_franca.atividade_12_04_2025.model;

public enum Situacao {
    APROVADO("Aprovado"),
    REPROVADO("Reprovado");

    private final String descricao;

    Situacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
