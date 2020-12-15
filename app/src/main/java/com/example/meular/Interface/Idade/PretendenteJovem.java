package com.example.meular.Interface.Idade;

public class PretendenteJovem implements IdadeInterface{

    private IdadeInterface proximo;

    @Override
    public int pontuacaoIdade(int idade) {
        if(idade < 30){
            return 1;
        } else {
            return proximo.pontuacaoIdade(idade);
        }
    }

    @Override
    public void setProximo(IdadeInterface proximo) {
        this.proximo = proximo;
    }
}
