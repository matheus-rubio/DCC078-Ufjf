package com.dcc.ufjf;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {

    private Calculadora calculadora;

    @BeforeEach
    public void setUp() {
        calculadora = Calculadora.getInstance();
    }

    @Test
    public void testSoma() {
        double resultado = calculadora.somar(5, 7);
        assertEquals(12, resultado, 0.001);
        assertEquals("5.0 + 7.0 = 12.0", calculadora.getHistorico().get(0));
        calculadora.limparHistorico();
    }

    @Test
    public void testSubtracao() {
        double resultado = calculadora.subtrair(15, 7);
        assertEquals(8, resultado, 0.001);
        assertEquals("15.0 - 7.0 = 8.0", calculadora.getHistorico().get(0));
        calculadora.limparHistorico();
    }

    @Test
    public void testMultiplicacao() {
        double resultado = calculadora.multiplicar(4, 3);
        assertEquals(12, resultado, 0.001);
        assertEquals("4.0 * 3.0 = 12.0", calculadora.getHistorico().get(0));
        calculadora.limparHistorico();
    }

    @Test
    public void testDivisao() {
        double resultado = calculadora.dividir(20, 4);
        assertEquals(5, resultado, 0.001);
        assertEquals("20.0 / 4.0 = 5.0", calculadora.getHistorico().get(0));
        calculadora.limparHistorico();
    }

    @Test
    public void testDivisaoPorZero() {
        try {
            calculadora.dividir(10, 0);
            fail("Deveria lançar uma IllegalArgumentException");
        } catch (Exception e) {
            assertEquals(IllegalArgumentException.class, e.getClass());
            assertEquals(0, calculadora.getHistorico().size());
        }
    }

    @Test
    public void testHistoricoComMultiplasOperacoes() {
        calculadora.somar(5, 7);
        calculadora.subtrair(15, 7);
        calculadora.multiplicar(4, 3);
        calculadora.dividir(20, 4);

        List<String> historico = calculadora.getHistorico();

        assertEquals(4, historico.size());
        assertEquals("5.0 + 7.0 = 12.0", historico.get(0));
        assertEquals("15.0 - 7.0 = 8.0", historico.get(1));
        assertEquals("4.0 * 3.0 = 12.0", historico.get(2));
        assertEquals("20.0 / 4.0 = 5.0", historico.get(3));
        calculadora.limparHistorico();
    }
}
