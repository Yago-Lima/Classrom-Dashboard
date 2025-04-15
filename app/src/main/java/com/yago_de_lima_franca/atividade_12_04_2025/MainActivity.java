package com.yago_de_lima_franca.atividade_12_04_2025;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yago_de_lima_franca.atividade_12_04_2025.adapter.ItemAdapterListaSimples;
import com.yago_de_lima_franca.atividade_12_04_2025.conection.Conexao;
import com.yago_de_lima_franca.atividade_12_04_2025.model.Estudante;
import com.yago_de_lima_franca.atividade_12_04_2025.model.SituacaoFinal;
import com.yago_de_lima_franca.atividade_12_04_2025.model.Turma;
import com.yago_de_lima_franca.atividade_12_04_2025.utils.DataConverter;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private final String
            URL = "https://my-json-server.typicode.com/Yago-Lima/myjsonserver/db";
    private Turma turma;
    private ExecutorService executorService;

    private RecyclerView recyclerView;
    private ItemAdapterListaSimples adapter;
    private List<Estudante> estudanteList;
    private Button buttonEstatisticas;
    private Intent it;
    private SituacaoFinal situacaoFinal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        buttonEstatisticas = findViewById(R.id.buttonEstatisticas);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        executorService = Executors.newSingleThreadExecutor();
        iniciarDownload();


        buttonEstatisticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                it = new Intent(getApplicationContext(), Activity3.class);

                Bundle bundle = new Bundle();
                bundle.putSerializable("turma", turma);

                it.putExtras(bundle);
                startActivity(it);
            }
        });

    }

    private void iniciarDownload() {
        Toast.makeText(this, "Download começando...", Toast.LENGTH_SHORT).show();

        executorService.execute(() -> {
            try (InputStream inputStream = Conexao.obterRespostaHTTP(URL)) { // Auto-closeable
                String textoJson = DataConverter.converter(inputStream);
                Log.i("JSON", textoJson);

                if (textoJson != null) {
                    Gson gson = new Gson();
                    Type type = new TypeToken<Turma>() {}.getType();
                    turma = gson.fromJson(textoJson, type);
                    estudanteList = turma.getEstudantes();
                    processar(estudanteList);

                    runOnUiThread(() -> {
                        if (!isFinishing() && !isDestroyed()) {
                            adapter = new ItemAdapterListaSimples(turma.getEstudantes(), getApplicationContext());
                            recyclerView.setAdapter(adapter);
                        }
                    });
                } else {
                    runOnUiThread(() -> {
                        Toast.makeText(MainActivity.this, "ERRO JSON", Toast.LENGTH_SHORT).show();
                    });
                }
            } catch (IOException e) {
                Log.e("DOWNLOAD", "Falha no download", e);
                runOnUiThread(() -> {
                    Toast.makeText(MainActivity.this, "Falha ao baixar dados", Toast.LENGTH_SHORT).show();
                });
            }
        });
    }

    protected void processar(List<Estudante> estudanteList) {

        for (Estudante estudante : estudanteList) {
            situacaoFinal = new SituacaoFinal(estudante);
            estudante.setSituacao(situacaoFinal);
        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (executorService != null && !executorService.isShutdown()) {
            executorService.shutdown();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Estudante estudante = estudanteList.get(position);
        it = new Intent(view.getContext(), Activity2.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("estudante", estudante);

        it.putExtras(bundle);

        startActivity(it);

    }
}