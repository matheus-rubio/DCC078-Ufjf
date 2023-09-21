package com.dcc.ufjf;

public class Funcionario {
    private String nome;
    private int horasTrabalhadas;

    public Funcionario(String nome, int horasTrabalhadas) {
        this.nome = nome;
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public String getNome() {
        return nome;
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }
}
