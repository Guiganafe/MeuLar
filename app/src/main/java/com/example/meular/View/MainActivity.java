package com.example.meular.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.meular.Model.Beneficiado;
import com.example.meular.Model.Familia;
import com.example.meular.Model.Pessoa;
import com.example.meular.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public ArrayList<Beneficiado> beneficiados = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        criarFamilia();

    }

    private void criarFamilia() {
        //Familia 1
        ArrayList<Pessoa> pessoasf1 = new ArrayList<>();
        Pessoa p = new Pessoa("João Dias", "Pretendente", "15/02/1990", 500);
        Pessoa p2 = new Pessoa("Vitória Vidal", "Cônjuge", "10/12/1993", 1000);
        Pessoa p3 = new Pessoa("João Dias Junior", "Dependente", "11/04/2005", 0);
        Pessoa p4 = new Pessoa("Vitória Vidal Junior", "Dependente", "25/07/2010", 0);

        pessoasf1.add(p);
        pessoasf1.add(p2);
        pessoasf1.add(p3);
        pessoasf1.add(p4);

        Familia familia1 = new Familia();
        familia1.setPessoas(pessoasf1);
        familia1.setStatus("0");

        //Familia 2
        ArrayList<Pessoa> pessoasf2 = new ArrayList<>();
        Pessoa p5 = new Pessoa("Paulo Vargas", "Pretendente", "15/02/1970", 1700);
        Pessoa p6 = new Pessoa("Guilherme Fernandez", "Dependente", "11/04/2010", 0);
        Pessoa p7 = new Pessoa("Matheus Gonçalves", "Dependente", "21/01/2015", 0);
        Pessoa p8 = new Pessoa("Marcela Miranda", "Dependente", "25/08/2019", 0);

        pessoasf2.add(p5);
        pessoasf2.add(p6);
        pessoasf2.add(p7);
        pessoasf2.add(p8);

        Familia familia2 = new Familia();
        familia2.setPessoas(pessoasf2);
        familia2.setStatus("0");

        //Familia 3
        ArrayList<Pessoa> pessoasf3 = new ArrayList<>();
        Pessoa p9 = new Pessoa("Fernando Moreira", "Pretendente", "15/02/1995", 200);
        Pessoa p10 = new Pessoa("William Martins", "Cônjuge", "11/04/1995", 500);
        Pessoa p11 = new Pessoa("Alessa Moreira", "Dependente", "21/01/1997", 0);
        Pessoa p12 = new Pessoa("Carla Martins", "Dependente", "25/08/2010", 0);

        pessoasf3.add(p9);
        pessoasf3.add(p10);
        pessoasf3.add(p11);
        pessoasf3.add(p12);

        Familia familia3 = new Familia();
        familia3.setPessoas(pessoasf3);
        familia3.setStatus("0");

        //Familia 4
        ArrayList<Pessoa> pessoasf4 = new ArrayList<>();
        Pessoa p13 = new Pessoa("Larissa Oliveira", "Pretendente", "15/02/1988", 4000);
        Pessoa p14 = new Pessoa("Alessandro da Souza", "Cônjuge", "11/04/1985", 4000);
        Pessoa p15 = new Pessoa("Alessa Moreira", "Dependente", "21/01/2018", 0);

        pessoasf4.add(p13);
        pessoasf4.add(p14);
        pessoasf4.add(p15);

        Familia familia4 = new Familia();
        familia4.setPessoas(pessoasf4);
        familia4.setStatus("0");

        calcularPontuacaoo(familia1);
        calcularPontuacaoo(familia2);
        calcularPontuacaoo(familia3);
        calcularPontuacaoo(familia4);
    }

    public int calcularPontuacaoo(Familia familia){
        int numDependente = familia.getNumeroDependente();
        int rendaTotal = familia.getRendaTotal();
        int idadePretendente = familia.getIdadePretendente();
        int pontuacao = 0;

        if(numDependente > 0 && numDependente <= 2){
            pontuacao += 2;
        } else if( numDependente >= 3){
            pontuacao += 3;
        }

        if(idadePretendente < 30){
            pontuacao += 1;
        } else if(idadePretendente <= 44){
            pontuacao += 2;
        } else {
            pontuacao += 3;
        }

        if(rendaTotal <= 900){
            pontuacao += 5;
        } else if(rendaTotal <= 1500){
            pontuacao += 3;
        } else {
            pontuacao += 1;
        }

        Toast.makeText(this, "Pontuação: " + pontuacao, Toast.LENGTH_SHORT).show();
        return pontuacao;



//        Toast.makeText(this, "Familia:", Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, "Idade pretendente: " + idadePretendente, Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, "Renda: " + rendaTotal, Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, "Num Dependentes: " + numDependente, Toast.LENGTH_SHORT).show();
    }
}