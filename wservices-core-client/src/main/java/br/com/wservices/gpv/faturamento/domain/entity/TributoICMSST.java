package br.com.wservices.gpv.faturamento.domain.entity;

import java.math.BigDecimal;

import javax.persistence.Column;

public class TributoICMSST implements Tributo {

	@Column(name = "VAL_BASE_ICMS_ST")
	private BigDecimal base;

	@Column(name = "VAL_ALIQUOTA_ICMS_ST")
	private BigDecimal aliquota;

	@Column(name = "COD_CST_ICMS_ST", length = 3)
	private String cst;

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
		return BigDecimal.ZERO;
	}

}
