package com.yago_de_lima_franca.atividade_12_04_2025;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.yago_de_lima_franca.atividade_12_04_2025.model.Estudante;
import com.yago_de_lima_franca.atividade_12_04_2025.model.SituacaoFinal;

public class Activity2 extends AppCompatActivity {
    private TextView
            textViewNome,
            textViewidade,
            textViewMediaNota,
            textViewMediaPresenca,
            textViewSituacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        textViewNome = findViewById(R.id.textViewNome);
        textViewidade = findViewById(R.id.textViewIdade);
        textViewMediaNota = findViewById(R.id.textViewMediaNota);
        textViewMediaPresenca = findViewById(R.id.textViewMediaPresenca);
        textViewSituacao = findViewById(R.id.textViewSituacao);


        Intent it = getIntent();

        if (it == null) {
            throw  new RuntimeException("A intent está nula");
        }
        Estudante estudante = (Estudante) it.getSerializableExtra("estudante");
        if (estudante == null) {
            throw  new RuntimeException("O Objeto estudante não pode ser nulo");
        }


        textViewNome.setText(estudante.getNome());
        textViewidade.setText(String.valueOf(estudante.getIdade()));
        textViewMediaNota.setText(String.format("%.2f",estudante.getSituacao().getMediaNotas()));
        textViewMediaPresenca.setText(String.format("%.2f",estudante.getSituacao().getMediaPresencas())+"%");
        textViewSituacao.setText(estudante.getSituacao().getSituacao().getDescricao());


    }
}