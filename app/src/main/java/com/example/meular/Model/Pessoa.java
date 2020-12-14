package com.example.meular.Model;

import java.util.Calendar;

public class Pessoa {

    private String nome;
    private String tipo;
    private String dataNascimento;
    private int renda;

    public Pessoa() {
    }

    public Pessoa(String nome, String tipo, String dataNascimento, int renda) {
        this.nome = nome;
        this.tipo = tipo;
        this.dataNascimento = dataNascimento;
        this.renda = renda;
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

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getRenda() {
        return this.renda;
    }

    public void setRenda(int renda) {
        this.renda = renda;
    }

    public int getIdade(){
        Calendar hoje = Calendar.getInstance();
        int anoAtual = hoje.get(Calendar.YEAR);
        int anoNasc = Integer.parseInt(dataNascimento.substring(6, 10));
        return anoAtual - anoNasc;
    }
}
