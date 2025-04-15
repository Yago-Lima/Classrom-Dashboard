package com.yago_de_lima_franca.atividade_12_04_2025;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yago_de_lima_franca.atividade_12_04_2025.adapter.ItemAdapterListaSimples;
import com.yago_de_lima_franca.atividade_12_04_2025.model.Estatisticas;
import com.yago_de_lima_franca.atividade_12_04_2025.model.Turma;

public class Activity3 extends AppCompatActivity {
    private TextView
            textViewMediaGeral,
            textViewMaiorNota,
            textViewMenorNota,
            textViewMediaIdade;
    private RecyclerView
            recyclerViewAprovados,
            recyclerViewReprovados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        bindUI();
        drawUI();
    }

    protected void bindUI() {
        textViewMediaGeral = findViewById(R.id.textViewMediaGeral);
        textViewMaiorNota = findViewById(R.id.textViewMaiorNota);
        textViewMenorNota = findViewById(R.id.textViewMenorNota);
        textViewMediaIdade = findViewById(R.id.textViewMediaIdade);
        recyclerViewAprovados = findViewById(R.id.recyclerViewAprovados);
        recyclerViewReprovados = findViewById(R.id.recyclerViewReprovados);
        recyclerViewReprovados.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAprovados.setLayoutManager(new LinearLayoutManager(this));
    }

    protected void drawUI() {
        Intent it = getIntent();

        if (it == null) {
            throw  new RuntimeException("A intent está nula");
        }
        Turma turma = (Turma) it.getSerializableExtra("turma");
        if (turma == null) {
            throw  new RuntimeException("O Objeto turma não pode ser nulo");
        }

        Estatisticas estatisticas = new Estatisticas(turma.getEstudantes());

        textViewMediaGeral.setText(String.format("%.2f",estatisticas.getMediaGeral()));
        textViewMaiorNota.setText(String.valueOf(estatisticas.getNomeAlunoMaiorNota()));
        textViewMenorNota.setText(String.valueOf(estatisticas.getNomeAlunoMenorNota()));
        textViewMediaIdade.setText(String.format("%.2f",estatisticas.getMediaIdade()));


        ItemAdapterListaSimples adapterAprovados = new ItemAdapterListaSimples(estatisticas.getAlunosAprovados(), getApplicationContext());
        recyclerViewAprovados.setAdapter(adapterAprovados);
        ItemAdapterListaSimples adapterReprovados = new ItemAdapterListaSimples(estatisticas.getAlunosReprovados(), getApplicationContext());
        recyclerViewReprovados.setAdapter(adapterReprovados);
    }


}