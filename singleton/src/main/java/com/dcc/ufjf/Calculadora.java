package com.dcc.ufjf;

import java.util.ArrayList;
import java.util.List;

public class Calculadora {

    private static Calculadora calcInstance;
    private List<String> historico;

    private Calculadora() {
        historico = new ArrayList<>();
    }

    public static synchronized Calculadora getInstance() {
        if (calcInstance == null)
            calcInstance = new Calculadora();

        return calcInstance;
    }

    public double somar(double a, double b) {
        double resultado = a + b;
        historico.add(a + " + " + b + " = " + resultado);
        return resultado;
    }

    public double subtrair(double a, double b) {
        double resultado = a - b;
        historico.add(a + " - " + b + " = " + resultado);
        return resultado;
    }

    public double multiplicar(double a, double b) {
        double resultado = a * b;
        historico.add(a + " * " + b + " = " + resultado);
        return resultado;
    }

    public double dividir(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divisão por zero não é permitida.");
        }
        double resultado = a / b;
        historico.add(a + " / " + b + " = " + resultado);
        return resultado;
    }

    public List<String> getHistorico() {
        return historico;
    }

    public void limparHistorico() {
        historico.clear();
    }
}
