package br.com.wservices.gpv.faturamento.domain.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.apache.commons.lang3.ObjectUtils;

@Embeddable
public class TributoCOFINS implements Tributo {

	private static final int FATOR_PERCENTUAL = 100;

	@Column(name = "VAL_BASE_COFINS")
	private BigDecimal base;

	@Column(name = "VAL_ALIQUOTA_COFINS")
	private BigDecimal aliquota;

	@Column(name = "COD_CST_COFINS", length = 3)
	private String cst;

	@Column(name = "VAL_CONFINS_RETIDO")
	private BigDecimal retidoNaFonte;

	@Override
	public BigDecimal getValor() {
		BigDecimal base = ObjectUtils.defaultIfNull(this.getBase(), BigDecimal.ZERO);
		BigDecimal aliquota = ObjectUtils.defaultIfNull(this.getAliquota(), BigDecimal.ZERO);
		return (base.multiply(aliquota)).divide(new BigDecimal(FATOR_PERCENTUAL));
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
