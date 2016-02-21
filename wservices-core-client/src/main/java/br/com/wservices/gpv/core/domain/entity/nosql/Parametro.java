package br.com.wservices.gpv.core.domain.entity.nosql;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

public class Parametro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	private String chave;

	@NotNull
	private String valor;

	public Parametro() {
	}

	public Parametro(String chave, String valor) {
		this.chave = chave;
		this.valor = valor;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
}
