package br.com.wservices.gpv.faturamento.domain.dto.filtro;

import java.io.Serializable;

import br.com.wservices.gpv.faturamento.domain.entity.UnidadeFaturamento;

public class CaixaFiltro implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer numero;

	private String nome;

	private UnidadeFaturamento unidadeFaturamento;

	private String status;

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

}
