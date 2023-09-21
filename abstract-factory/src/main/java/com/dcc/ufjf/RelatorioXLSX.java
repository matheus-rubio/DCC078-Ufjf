package com.dcc.ufjf;

import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RelatorioXLSX implements Relatorio {

	@Override
	public String emitir(FileOutputStream arquivoXLSX, ArrayList<Funcionario> funcionarios) throws Exception {
        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("Relatorio");

        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Nome");
        headerRow.createCell(1).setCellValue("Horas trabalhadas");

        int linhaAtual = 1;
        for (Funcionario funcionario : funcionarios) {
            Row dataRow = sheet.createRow(linhaAtual);
            dataRow.createCell(0).setCellValue(funcionario.getNome());
            dataRow.createCell(1).setCellValue(funcionario.getHorasTrabalhadas());
            linhaAtual++;
        }

        workbook.write(arquivoXLSX);
        workbook.close();

        return "Relatório em XLSX gerado com sucesso.";
    }
    
}
