package com.dcc.ufjf;

import java.io.FileOutputStream;
import java.util.ArrayList;

public interface Relatorio {
    public String emitir(FileOutputStream arquivoPDF, ArrayList<Funcionario> funcionarios) throws Exception;
}
