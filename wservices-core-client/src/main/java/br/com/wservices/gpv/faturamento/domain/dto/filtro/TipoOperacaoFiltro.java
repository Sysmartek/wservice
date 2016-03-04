package br.com.wservices.gpv.faturamento.domain.dto.filtro;

import java.io.Serializable;

public class TipoOperacaoFiltro implements Serializable {

	private static final long serialVersionUID = -8166750270544470317L;

	private String categoria;

	private String natureza;

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getNatureza() {
		return natureza;
	}

	public void setNatureza(String natureza) {
		this.natureza = natureza;
	}

}
