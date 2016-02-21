package br.com.wservices.gpv.core.domain.repository.remote;

import javax.ejb.Remote;

import br.com.wservices.gpv.faturamento.domain.entity.NotaFiscal;

@Remote
public interface GerarXMLRemote {
	public static final String MAPPED_NAME = "GerarXmlRepository";
	
	public void gerar(Integer id);
	
	public void gerar(NotaFiscal notaFiscal);

	public void consumirRest();
	
	public void enviarMensagem();

}
