package com.dcc.ufjf;

import java.util.ArrayList;

public class Empresa {
    private ArrayList<Funcionario> funcionarios;

    public Empresa() {
        funcionarios = new ArrayList<Funcionario>();
    }

    public void contratarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }
}
