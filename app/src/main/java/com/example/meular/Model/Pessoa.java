package com.example.meular.Model;

import java.sql.Timestamp;
import java.util.Calendar;

public class Pessoa {
    private String nome;
    private String tipo;
    private Timestamp dataNascimento;
    private int Renda;

    public Pessoa() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Timestamp getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Timestamp dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getRenda() {
        return Renda;
    }

    public void setRenda(int renda) {
        Renda = renda;
    }

    public int getIdade(){
        Calendar hoje = Calendar.getInstance();
        int anoAtual = hoje.get(Calendar.YEAR);

        Calendar dataNasc = Calendar.getInstance();
        dataNascimento.setTime(dataNascimento.getTime());
        int anoNasc = dataNasc.get(Calendar.YEAR);

        return anoAtual - anoNasc;
    }
}
