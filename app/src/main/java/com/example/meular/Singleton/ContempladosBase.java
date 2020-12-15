package com.example.meular.Singleton;

import com.example.meular.Model.Contemplados;

import java.util.ArrayList;

public class ContempladosBase {

    private ArrayList<Contemplados> contemplados;

    private static ContempladosBase mContemplados;

    private ContempladosBase(){
        contemplados = new ArrayList<>();
    }

    public static ContempladosBase getInstance(){
        if(mContemplados == null){
            mContemplados = new ContempladosBase();
        }
        return mContemplados;
    }

    public ArrayList<Contemplados> getContempladosList(){
        return contemplados;
    }

    public void addContemplados(Contemplados c){
        contemplados.add(c);
    }
}
