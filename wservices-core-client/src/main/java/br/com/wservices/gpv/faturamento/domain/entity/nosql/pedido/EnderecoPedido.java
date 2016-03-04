package br.com.wservices.gpv.faturamento.domain.entity.nosql.pedido;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EnderecoPedido implements Serializable {

	private static final long serialVersionUID = 8370177070880171609L;

	@NotNull(message = "O logradouro não pode ser nulo")
	@Size(min = 1,  message = "O logradouro não não pode ser nulo")
	private String logradouro;

	@NotNull(message = "O numero não pode ser nulo")
	private Integer numero;

	private String complemento;

	@NotNull(message = "O bairro não pode ser nulo")
	@Size(min = 1,  message = "O bairro não não pode ser nulo")
	private String bairro;

	@NotNull(message = "O cep não pode ser nulo")
	@Size(min = 1,  message = "O cep não não pode ser nulo")
	private String cep;

	@NotNull(message = "A cidade não pode ser nulo")
	@Size(min = 1,  message = "A cidade não não pode ser nulo")
	private String cidade;

	private String municipio;

	@NotNull(message = "O estado não pode ser nulo")
	@Size(min = 1,  message = "O estado não não pode ser nulo")
	private String estado;

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
