package com.example.meular.Interface.Renda;

public class MediaRenda implements RendaInterface {

    private RendaInterface proximo;

    @Override
    public int pontuacaoRenda(int renda) {
        if (renda <= 1500){
            return 3;
        } else {
            return proximo.pontuacaoRenda(renda);
        }
    }

    @Override
    public void setProximo(RendaInterface proximo) {
        this.proximo = proximo;
    }
}
