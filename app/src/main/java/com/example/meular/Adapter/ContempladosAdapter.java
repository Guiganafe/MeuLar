package com.example.meular.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meular.Model.Contemplados;
import com.example.meular.Model.Familia;
import com.example.meular.Model.Pessoa;
import com.example.meular.R;

import java.util.ArrayList;

public class ContempladosAdapter extends RecyclerView.Adapter<ContempladosAdapter.ContempladosViewHolder>{

    ArrayList<Contemplados> contemplados;

    public ContempladosAdapter (ArrayList<Contemplados> contemplados){
        this.contemplados = contemplados;
    }

    @NonNull
    @Override
    public ContempladosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contemplado_item,
                parent, false);
        return new ContempladosViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ContempladosViewHolder holder, int position) {
        String nomePretendente = "";
        Familia familia = contemplados.get(position).getFamiliaContemplada();
        ArrayList<Pessoa> pessoas = familia.getPessoas();

        for (Pessoa p: pessoas) {
            if(p.getTipo().equals("Pretendente")){
               nomePretendente = p.getNome();
            }
        }

        holder.textView_nome_pretendente.setText("Pretendente: " + nomePretendente);
        holder.textView_pontuacao.setText("Pontuação: " + contemplados.get(position).getPontuacaoTotal());
    }

    @Override
    public int getItemCount() {
        return contemplados.size();
    }

    public class ContempladosViewHolder extends RecyclerView.ViewHolder {
        TextView textView_nome_pretendente, textView_pontuacao;

        public ContempladosViewHolder(@NonNull View itemView) {
            super(itemView);
            textView_nome_pretendente = itemView.findViewById(R.id.textView_nome_pretendente);
            textView_pontuacao = itemView.findViewById(R.id.textView_pontuacao);
        }
    }
}
