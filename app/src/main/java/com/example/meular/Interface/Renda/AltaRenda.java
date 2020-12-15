package com.example.meular.Interface.Renda;

public class AltaRenda implements RendaInterface {

    private RendaInterface proximo;

    @Override
    public int pontuacaoRenda(int renda) {
        return 1;
    }

    @Override
    public void setProximo(RendaInterface proximo) {
        // Último nível
    }
}
