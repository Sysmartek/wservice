package br.com.wservices.gpv.seguranca.domain.dto;

import java.io.Serializable;

public class TelaDTO implements Serializable {

	private static final long serialVersionUID = 2861866642318004487L;

	private String url;

	private String chave;

	private String descricao;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
