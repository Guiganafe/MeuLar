package com.example.meular.Interface.Renda;

public class BaixaRenda implements RendaInterface {

    private RendaInterface proximo;

    @Override
    public int pontuacaoRenda(int renda) {
        if (renda <= 900){
            return 5;
        } else {
            return proximo.pontuacaoRenda(renda);
        }
    }

    @Override
    public void setProximo(RendaInterface proximo) {
        this.proximo = proximo;
    }
}
