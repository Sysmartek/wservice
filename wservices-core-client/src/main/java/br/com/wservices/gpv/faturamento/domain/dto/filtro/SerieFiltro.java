package br.com.wservices.gpv.faturamento.domain.dto.filtro;

import java.io.Serializable;

import br.com.wservices.gpv.faturamento.domain.entity.UnidadeFaturamento;

public class SerieFiltro implements Serializable {

	private static final long serialVersionUID = -8166750270544470317L;

	private Integer numeroSerie;

	private UnidadeFaturamento unidadeFaturamento;

	private String status;

	private Integer ultimoNumeroFaturado;

	public Integer getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(Integer numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public UnidadeFaturamento getUnidadeFaturamento() {
		return unidadeFaturamento;
	}

	public void setUnidadeFaturamento(UnidadeFaturamento unidadeFaturamento) {
		this.unidadeFaturamento = unidadeFaturamento;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getUltimoNumeroFaturado() {
		return ultimoNumeroFaturado;
	}

	public void setUltimoNumeroFaturado(Integer ultimoNumeroFaturado) {
		this.ultimoNumeroFaturado = ultimoNumeroFaturado;
	}

}
