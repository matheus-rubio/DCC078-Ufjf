package com.dcc.ufjf;

import java.io.FileOutputStream;
import java.security.InvalidParameterException;
import java.util.ArrayList;

public class GeradorDeRelatorio {

    private FabricaRelatorio fabrica;
    private FileOutputStream arquivoDeSaida;
    private ArrayList<Funcionario> funcionarios;

    public GeradorDeRelatorio (FabricaRelatorio fabrica, FileOutputStream arquivoDeSaida, ArrayList<Funcionario> funcionarios) {
        if (fabrica == null || arquivoDeSaida == null || funcionarios == null) {
            throw new IllegalArgumentException("Não foi possível construir o gerador de relatório, parametros inválidos!");
        }
        if (funcionarios.size() == 0) {
            throw new InvalidParameterException("A lista de funcionários informada está vazia");
        }
        this.fabrica = fabrica;
        this.arquivoDeSaida = arquivoDeSaida;
        this.funcionarios = funcionarios;
    }

    public String gerarRelatorio() throws Exception {
        Relatorio relatorio = fabrica.criarRelatorio();
        return relatorio.emitir(this.arquivoDeSaida, this.funcionarios);
    }
    
}
