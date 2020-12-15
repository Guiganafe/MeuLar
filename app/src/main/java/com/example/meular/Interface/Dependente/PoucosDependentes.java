package com.example.meular.Interface.Dependente;

public class PoucosDependentes implements DependenteInterface {

    private DependenteInterface proximo;

    @Override
    public int pontuacaoDependente(int numeroDeDependente) {
        if(numeroDeDependente > 0 && numeroDeDependente <= 2){
            return 2;
        } else {
            return proximo.pontuacaoDependente(numeroDeDependente);
        }
    }

    @Override
    public void setProximo(DependenteInterface proximo) {
        this.proximo = proximo;
    }
}
