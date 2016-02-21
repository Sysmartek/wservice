package br.com.wservices.gpv.core.domain.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class EnderecoVO implements Serializable {

	private static final long serialVersionUID = 8370177070880171609L;

	@Column(name = "DES_LOGRADOURO")
	private String logradouro;

	@Column(name = "NRO_NUMERO")
	private Integer numero;

	@Column(name = "NRO_NUMERO_INTERNO")
	private Integer numeroInterno;

	@Column(name = "DES_COMPLEMENTO")
	private String complemento;

	@Column(name = "DES_BAIRRO")
	private String bairro;

	@Column(name = "DES_CEP")
	private String cep;

	@Column(name = "DES_CIDADE")
	private String cidade;

	@Column(name = "DES_MUNICIPIO")
	private String municipio;

	@Transient
	private Integer codigoIbgeCidade;

	@Transient
	private Integer codigoIbgeEstado;

	@Column(name = "SGL_ESTADO")
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

	public Integer getNumeroInterno() {
		return numeroInterno;
	}

	public void setNumeroInterno(Integer numeroInterno) {
		this.numeroInterno = numeroInterno;
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

	public Integer getCodigoIbgeCidade() {
		return codigoIbgeCidade;
	}

	public Integer getCodigoIbgeEstado() {
		return codigoIbgeEstado;
	}

	public void setCodigoIbgeCidade(Integer codigoIbgeCidade) {
		this.codigoIbgeCidade = codigoIbgeCidade;
	}

	public void setCodigoIbgeEstado(Integer codigoIbgeEstado) {
		this.codigoIbgeEstado = codigoIbgeEstado;
	}

}
