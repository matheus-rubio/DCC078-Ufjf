package com.dcc.ufjf;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GeradorDeRelatorioTest {

    private ArrayList<Funcionario> funcionarios;

    @BeforeEach
    public void setUp() throws FileNotFoundException {
        this.funcionarios = new ArrayList<Funcionario>();

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            String nome = "Funcionario" + i;
            int horasTrabalhadas = random.nextInt(40) + 1;
            this.funcionarios.add(new Funcionario(nome, horasTrabalhadas));
        }
    }

    @Test
    public void testGerarRelatorioPDFComSucesso() {
        try {
            FileOutputStream arquivoSaida = new FileOutputStream("relatorio.pdf");
            FabricaRelatorio fabrica = new FabricaRelatorioPDF();

            GeradorDeRelatorio gerador = new GeradorDeRelatorio(fabrica, arquivoSaida, funcionarios);
            String resultado = gerador.gerarRelatorio();

            assertEquals("Relatório em PDF gerado com sucesso.", resultado);
        } catch (Exception e) {
            fail("Erro ao criar ou escrever no arquivo.");
        }
    }

    @Test
    public void testGerarRelatorioXLSXComSucesso() {
        try {
            FileOutputStream arquivoSaida = new FileOutputStream("relatorio.xlsx");
            FabricaRelatorio fabrica = new FabricaRelatorioXLSX();

            GeradorDeRelatorio gerador = new GeradorDeRelatorio(fabrica, arquivoSaida, this.funcionarios);
            String resultado = gerador.gerarRelatorio();

            arquivoSaida.close();
            assertEquals("Relatório em XLSX gerado com sucesso.", resultado);
        } catch (Exception e) {
            fail("Erro ao criar ou escrever no arquivo: " + e);
        }
    }

    @Test
    public void testConstrutorComFabricaNula() {
        try {
            FileOutputStream arquivoSaida = new FileOutputStream("relatorio.pdf");
            new GeradorDeRelatorio(null, arquivoSaida, funcionarios);
            fail("Deveria lançar uma IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Não foi possível construir o gerador de relatório, parametros inválidos!", e.getMessage());
        } catch (FileNotFoundException e) {
            fail("Ocorreu algum erro ao criar o arquivo: " + e.getMessage());
        } 
    }

    @Test
    public void testConstrutorComArquivoNulo() {
        try {
            FabricaRelatorio fabrica = new FabricaRelatorioPDF();
            new GeradorDeRelatorio(fabrica, null, funcionarios);
            fail("Deveria lançar uma IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Não foi possível construir o gerador de relatório, parametros inválidos!", e.getMessage());
        }
    }

    @Test
    public void testConstrutorComFuncionariosNulo() {
        try {
            FileOutputStream arquivoSaida = new FileOutputStream("relatorio.pdf");
            FabricaRelatorio fabrica = new FabricaRelatorioPDF();
            new GeradorDeRelatorio(fabrica, arquivoSaida, null);
            fail("Deveria lançar uma IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Não foi possível construir o gerador de relatório, parametros inválidos!", e.getMessage());
        } catch (FileNotFoundException e) {
            fail("Ocorreu algum erro ao criar o arquivo.");
        } 
    }
}
