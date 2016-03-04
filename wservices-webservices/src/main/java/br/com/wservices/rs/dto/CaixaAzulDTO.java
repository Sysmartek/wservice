package br.com.wservices.rs.dto;

public class CaixaAzulDTO {

	private Long numeroCaixa;

	private String cnpjCD;

	private Long entrega;

	public Long getNumeroCaixa() {
		return numeroCaixa;
	}

	public String getCnpjCD() {
		return cnpjCD;
	}

	public Long getEntrega() {
		return entrega;
	}

	public void setNumeroCaixa(Long numeroCaixa) {
		this.numeroCaixa = numeroCaixa;
	}

	public void setCnpjCD(String cnpjCD) {
		this.cnpjCD = cnpjCD;
	}

	public void setEntrega(Long entrega) {
		this.entrega = entrega;
	}

}
