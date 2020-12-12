package com.example.meular.Model;

import java.sql.Timestamp;

public class Beneficiado {

    private Familia familiaBeneficiada;
    private int criteriosAtendidos;
    private int pontuacaoTotal;
    private Timestamp dataSelecao;

    public Beneficiado() {
    }

    public Familia getFamiliaBeneficiada() {
        return familiaBeneficiada;
    }

    public void setFamiliaBeneficiada(Familia familiaBeneficiada) {
        this.familiaBeneficiada = familiaBeneficiada;
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

    public Timestamp getDataSelecao() {
        return dataSelecao;
    }

    public void setDataSelecao(Timestamp dataSelecao) {
        this.dataSelecao = dataSelecao;
    }
}
