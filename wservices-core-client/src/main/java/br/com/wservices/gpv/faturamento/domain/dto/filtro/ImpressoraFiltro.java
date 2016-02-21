package br.com.wservices.gpv.faturamento.domain.dto.filtro;

import java.io.Serializable;

public class ImpressoraFiltro implements Serializable {

	private static final long serialVersionUID = 1L;

	private String tipoImpressora;
	private String nome;

	public String getTipoImpressora() {
		return tipoImpressora;
	}

	public void setTipoImpressora(String tipoImpressora) {
		this.tipoImpressora = tipoImpressora;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
