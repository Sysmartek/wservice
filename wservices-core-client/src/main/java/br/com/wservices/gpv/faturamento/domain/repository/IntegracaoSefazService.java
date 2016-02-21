package br.com.wservices.gpv.faturamento.domain.repository;

import javax.ejb.Local;
import javax.xml.stream.XMLStreamException;

import br.com.sysmartek.framework.exception.DomainException;
import br.com.sysmartek.framework.exception.InfrastructureException;
import br.com.wservices.gpv.core.domain.enumerations.TipoEvento;
import br.com.wservices.gpv.faturamento.domain.entity.NotaFiscal;

@Local
public interface IntegracaoSefazService {

	String MAPPED_NAME = "IntegracaoSefazService";

	void enviarNFe(NotaFiscal notaFiscal)  throws InfrastructureException,  DomainException,  XMLStreamException;

	void tramitarNotaFiscalComRetornoSefaz(NotaFiscal notaFiscal, String xmlRetorno, TipoEvento tipoEvento) throws InfrastructureException, DomainException;

}
