package br.com.wservices.gpv.core.domain.enumerations;

public enum TipoPessoa {

	F("core.pessoa.tipo.fisica"), J("core.pessoa.tipo.juridica");

	private String descricao;

	public String getDescricao() {
		return this.descricao;
	}

	private TipoPessoa(String descricao) {
		this.descricao = descricao;
	}
}
