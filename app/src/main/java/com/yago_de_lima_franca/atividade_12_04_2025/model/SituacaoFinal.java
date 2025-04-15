package com.yago_de_lima_franca.atividade_12_04_2025.model;

import java.io.Serializable;
import java.util.List;

public class SituacaoFinal implements Serializable {
    private Situacao situacao;
    private double mediaNotas;
    private int mediaPresencas;

    public SituacaoFinal() {
    }

    public SituacaoFinal(Estudante estudante) {

        calcularMediaNotas(estudante.getNotas());
        calcularMediaFrequencia(estudante.getPresenca());
        calcularSituacao();

    }



    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public double getMediaNotas() {
        return mediaNotas;
    }

    public void setMediaNotas(int mediaNotas) {
        this.mediaNotas = mediaNotas;
    }

    public double getMediaPresencas() {
        return mediaPresencas;
    }

    public void setMediaPresencas(int mediaPresencas) {
        this.mediaPresencas = mediaPresencas;
    }

    public void setMediaNotas(double mediaNotas) {
        this.mediaNotas = mediaNotas;
    }

    protected void calcularMediaNotas(List<Double> notas) {

        if (notas.isEmpty()){
            throw  new RuntimeException("a Lista não pode ser vazia");
        }

        double media = 0;
        for (double nota : notas){
            media += nota;
        }

       mediaNotas =  media/notas.size();
    }

    protected void calcularMediaFrequencia(List<Boolean> listaFrequencia) {
        if (listaFrequencia.isEmpty()) {
            throw  new RuntimeException("a Lista não pode ser vazia");
        }
        int totPresencas = 0;

        for (boolean frequencia : listaFrequencia) {
            if (frequencia) {
                totPresencas++;
            }
        }

        double porcentagem = ((double) totPresencas / listaFrequencia.size()) * 100;
        mediaPresencas = (int) Math.round(porcentagem);
    }

    protected void calcularSituacao() {
        situacao = (mediaPresencas < 75 || mediaNotas < 7.0) ? Situacao.REPROVADO : Situacao.APROVADO;
    }

    @Override
    public String toString() {
        return "SituacaoFinal{" +
                ", situacao=" + situacao +
                ", mediaNotas=" + mediaNotas +
                ", mediaPresencas=" + mediaPresencas +
                '}';
    }
}
