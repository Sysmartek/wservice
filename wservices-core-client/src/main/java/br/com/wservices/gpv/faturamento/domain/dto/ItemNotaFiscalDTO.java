package br.com.wservices.gpv.faturamento.domain.dto;

public class ItemNotaFiscalDTO {

	private Integer numeroSequencial;

	private Double quantidadeFisica;

	private String descricaoTecnica;

	private String ean;

	private String ncm;

	private String sku;

	public Integer getNumeroSequencial() {
		return numeroSequencial;
	}

	public void setNumeroSequencial(Integer numeroSequencial) {
		this.numeroSequencial = numeroSequencial;
	}

	public Double getQuantidadeFisica() {
		return quantidadeFisica;
	}

	public void setQuantidadeFisica(Double quantidadeFisica) {
		this.quantidadeFisica = quantidadeFisica;
	}

	public String getDescricaoTecnica() {
		return descricaoTecnica;
	}

	public void setDescricaoTecnica(String descricaoTecnica) {
		this.descricaoTecnica = descricaoTecnica;
	}

	public String getEan() {
		return ean;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}

	public String getNcm() {
		return ncm;
	}

	public void setNcm(String ncm) {
		this.ncm = ncm;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

}
