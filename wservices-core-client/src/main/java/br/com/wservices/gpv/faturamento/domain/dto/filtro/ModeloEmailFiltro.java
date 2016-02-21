package br.com.wservices.gpv.faturamento.domain.dto.filtro;

import java.io.Serializable;

import br.com.wservices.gpv.faturamento.domain.entity.UnidadeNegocio;

public class ModeloEmailFiltro implements Serializable {

	private String tipoModeloEmail;

	private UnidadeNegocio unidadeNegocio;

	public ModeloEmailFiltro() {

	}

	public ModeloEmailFiltro(String tipoModeloEmail, UnidadeNegocio unidadeNegocio) {
		super();
		this.tipoModeloEmail = tipoModeloEmail;
		this.unidadeNegocio = unidadeNegocio;
	}

	public String getTipoModeloEmail() {
		return tipoModeloEmail;
	}

	public void setTipoModeloEmail(String tipoModeloEmail) {
		this.tipoModeloEmail = tipoModeloEmail;
	}

	public UnidadeNegocio getUnidadeNegocio() {
		return unidadeNegocio;
	}

	public void setUnidadeNegocio(UnidadeNegocio unidadeNegocio) {
		this.unidadeNegocio = unidadeNegocio;
	}

}
