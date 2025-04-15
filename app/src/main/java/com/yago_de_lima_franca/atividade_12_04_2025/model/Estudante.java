package com.yago_de_lima_franca.atividade_12_04_2025.model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Estudante implements Serializable {

    @SerializedName("nome")
    @Expose
    private String nome;
    @SerializedName("idade")
    @Expose
    private Integer idade;
    @SerializedName("notas")
    @Expose
    private List<Double> notas;
    @SerializedName("presenca")
    @Expose
    private List<Boolean> presenca;
    private SituacaoFinal situacao;

    public SituacaoFinal getSituacao() {
        return situacao;
    }

    public Estudante() {
    }

    public Estudante(String nome, Integer idade, List<Double> notas, List<Boolean> presenca) {
        this.nome = nome;
        this.idade = idade;
        this.notas = notas;
        this.presenca = presenca;
    }

    public void setSituacao(SituacaoFinal situacao) {
        this.situacao = situacao;
    }

    public Estudante(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public List<Double> getNotas() {
        return notas;
    }

    public void setNotas(List<Double> notas) {
        this.notas = notas;
    }

    public List<Boolean> getPresenca() {
        return presenca;
    }

    public void setPresenca(List<Boolean> presenca) {
        this.presenca = presenca;
    }

    @Override
    public String toString() {
        return "Estudante{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", notas=" + notas +
                ", presenca=" + presenca +
                '}';
    }
}
