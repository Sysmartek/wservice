package br.com.wservices.gpv.faturamento.domain.entity.nosql.propriedadeSefaz;

import java.io.Serializable;

public class WebServiceEstado implements Serializable {

	private static final long serialVersionUID = 829130859583638142L;

	private String estado;

	private Integer cUF;

	private String caminho;

	public WebServiceEstado() {

	}

	public WebServiceEstado(String estado, String caminho) {
		super();
		this.estado = estado;
		this.caminho = caminho;
	}

	public String getEstado() {
		return estado;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public Integer getCUF() {
		return cUF;
	}

	public void setCUF(Integer cUF) {
		this.cUF = cUF;
	}

}
