package com.dcc.ufjf;

public abstract class Funcionario {
    protected String nome;
    protected String funcao;

    public Funcionario(String nome, String funcao) {
        this.nome = nome;
        this.funcao = funcao;
    }

    public String getNome() {
        return nome;
    }

    public String getFuncao() {
        return funcao;
    }
}
