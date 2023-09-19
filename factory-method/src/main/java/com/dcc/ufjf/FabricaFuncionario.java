package com.dcc.ufjf;

import java.lang.reflect.Constructor;

public class FabricaFuncionario {

    public Funcionario criarFuncionario(String nome, String funcao) {
        Funcionario novoFuncionario = null;

        try {
            Class<?> classe = Class.forName("com.dcc.ufjf.tiposdefuncionario." + funcao);
            Constructor<?> constructor = classe.getConstructor(String.class);
            novoFuncionario = (Funcionario) constructor.newInstance(nome);
        } catch (Exception e) {
            throw new IllegalArgumentException("Tipo de funcionário não suportado: " + funcao);
        }

        return novoFuncionario;
    }
}