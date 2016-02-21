package br.com.wservices.gpv.faturamento.domain.dto.filtro;

import java.io.Serializable;

import br.com.wservices.gpv.core.domain.enumerations.TipoEvento;
import br.com.wservices.gpv.faturamento.domain.entity.Caixa;

public class NotaFiscalFiltro implements Serializable {

	private static final long serialVersionUID = 1L;

	private Caixa caixa;

	private TipoEvento status;

	public Caixa getCaixa() {
		return caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}

	public TipoEvento getStatus() {
		return status;
	}

	public void setStatus(TipoEvento status) {
		this.status = status;
	}

}
