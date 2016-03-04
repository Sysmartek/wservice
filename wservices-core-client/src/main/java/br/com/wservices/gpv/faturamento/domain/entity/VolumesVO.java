package br.com.wservices.gpv.faturamento.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class VolumesVO implements Serializable {

	private static final long serialVersionUID = -3660704185909708689L;

	@Column(name = "VAL_PESO_LIQUIDO")
	private BigDecimal pesoLiquido;

	@Column(name = "VAL_PESO_BRUTO")
	private BigDecimal pesoBruto;

	@Column(name = "QTD_VOLUME")
	private Integer quantidade;

	public VolumesVO() {
	}

	public VolumesVO(BigDecimal pesoLiquido, BigDecimal pesoBruto, Integer quantidade) {
		super();
		this.pesoLiquido = pesoLiquido;
		this.pesoBruto = pesoBruto;
		this.quantidade = quantidade;
	}

	public BigDecimal getPesoLiquido() {
		return pesoLiquido;
	}

	public BigDecimal getPesoBruto() {
		return pesoBruto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setPesoLiquido(BigDecimal pesoLiquido) {
		this.pesoLiquido = pesoLiquido;
	}

	public void setPesoBruto(BigDecimal pesoBruto) {
		this.pesoBruto = pesoBruto;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

}
