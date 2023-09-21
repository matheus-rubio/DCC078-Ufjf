package com.dcc.ufjf;

import java.io.FileOutputStream;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class RelatorioPDF implements Relatorio {

    @Override
    public String emitir(FileOutputStream arquivoPDF, ArrayList<Funcionario> funcionarios) throws Exception {
        Document documento = new Document();
        PdfWriter.getInstance(documento, arquivoPDF);

        documento.open();

        for (Funcionario funcionario : funcionarios) {
            Paragraph paragrafo = new Paragraph("Nome: " + funcionario.getNome() + " | " + "Horas Trabalhadas: " + funcionario.getHorasTrabalhadas());
            documento.add(paragrafo);
        }
        
        documento.close();
        arquivoPDF.close();

        return "Relatório em PDF gerado com sucesso.";
    }

}
