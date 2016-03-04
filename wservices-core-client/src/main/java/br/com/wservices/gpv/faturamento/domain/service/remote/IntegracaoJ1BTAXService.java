package br.com.wservices.gpv.faturamento.domain.service.remote;

import br.com.wservices.gpv.faturamento.domain.entity.NotaFiscal;

public interface IntegracaoJ1BTAXService {
	NotaFiscal calcularImposto(NotaFiscal notaFiscal);
}
