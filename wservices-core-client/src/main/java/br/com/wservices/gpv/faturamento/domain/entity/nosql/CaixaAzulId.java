package br.com.wservices.gpv.faturamento.domain.entity.nosql;

import java.io.Serializable;

public class CaixaAzulId implements Serializable {

	private static final long serialVersionUID = -5721067007869415139L;

	private String cnpjUnidadeFaturamento;
	private Long numeroCaixa;

	public CaixaAzulId() {

	}

	public CaixaAzulId(String cnpjUnidadeFaturamento, Long numeroCaixa) {
		super();
		this.cnpjUnidadeFaturamento = cnpjUnidadeFaturamento;
		this.numeroCaixa = numeroCaixa;
	}

	public String getCnpjUnidadeFaturamento() {
		return cnpjUnidadeFaturamento;
	}

	public Long getNumeroCaixa() {
		return numeroCaixa;
	}

	public void setCnpjUnidadeFaturamento(String cnpjUnidadeFaturamento) {
		this.cnpjUnidadeFaturamento = cnpjUnidadeFaturamento;
	}

	public void setNumeroCaixa(Long numeroCaixa) {
		this.numeroCaixa = numeroCaixa;
	}

}
