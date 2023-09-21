package com.dcc.ufjf;

public class FabricaRelatorioPDF implements FabricaRelatorio {

	@Override
	public Relatorio criarRelatorio() {
		return new RelatorioPDF();
	}
    
}
