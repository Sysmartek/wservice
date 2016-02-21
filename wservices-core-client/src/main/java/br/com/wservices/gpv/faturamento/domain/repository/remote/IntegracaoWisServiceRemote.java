package br.com.wservices.gpv.faturamento.domain.repository.remote;

import javax.ejb.Remote;

@Remote
public interface IntegracaoWisServiceRemote {
	String MAPPED_NAME = "IntegracaoWisServiceRemote";

	void liberarCaixaAzul(Long codigoCaixa, Integer codigoEmpresa, Integer codigoDeposito);
}
