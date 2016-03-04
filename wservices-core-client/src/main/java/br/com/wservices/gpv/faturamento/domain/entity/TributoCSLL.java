package br.com.wservices.gpv.faturamento.domain.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TributoCSLL implements Tributo {

	@Column(name = "VAL_BASE_CSLL")
	private BigDecimal base;

	@Column(name = "VAL_ALIQUOTA_CSLL")
	private BigDecimal aliquota;

	@Column(name = "COD_CST_CSLL", length = 3)
	private String cst;

	@Column(name = "VAL_CSLL_RETIDO")
	private BigDecimal retidoNaFonte;

	@Override
	public BigDecimal getValor() {
		return null;
	}

	@Override
	public BigDecimal getBase() {
		return base;
	}

	@Override
	public void setBase(BigDecimal base) {
		this.base = base;
	}

	@Override
	public BigDecimal getAliquota() {
		return aliquota;
	}

	@Override
	public void setAliquota(BigDecimal aliquota) {
		this.aliquota = aliquota;
	}

	@Override
	public String getCst() {
		return cst;
	}

	@Override
	public void setCst(String cst) {
		this.cst = cst;
	}

	@Override
	public BigDecimal getRetidoNaFonte() {
		return retidoNaFonte;
	}
}
