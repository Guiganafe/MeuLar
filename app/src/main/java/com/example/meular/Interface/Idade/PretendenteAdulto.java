package com.example.meular.Interface.Idade;

public class PretendenteAdulto implements IdadeInterface {

    private IdadeInterface proximo;

    @Override
    public int pontuacaoIdade(int idade) {
        if(idade <= 44){
            return 2;
        } else {
            return proximo.pontuacaoIdade(idade);
        }
    }

    @Override
    public void setProximo(IdadeInterface proximo) {
        this.proximo = proximo;
    }
}
