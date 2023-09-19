package com.dcc.ufjf;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FuncionarioTest {

    private class FuncionarioFake extends Funcionario {
        public FuncionarioFake(String nome, String funcao) {
            super(nome, funcao);
        }
    }

    @Test
    public void testGetNome() {
        Funcionario funcionario = new FuncionarioFake("Alice", "Desenvolvedor");
        assertEquals("Alice", funcionario.getNome());
    }

    @Test
    public void testGetFuncao() {
        Funcionario funcionario = new FuncionarioFake("Bob", "Gerente");
        assertEquals("Gerente", funcionario.getFuncao());
    }
}
