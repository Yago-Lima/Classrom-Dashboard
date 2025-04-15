package com.yago_de_lima_franca.atividade_12_04_2025.model;

import java.util.ArrayList;
import java.util.List;

public class Estatisticas {
    private String nomeAlunoMaiorNota;
    private String nomeAlunoMenorNota;
    private double mediaGeral;
    private double mediaIdade;
    private List<Estudante> alunosAprovados;
    private List<Estudante> alunosReprovados;
    private List<Estudante> estudanteList;

    public Estatisticas(List<Estudante> estudanteList) {
        alunosAprovados = new ArrayList<>();
        alunosReprovados = new ArrayList<>();
        this.estudanteList = estudanteList;
        calcular();
    }

    private void calcular() {
        maiorNota();
        menorNota();
        mediaGeral();
        mediaIdade();
        gerarSituacaoGeral();
    }

    protected void gerarSituacaoGeral() {
        if (listIsInvalid()) return;
        for (Estudante estudante : estudanteList) {
            if (estudante.getSituacao().getSituacao().getDescricao()
                    .equals(
                            Situacao.APROVADO.getDescricao()
                    )) {
                alunosAprovados.add(estudante);
                continue;
            }
            alunosReprovados.add(estudante);
        }
    }

    protected void mediaIdade() {
        if (listIsInvalid()) return;

        double media = 0;
        for (Estudante estudante : estudanteList) {
            media += estudante.getIdade();
        }
        mediaIdade = media / estudanteList.size();
    }

    protected void mediaGeral() {
        if (listIsInvalid()) return;

        double media = 0;
        for (Estudante estudante : estudanteList) {
                media += estudante.getSituacao().getMediaNotas();
        }
        mediaGeral = media / estudanteList.size();
    }

    protected void maiorNota() {
        if (listIsInvalid()) return;

        double maiorNota = Double.MIN_VALUE;
        for (Estudante estudante : estudanteList) {
            if (estudante.getSituacao().getMediaNotas() > maiorNota) {
                maiorNota = estudante.getSituacao().getMediaNotas();
                nomeAlunoMaiorNota = estudante.getNome();
            }
        }
    }

    private boolean listIsInvalid() {
        return estudanteList == null || estudanteList.isEmpty();
    }

    protected void menorNota() {
        if (listIsInvalid()) return;

        double menorNota = Double.MAX_VALUE;
         nomeAlunoMenorNota = "";
        for (Estudante estudante : estudanteList) {
            if (estudante.getSituacao().getMediaNotas() < menorNota) {
                menorNota = estudante.getSituacao().getMediaNotas();
                nomeAlunoMenorNota = estudante.getNome();
            }
        }
    }

    public String getNomeAlunoMaiorNota() {
        return nomeAlunoMaiorNota;
    }

    public void setNomeAlunoMaiorNota(String nomeAlunoMaiorNota) {
        this.nomeAlunoMaiorNota = nomeAlunoMaiorNota;
    }

    public String getNomeAlunoMenorNota() {
        return nomeAlunoMenorNota;
    }

    public void setNomeAlunoMenorNota(String nomeAlunoMenorNota) {
        this.nomeAlunoMenorNota = nomeAlunoMenorNota;
    }

    public List<Estudante> getAlunosReprovados() {
        return alunosReprovados;
    }

    public void setAlunosReprovados(List<Estudante> alunosReprovados) {
        this.alunosReprovados = alunosReprovados;
    }

    public List<Estudante> getEstudanteList() {
        return estudanteList;
    }

    public void setEstudanteList(List<Estudante> estudanteList) {
        this.estudanteList = estudanteList;
    }

    public double getMediaGeral() {
        return mediaGeral;
    }

    public void setMediaGeral(double mediaGeral) {
        this.mediaGeral = mediaGeral;
    }

    public double getMediaIdade() {
        return mediaIdade;
    }

    public void setMediaIdade(double mediaIdade) {
        this.mediaIdade = mediaIdade;
    }

    public List<Estudante> getAlunosAprovados() {
        return alunosAprovados;
    }

    public void setAlunosAprovados(List<Estudante> alunosAprovados) {
        this.alunosAprovados = alunosAprovados;
    }

    @Override
    public String toString() {
        return "Estatisticas{" +
                "nomeAlunoMaiorNota='" + nomeAlunoMaiorNota + '\'' +
                ", mediaGeral=" + mediaGeral +
                ", mediaIdade=" + mediaIdade +
                ", alunosAprovados=" + alunosAprovados +
                '}';
    }
}
