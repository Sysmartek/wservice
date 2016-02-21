package br.com.wservices.gpv.faturamento.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public interface Tributo extends Serializable {

	BigDecimal getValor();

	BigDecimal getRetidoNaFonte();

	BigDecimal getBase();

	void setBase(BigDecimal base);

	BigDecimal getAliquota();

	void setAliquota(BigDecimal aliquota);

	String getCst();

	void setCst(String cst);

}
