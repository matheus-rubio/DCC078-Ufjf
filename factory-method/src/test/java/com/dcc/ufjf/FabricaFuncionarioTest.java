package com.dcc.ufjf;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FabricaFuncionarioTest {

    @Test
    public void testCriarDesenvolvedor() {
        FabricaFuncionario fabrica = new FabricaFuncionario();
        Funcionario funcionario = fabrica.criarFuncionario("Alice", "Desenvolvedor");

        assertEquals("Alice", funcionario.getNome());
        assertEquals("Desenvolvedor", funcionario.getFuncao());
    }

    @Test
    public void testCriarDesigner() {
        FabricaFuncionario fabrica = new FabricaFuncionario();
        Funcionario funcionario = fabrica.criarFuncionario("Bob", "Designer");

        assertEquals("Bob", funcionario.getNome());
        assertEquals("Designer", funcionario.getFuncao());
    }

    @Test
    public void testCriarGerente() {
        FabricaFuncionario fabrica = new FabricaFuncionario();
        Funcionario funcionario = fabrica.criarFuncionario("Charlie", "Gerente");

        assertEquals("Charlie", funcionario.getNome());
        assertEquals("Gerente", funcionario.getFuncao());
    }

    @Test
    public void testCriarFuncionarioInvalido() {
        FabricaFuncionario fabrica = new FabricaFuncionario();

        try {
            Funcionario funcionario = fabrica.criarFuncionario("David", "Vendedor");
            fail("Deveria lançar uma IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Tipo de funcionário não suportado: Vendedor", e.getMessage());
        }
    }
}
