package com.yago_de_lima_franca.atividade_12_04_2025.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yago_de_lima_franca.atividade_12_04_2025.Activity2;
import com.yago_de_lima_franca.atividade_12_04_2025.R;
import com.yago_de_lima_franca.atividade_12_04_2025.model.Estudante;

import java.util.List;

public class ItemAdapterListaSimples extends RecyclerView.Adapter<ItemAdapterListaSimples.ViewHolder> {
    private List<Estudante> estudanteList;
    private Context context;

    public ItemAdapterListaSimples(List<Estudante> estudanteList, Context context) {
        this.estudanteList = estudanteList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lista_simples, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Estudante estudante = estudanteList.get(position);
        holder.textViewNome.setText(estudante.getNome());

        // Set the onClick listener
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, Activity2.class);
            intent.putExtra("estudante", estudante);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return estudanteList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNome;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNome = itemView.findViewById(R.id.textViewNome);
        }
    }
}