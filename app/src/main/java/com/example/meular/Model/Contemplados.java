package com.example.meular.Model;

import java.sql.Timestamp;

public class Contemplados {

    private Familia familiaContemplada;
    private int criteriosAtendidos;
    private int pontuacaoTotal;
    private String dataSelecao;

    public Contemplados() {
    }

    public Familia getFamiliaContemplada() {
        return familiaContemplada;
    }

    public void setFamiliaContemplada(Familia familiaContemplada) {
        this.familiaContemplada = familiaContemplada;
    }

    public int getCriteriosAtendidos() {
        return criteriosAtendidos;
    }

    public void setCriteriosAtendidos(int criteriosAtendidos) {
        this.criteriosAtendidos = criteriosAtendidos;
    }

    public int getPontuacaoTotal() {
        return pontuacaoTotal;
    }

    public void setPontuacaoTotal(int pontuacaoTotal) {
        this.pontuacaoTotal = pontuacaoTotal;
    }

    public String getDataSelecao() {
        return dataSelecao;
    }

    public void setDataSelecao(String dataSelecao) {
        this.dataSelecao = dataSelecao;
    }
}
