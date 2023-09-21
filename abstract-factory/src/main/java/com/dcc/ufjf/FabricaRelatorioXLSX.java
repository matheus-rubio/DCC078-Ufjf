package com.dcc.ufjf;

public class FabricaRelatorioXLSX implements FabricaRelatorio {

	@Override
	public Relatorio criarRelatorio() {
		return new RelatorioXLSX();
	}
    
}
