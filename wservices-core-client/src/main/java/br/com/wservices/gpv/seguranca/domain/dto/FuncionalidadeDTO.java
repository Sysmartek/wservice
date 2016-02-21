package br.com.wservices.gpv.seguranca.domain.dto;

import java.io.Serializable;

public class FuncionalidadeDTO implements Serializable {

	private static final long serialVersionUID = 7964236417232307067L;

	private String chave;

	private String descricao;

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
