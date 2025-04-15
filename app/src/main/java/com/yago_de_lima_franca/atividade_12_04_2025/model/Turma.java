package com.yago_de_lima_franca.atividade_12_04_2025.model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Turma implements Serializable {

    @SerializedName("estudantes")
    @Expose
    private List<Estudante> estudantes;

    public List<Estudante> getEstudantes() {
        return estudantes;
    }

    public void setEstudantes(List<Estudante> estudantes) {
        this.estudantes = estudantes;
    }

    @Override
    public String toString() {
        return "Turma{" +
                "estudantes=" + estudantes +
                '}';
    }
}
