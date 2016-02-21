package br.com.wservices.gpv.faturamento.domain.entity.nosql.xml;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class XmlSefaz implements Serializable {

	private static final long serialVersionUID = -2671432380546439192L;

	@Id
	private String chaveAcesso;

	private Integer codigoNotaFiscal;

	private String xml;

	public String getChaveAcesso() {
		return chaveAcesso;
	}

	public Integer getCodigoNotaFiscal() {
		return codigoNotaFiscal;
	}

	public String getXml() {
		return xml;
	}

	public void setChaveAcesso(String chaveAcesso) {
		this.chaveAcesso = chaveAcesso;
	}

	public void setCodigoNotaFiscal(Integer codigoNotaFiscal) {
		this.codigoNotaFiscal = codigoNotaFiscal;
	}

	public void setXml(String xml) {
		this.xml = xml;
	}

}
