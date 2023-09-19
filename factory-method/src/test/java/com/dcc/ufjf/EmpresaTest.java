package com.dcc.ufjf;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmpresaTest {

    private Empresa minhaEmpresa;
    private FabricaFuncionario fabrica;

    @BeforeEach
    public void setUp() {
        minhaEmpresa = new Empresa();
        fabrica = new FabricaFuncionario();
    }

    @Test
    public void testContratarFuncionario() {
        Funcionario funcionario1 = fabrica.criarFuncionario("Alice", "Desenvolvedor");
        Funcionario funcionario2 = fabrica.criarFuncionario("Bob", "Designer");

        minhaEmpresa.contratarFuncionario(funcionario1);
        minhaEmpresa.contratarFuncionario(funcionario2);

        ArrayList<Funcionario> funcionarios = minhaEmpresa.getFuncionarios();

        assertEquals(2, funcionarios.size());
        assertTrue(funcionarios.contains(funcionario1));
        assertTrue(funcionarios.contains(funcionario2));
    }

    @Test
    public void testContratarFuncionarioInvalido() {
        // Tenta contratar um funcionário com uma função inválida
        assertThrows(IllegalArgumentException.class, () -> {
            Funcionario funcionarioInvalido = fabrica.criarFuncionario("Carlos", "Vendedor");
            minhaEmpresa.contratarFuncionario(funcionarioInvalido);
        });

        ArrayList<Funcionario> funcionarios = minhaEmpresa.getFuncionarios();
        assertTrue(funcionarios.isEmpty());
    }

    @Test
    public void testGetFuncionariosVazio() {
        ArrayList<Funcionario> funcionarios = minhaEmpresa.getFuncionarios();
        assertTrue(funcionarios.isEmpty());
    }
}
