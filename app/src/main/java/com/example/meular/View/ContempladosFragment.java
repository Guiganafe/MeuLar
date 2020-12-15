package com.example.meular.View;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.meular.Adapter.ContempladosAdapter;
import com.example.meular.Model.Contemplados;
import com.example.meular.R;
import com.example.meular.Singleton.ContempladosBase;

import java.util.ArrayList;

public class ContempladosFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private ArrayList<Contemplados> contemplados;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contemplados, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        inicializarComponentes(view);

        setUpReciclerView();
    }

    private void setUpReciclerView() {
        contemplados = ContempladosBase.getInstance().getContempladosList();
        if(contemplados != null && contemplados.size() >= 1){
            adapter = new ContempladosAdapter(contemplados);
            recyclerView.setHasFixedSize(false);
            recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
            recyclerView.setAdapter(adapter);
        }
    }

    private void inicializarComponentes(View view) {
        recyclerView = view.findViewById(R.id.reciclerView_Contemplados);
    }
}