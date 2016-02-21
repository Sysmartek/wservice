package br.com.wservices.gpv.faturamento.domain.entity.nosql;

import java.io.Serializable;

public class ControleEntrega implements Serializable {

	private static final long serialVersionUID = 6565924825323211487L;

	private Long codigoEntrega;

	private Boolean faturado = Boolean.FALSE;

	public ControleEntrega() {
		super();
	}

	public ControleEntrega(Long codigoEntrega, Boolean faturado) {
		super();
		this.codigoEntrega = codigoEntrega;
		this.faturado = faturado;
	}

	public Long getCodigoEntrega() {
		return codigoEntrega;
	}

	public Boolean getFaturado() {
		return faturado;
	}

	public void setCodigoEntrega(Long codigoEntrega) {
		this.codigoEntrega = codigoEntrega;
	}

	public void setFaturado(Boolean faturado) {
		this.faturado = faturado;
	}

}
