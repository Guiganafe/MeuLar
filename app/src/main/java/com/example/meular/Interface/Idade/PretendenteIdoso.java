package com.example.meular.Interface.Idade;

public class PretendenteIdoso implements IdadeInterface {

    @Override
    public int pontuacaoIdade(int idade) {
        return 3;
    }

    @Override
    public void setProximo(IdadeInterface proximo) {
        // Último nível
    }
}
