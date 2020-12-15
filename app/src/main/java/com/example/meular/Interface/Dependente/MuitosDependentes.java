package com.example.meular.Interface.Dependente;

public class MuitosDependentes implements DependenteInterface {

    private DependenteInterface proximo;

    @Override
    public int pontuacaoDependente(int numeroDeDependente) {
        if( numeroDeDependente >= 3){
            return 3;
        } else {
            return proximo.pontuacaoDependente(numeroDeDependente);
        }
    }

    @Override
    public void setProximo(DependenteInterface proximo) {
        //Último nível
    }
}
