package com.example.meular.Model;

import java.util.ArrayList;

public class Familia {

    private ArrayList<Pessoa> pessoas;
    private String status;

    private static final String DEPENDENTE = "Dependente";

    public Familia() {
    }

    public ArrayList<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(ArrayList<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Método que retorna o total de renda da família analisada
     * @return rendaTotal
     */
    public int getRendaTotal(){
        int rendaTotal = 0;
        for (Pessoa p: pessoas) {
            rendaTotal += p.getRenda();
        }
        return rendaTotal;
    }

    /**
     * Método que retorna a quantidade de dependentes menores que
     * 18 anos da familia
     * @return totalDependente
     */
    public int getNumeroDependente(){
        int totalDependente = 0;
        for (Pessoa p: pessoas) {
            if(p.getTipo().equals(DEPENDENTE) && p.getIdade() <= 18){
                totalDependente++;
            }
        }
        return totalDependente;
    }
}
