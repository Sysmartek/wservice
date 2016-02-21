package br.com.wservices.gpv.faturamento.domain.repository;

import javax.ejb.Local;

import br.com.wservices.gpv.faturamento.domain.entity.nosql.xml.XmlSefaz;

@Local
public interface XmlSefazService {

	String MAPPED_NAME = "XmlSefazService";

	void salvar(XmlSefaz xmlSefaz);

	XmlSefaz findOne(String chaveAcesso);

	XmlSefaz findByCodigoNotaFiscal(Integer codigoNotaFiscal);
}
