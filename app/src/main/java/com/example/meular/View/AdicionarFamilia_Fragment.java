package com.example.meular.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.meular.Interface.Dependente.DependenteInterface;
import com.example.meular.Interface.Dependente.MuitosDependentes;
import com.example.meular.Interface.Dependente.PoucosDependentes;
import com.example.meular.Interface.Idade.IdadeInterface;
import com.example.meular.Interface.Idade.PretendenteAdulto;
import com.example.meular.Interface.Idade.PretendenteIdoso;
import com.example.meular.Interface.Idade.PretendenteJovem;
import com.example.meular.Interface.Renda.AltaRenda;
import com.example.meular.Interface.Renda.BaixaRenda;
import com.example.meular.Interface.Renda.MediaRenda;
import com.example.meular.Interface.Renda.RendaInterface;
import com.example.meular.Model.Contemplados;
import com.example.meular.Model.Familia;
import com.example.meular.Model.Pessoa;
import com.example.meular.R;
import com.example.meular.Singleton.ContempladosBase;

import java.util.ArrayList;
import java.util.Calendar;

public class AdicionarFamilia_Fragment extends Fragment {

    public ArrayList<Familia> familias = new ArrayList<>();
    private EditText nome, renda, numDependentes, dataNascimento, status;
    private String nome_tx, dataNascimento_tx, status_tx;
    private int numDep_tx, renda_tx;
    private Button addFamilia;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_adicionar_familia, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        inicializarComponentes(view);

        onCliclController();
    }

    private void gerarContemplados(Familia f) {
        if(f.getStatus().equals("0")){
            Calendar hoje = Calendar.getInstance();

            Contemplados familiaContemplada = new Contemplados();

            int pontuacao = calcularPontuacao(f);
            familiaContemplada.setFamiliaContemplada(f);
            familiaContemplada.setPontuacaoTotal(pontuacao);
            familiaContemplada.setDataSelecao( hoje.get(Calendar.DAY_OF_MONTH) + "/"
                    +  (hoje.get(Calendar.MONTH) + 1) + "/" + hoje.get(Calendar.YEAR));

            Toast.makeText(requireActivity(), "Familia de: " + nome_tx + " adicionada!", Toast.LENGTH_SHORT).show();

            ContempladosBase.getInstance().addContemplados(familiaContemplada);
        } else {
            Toast.makeText(requireActivity(), "Familia de: " + nome_tx + " reprovada!", Toast.LENGTH_SHORT).show();
        }
    }

    public int calcularPontuacao(Familia familia){
        int numDependente = familia.getNumeroDependente();
        int rendaTotal = familia.getRendaTotal();
        int idadePretendente = familia.getIdadePretendente();
        int pontuacao = 0;

        //Instanciação das interfaces do padrão Chain of Resposibility

        //Critérios de Renda
        final RendaInterface rendaBaixa = new BaixaRenda();
        final RendaInterface rendaMedia = new MediaRenda();
        final RendaInterface rendaAlta = new AltaRenda();
        //Critérios de Idade
        final IdadeInterface jovemPretendente = new PretendenteJovem();
        final IdadeInterface adultoPretendente = new PretendenteAdulto();
        final IdadeInterface idosoPretendente = new PretendenteIdoso();
        //Critérios de dependente
        final DependenteInterface pocosDependentes = new PoucosDependentes();
        final DependenteInterface muitosDependentes = new MuitosDependentes();

        //Define o próximo método a ser chamado pelo padrão
        rendaBaixa.setProximo(rendaMedia);
        rendaMedia.setProximo(rendaAlta);

        jovemPretendente.setProximo(adultoPretendente);
        adultoPretendente.setProximo(idosoPretendente);

        pocosDependentes.setProximo(muitosDependentes);

        /*
            Retorna a pontuação de acordo com cada critério
            e adiciona na variável pontuacao
         */
        pontuacao += rendaBaixa.pontuacaoRenda(rendaTotal);

        pontuacao += jovemPretendente.pontuacaoIdade(idadePretendente);

        pontuacao += pocosDependentes.pontuacaoDependente(numDependente);

        return pontuacao;
    }

    private void onCliclController(){
        addFamilia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criarFamilia();
            }
        });
    }

    private void criarFamilia() {
        nome_tx = nome.getText().toString().isEmpty() ? "Sem nome" : nome.getText().toString();
        renda_tx = renda.getText().toString().isEmpty() ? 0 : Integer.parseInt(renda.getText().toString());
        numDep_tx = numDependentes.getText().toString().isEmpty() ? 1 : Integer.parseInt(numDependentes.getText().toString());
        dataNascimento_tx = dataNascimento.getText().toString().isEmpty() ? "15/12/2020" : dataNascimento.getText().toString();
        status_tx = status.getText().toString().isEmpty() ? "1" : status.getText().toString();

        ArrayList<Pessoa> pessoas = new ArrayList<>();
        Pessoa p = new Pessoa(nome_tx, "Pretendente", dataNascimento_tx, renda_tx);
        pessoas.add(p);

        for(int i = 0; i < numDep_tx; i++){
            Pessoa dependente = new Pessoa("Filho " + (i+1), "Dependente", "10/12/2005", 0);
            pessoas.add(dependente);
        }

        Familia familia = new Familia();
        familia.setPessoas(pessoas);
        familia.setStatus(status_tx);

        gerarContemplados(familia);
    }

    private void inicializarComponentes(View view){
        nome = (EditText) view.findViewById(R.id.edt_nome_pretendente);
        renda = (EditText) view.findViewById(R.id.edt_renda_familia);
        numDependentes = (EditText) view.findViewById(R.id.edt_num_dependentes);
        dataNascimento = (EditText) view.findViewById(R.id.edt_data_nasc);
        status = (EditText) view.findViewById(R.id.edt_status);
        addFamilia = (Button) view.findViewById(R.id.btn_add);
    }

    private void criarFamilia2() {
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

        //Familia
        ArrayList<Pessoa> pessoasf5 = new ArrayList<>();
        Pessoa p16 = new Pessoa("Luana Souza", "Pretendente", "15/02/1988", 10000);
        Pessoa p17 = new Pessoa("Alessandro da Souza", "Cônjuge", "11/04/1985", 4000);
        Pessoa p18 = new Pessoa("Alessa Moreira", "Dependente", "21/01/2018", 0);

        pessoasf5.add(p16);
        pessoasf5.add(p17);
        pessoasf5.add(p18);

        Familia familia5 = new Familia();
        familia5.setPessoas(pessoasf5);
        familia5.setStatus("1");

        familias.add(familia1);
        familias.add(familia2);
        familias.add(familia3);
        familias.add(familia4);
        familias.add(familia5);
    }
}